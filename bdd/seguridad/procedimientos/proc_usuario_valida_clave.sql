USE [siisspolweb]
GO
/****** Object:  StoredProcedure [seguridad].[proc_usuario_valida_clave]    Script Date: 20/04/2017 10:03:56 ******/
/**
*	Modificacion de id_estado a id_estado_usuario por cambio de nombre de campo en EstadoUsuario
*	Modificacion del estado de tipo varchar 'A' a tipo entero 1
**/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [seguridad].[proc_usuario_valida_clave]
@AS_USU_USUARIO VARCHAR(15),
@AB_VALIDA_HOSTNAME BIT ,
@AS_HOSTNAME VARCHAR(50) ,
@AS_CLAVE VARCHAR(100),
@AS_USUARIO VARCHAR(20),
@AD_FECHA DATETIME,
@AS_EQUIPO VARCHAR(20),
@AB_REQ_CAMBIO_PWD int OUTPUT,
@AS_MSJ VARCHAR(100) OUTPUT
AS
DECLARE @AI_INTENTO INT,@AB_EST_USUARIO BIT, @AB_BLOQ_USUARIO BIT,
@LB_REVISAR_FECHA_SERVER BIT,
@LDT_FECHA_SERVER DATETIME,
@LDT_FECHA_SISTEMA DATETIME,
@HAB_BLOQUEO BIT, @LI_INTENTO_MAX INT , @TIEMPO_VALIDEZ_CLAVE INT;

SET @LB_REVISAR_FECHA_SERVER = seguridad.func_parametro_b('CI_CTRL_FECHA_SERVER')
/*
FECHA		AUTOR			DESCRIPCION
27/04/20017	carlos.calo		Primera version
*/
SET @AB_REQ_CAMBIO_PWD = 0
IF NOT EXISTS (SELECT 1
			FROM seguridad.usuario
			WHERE usuario.id_usuario = @AS_USU_USUARIO  )
BEGIN
	SET @AS_MSJ = 'USUARIO NO EXISTE'
	RETURN -1
END

SELECT @AB_EST_USUARIO = id_estado_usuario,@AB_BLOQ_USUARIO = bloqueada FROM seguridad.usuario WHERE usuario.id_usuario = @AS_USU_USUARIO  ;

IF (@AB_EST_USUARIO = 1)
BEGIN
	SET @AS_MSJ = 'USUARIO NO ESTA ACTIVO'
	RETURN -1
END

IF(@AB_BLOQ_USUARIO = 1)
BEGIN
	EXEC seguridad.proc_usuario_verificar_bloqueo 0,@AS_USU_USUARIO, @AS_USUARIO, @AD_FECHA, @AS_EQUIPO, @AS_MSJ OUTPUT;
END	

/*
IF EXISTS (SELECT 1
	FROM seguridad.usuario
	WHERE usuario.id_usuario = @AS_USU_USUARIO
	AND usuario.id_estado_usuario = 1 
	AND usuario.bloqueada = 1 )
BEGIN
	SET @AS_MSJ = 'Cuenta bloqueada'
	RETURN -1
END
*/

SELECT @HAB_BLOQUEO = ISNULL(habilitar_bloqueo, 0), @LI_INTENTO_MAX  = ISNULL(numero_intento, 0), @TIEMPO_VALIDEZ_CLAVE = ISNULL(tiempo_validez_clave, 0)
	FROM seguridad.politica_clave WHERE defecto = 1 ;

IF (SELECT pwdcompare ( @AS_CLAVE, usuario.clave)
	FROM seguridad.usuario
	WHERE usuario.id_usuario = @AS_USU_USUARIO ) = 0
BEGIN
	SET @AS_MSJ = 'Contrasena Incorrecta';	
	SELECT @AI_INTENTO = intento_fallido FROM seguridad.usuario WHERE id_usuario = @AS_USU_USUARIO;

	IF @HAB_BLOQUEO = 1
	BEGIN
		UPDATE seguridad.usuario
			SET usuario.intento_fallido = ISNULL(intento_fallido,0) + 1,modifica_usuario = @AS_USUARIO, modifica_fecha = @AD_FECHA, modifica_equipo = @AS_EQUIPO
			WHERE usuario.id_usuario = @AS_USU_USUARIO
			AND usuario.id_estado_usuario = 1 

		IF @AI_INTENTO >= @LI_INTENTO_MAX  
		BEGIN
			UPDATE seguridad.usuario
			SET usuario.bloqueada = 1,modifica_usuario = @AS_USUARIO, modifica_fecha = @AD_FECHA, modifica_equipo = @AS_EQUIPO, fecha_fallido = @AD_FECHA
			WHERE usuario.id_usuario = @AS_USU_USUARIO
			AND usuario.id_estado_usuario = 1 
			
			IF @@ERROR <> 0
			BEGIN
				SET @AS_MSJ = 'Error '
				RETURN -1
			END
	
			DECLARE @LS_MSJ VARCHAR(100)
			SET @LS_MSJ = 'Usuario bloqueado, (' + CONVERT (VARCHAR, @AI_INTENTO) + ' intentos fallidos)'
			EXEC auditoria.proc_log @LS_MSJ, @AS_USU_USUARIO, 'UBQ', @AS_USU_USUARIO, @AS_HOSTNAME
			SET @AS_MSJ = 'Clave incorrecta, la cuenta ha sido bloqueada.'
		END
	END
	RETURN -1
