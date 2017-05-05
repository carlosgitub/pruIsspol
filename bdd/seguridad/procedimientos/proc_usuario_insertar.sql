/* 
Nombre: proc_usuario_insertar
Descripción: Crea un registro en la tabla seguridad.usuario
	
************** Histórico **************
Fecha		 siglas/nombre		 Descripción
13/04/2017	 Juan Portero		 Primera versión
19/04/2017	 Juan Portero		 Cambiar el campo id_persona por id_persona_subtipo_afiliacion
*/
CREATE PROCEDURE [seguridad].[proc_usuario_insertar]
@AS_USU_USUARIO VARCHAR(20),
@AI_ID_OFICINA INT, 
@AI_ID_PERSONA_SUBTIPO_AFILIACION INT, 
@AI_ESTADO INT, 
@AS_EMAIL VARCHAR(100) ,
@AS_IDENTIFICACION VARCHAR(15) ,
@AI_SECUENCIAL INT OUTPUT,
@AB_CUALQUIER_ESTACION BIT = 1,
@AI_ID_HORARIO INT,
@AI_ID_ESTRUCTURA INT,
@AS_USUARIO_SUPERIOR VARCHAR(20),
@AI_ID_DASHBOARD_INICIO INT,
@AS_USUARIO varchar(20),
@AS_DIRECCION_FISICA varchar(20),
@AS_MSJ varchar(100) OUTPUT
AS
IF @AS_USU_USUARIO = '' OR @AS_USU_USUARIO IS NULL
BEGIN
	SET @AS_MSJ = 'INGRESE UN USUARIO VALIDO'
	RETURN -1
END
IF EXISTS ( SELECT 1 FROM seguridad.usuario 
		WHERE usuario.id_usuario = @AS_USU_USUARIO )
BEGIN
	SET @AS_MSJ = 'USUARIO YA EXISTE '
	RETURN -1
END
IF NOT EXISTS ( SELECT 1 FROM seguridad.oficina
				WHERE oficina.id_oficina = @AI_ID_OFICINA  )
BEGIN
	SET @AS_MSJ = 'INGRESE OFICINA VALIDA'
	RETURN -1
END
IF @AI_ID_PERSONA_SUBTIPO_AFILIACION  IS NULL
BEGIN
	SET @AS_MSJ = 'INGRESE UNA PERSONA VALIDA'
	RETURN -1
END
IF NOT EXISTS ( SELECT 1
				 FROM seguridad.estado_usuario
				WHERE estado_usuario.id_estado_usuario=  @AI_ESTADO )
BEGIN
	SET @AS_MSJ = 'INGRESE UN ESTADO VALIDO'
	RETURN -1
END
IF NOT EXISTS ( SELECT 1
				 FROM seguridad.estado_usuario
				WHERE estado_usuario.id_estado_usuario=  @AI_ESTADO )
BEGIN
	SET @AS_MSJ = 'INGRESE UN ESTADO VALIDO'
	RETURN -1
END
IF @AB_CUALQUIER_ESTACION  IS NULL
BEGIN
	SET @AS_MSJ = 'INGRESE SI PUEDE INGRESAR DESDE UNA ESTACION ESPECIFICA'
	RETURN -1
END
IF NOT EXISTS  ( SELECT 1
					FROM seguridad.horario
					WHERE horario.id_horario = @AI_ID_HORARIO )
BEGIN
	SET @AS_MSJ = 'INGRESE UN HORARIO VALIDO'
	RETURN -1
END
IF NOT EXISTS  ( SELECT 1
					FROM seguridad.estructura_organizacional
					WHERE estructura_organizacional.id_estructura_organizacional = @AI_ID_ESTRUCTURA  )
BEGIN
	SET @AS_MSJ = 'INGRESE EL CARGO DENTRO DE LA ESTRUCTURA ORGANIZACIONAL'
	RETURN -1