END
IF ( SELECT usuario.cambiar_pwd_proximo_logon
	FROM seguridad.usuario
	WHERE usuario.id_usuario = @AS_USU_USUARIO ) = 1
	SET @AB_REQ_CAMBIO_PWD = 1

IF ( SELECT usuario.pwd_nunca_expira
	FROM seguridad.usuario
	WHERE usuario.id_usuario = @AS_USU_USUARIO ) = 1
BEGIN
	SET @AB_REQ_CAMBIO_PWD = 0
END
ELSE
BEGIN
	IF @TIEMPO_VALIDEZ_CLAVE > 0
	BEGIN
		IF ( SELECT DATEADD ( ss, @TIEMPO_VALIDEZ_CLAVE, usuario.fecha_ultimo_cambio_pwd)
			FROM seguridad.usuario
			WHERE usuario.id_usuario = @AS_USU_USUARIO ) <= @AD_FECHA
		BEGIN
			SET @AB_REQ_CAMBIO_PWD = 1
		END
	END
	
END
IF @AB_VALIDA_HOSTNAME = 1
BEGIN
	-- SI TIENE QUE CONECTARSE DESDE UNA ESTACION DE TRABAJO ESPECIFICA
	IF EXISTS ( SELECT 1
				FROM seguridad.usuario
				WHERE usuario.id_usuario = @AS_USU_USUARIO 
				AND usuario.cualquier_estacion = 0 )
	BEGIN
		IF NOT EXISTS ( 
			SELECT *
			FROM seguridad.estacion_usuario
			WHERE estacion_usuario.id_usuario = @AS_USU_USUARIO )
		BEGIN
			SET @AS_MSJ = 'NO EXISTEN ESTACION DE TRABAJO DEFINIDAS PARA EL USUARIO *'
			RETURN -1
		END
		-- VERIFICA QUE SEA LA ESTACION ESTABLECIDA
		IF NOT EXISTS ( 
			SELECT *
			FROM seguridad.usuario,  seguridad.estacion,  seguridad.estacion_usuario
			WHERE usuario.id_usuario = @AS_USU_USUARIO 
			AND usuario.id_usuario = estacion_usuario.id_usuario
			AND estacion_usuario.id_estacion = estacion.id_estacion  
			AND ( ( 
						UPPER ( RTRIM ( estacion.hostname ) ) = UPPER ( RTRIM ( @AS_HOSTNAME ) ) 
						) OR
			( UPPER ( RTRIM ( estacion.ip ) ) = UPPER ( RTRIM ( @AS_HOSTNAME ) ) ) ) )
		BEGIN
			SET @AS_MSJ = 'NO PUEDE CONECTARSE DESDE ESTA ESTACION DE TRABAJO'
			RETURN -1
		END
	END
END			
IF @LB_REVISAR_FECHA_SERVER = 1 AND @AS_USU_USUARIO <> 'ADMIN'
BEGIN
	set @LDT_FECHA_SERVER = convert(datetime,CONVERT(varchar,getdate(),112))
	set @LDT_FECHA_SISTEMA = comun.func_fecha_sistema()
	if @LDT_FECHA_SERVER > @LDT_FECHA_SISTEMA 
	BEGIN
		SET @AS_MSJ = 'NO SE HA REALIZADO EL CIERRE DIARIO. REVISE'
		RETURN -1
	END	
END
IF NOT EXISTS ( SELECT * 
			FROM seguridad.usuario
			WHERE seguridad.func_horario_validar(usuario.id_horario) = 1
			AND usuario.id_usuario = @AS_USU_USUARIO ) 
BEGIN
	SET @AS_MSJ = 'HORARIO NO PERMITIDO'
	RETURN -1
END		
RETURN 1