END
IF NOT @AS_USUARIO_SUPERIOR IS NULL
BEGIN
	IF NOT EXISTS  ( SELECT 1
						FROM seguridad.usuario
						WHERE usuario.id_usuario = @AS_USUARIO_SUPERIOR )
	BEGIN
		SET @AS_MSJ = 'INGRESE USUARIO SUPERIOR VALIDO'
		RETURN -1
	END
	
	DECLARE @LI_ID_ESTRUCTURA_SUPERIOR INT 
	
	SELECT @LI_ID_ESTRUCTURA_SUPERIOR = usuario.id_estructura_organizacional
	FROM seguridad.usuario
	WHERE usuario.id_usuario = @AS_USUARIO_SUPERIOR
	
	IF NOT EXISTS ( SELECT *
						FROM seguridad.estructura_organizacional
						WHERE estructura_organizacional.id_estructura_organizacional = @AI_ID_ESTRUCTURA
						AND estructura_organizacional.id_estructura_organizacional_padre = @LI_ID_ESTRUCTURA_SUPERIOR )
	BEGIN
		SET @AS_MSJ = 'VERIFIQUE EL CARGO O EL USUARIO SUPERIOR NO CORRESPONDE'
		RETURN -1
	END
	
	
END
IF NOT EXISTS  ( SELECT 1
					FROM gerencial.dashboard
					WHERE id_dashboard = @AI_ID_DASHBOARD_INICIO )
BEGIN
	SET @AS_MSJ = 'INGRESE EL DASHBOARD DE INICIO VALIDO'
	RETURN -1
END
DECLARE @LS_CLAVE_GENERAL VARCHAR(10),
		@LI_TIEMPO_INACTIVIDAD INT
SELECT @LS_CLAVE_GENERAL = comun.func_parametro_s ('CLAVEINI')
SET @LI_TIEMPO_INACTIVIDAD = comun.func_parametro_i ('SE_TIEMPO_INACT')
EXEC @AI_SECUENCIAL = comun.proc_siguiente_secuencial 'usuario_secuencial'


INSERT  INTO seguridad.usuario
        ( usuario.[id_usuario] ,
          usuario.id_oficina ,
          usuario.id_persona_subtipo_afiliacion ,
          usuario.id_estado_usuario ,
          usuario.clave ,
          usuario.email ,
          usuario.cambiar_pwd_proximo_logon ,
          usuario.no_puede_cambiar_pwd ,
          usuario.pwd_nunca_expira ,
          usuario.bloqueada ,
          usuario.identificacion ,
          usuario.usuario_secuencial ,
          usuario.cualquier_estacion ,
          usuario.tiempo_inactividad ,
          usuario.id_horario ,
          usuario.id_estructura_organizacional ,
          usuario.id_usuario_padre ,
          usuario.id_dashboard_inicio ,
					creacion_usuario,
					creacion_fecha,
					creacion_equipo,
					modifica_usuario,
					modifica_fecha,
					modifica_equipo
        )
VALUES  ( @AS_USU_USUARIO ,
          @AI_ID_OFICINA ,
          @AI_ID_PERSONA_SUBTIPO_AFILIACION ,
          @AI_ESTADO ,
          CONVERT(VARBINARY(256), PWDENCRYPT(@LS_CLAVE_GENERAL)) ,
          @AS_EMAIL ,
          1 ,
          0 ,
          0 ,
          0 ,
          @AS_IDENTIFICACION ,
          @AI_SECUENCIAL ,
          @AB_CUALQUIER_ESTACION ,
          @LI_TIEMPO_INACTIVIDAD ,
          @AI_ID_HORARIO ,
          @AI_ID_ESTRUCTURA ,
          @AS_USUARIO_SUPERIOR ,
          @AI_ID_DASHBOARD_INICIO ,
          @AS_USUARIO ,
          getdate() ,
          @AS_DIRECCION_FISICA ,
          @AS_USUARIO ,
          GETDATE() ,
          @AS_DIRECCION_FISICA
        );
IF @@ERROR <> 0
    BEGIN
        SET @AS_MSJ = 'ERROR AL INSERTAR USUARIO ';
        RETURN -1;
    END;
RETURN 1;






GO