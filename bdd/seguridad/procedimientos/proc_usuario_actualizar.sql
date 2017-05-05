/* 
Nombre: proc_usuario_actualizar
Descripción: Actualiza el registro de usuario
	
************** Histórico **************
Fecha		 siglas/nombre		 Descripción
21/04/2017	 Paul Salgado		 modificacion de acuerdo a nuevos estandares

*/

CREATE PROCEDURE [seguridad].[proc_usuario_actualizar]
@AS_USU_USUARIO VARCHAR(15),
@AI_ID_OFICINA INTEGER,
@AI_ESTADO int,
@AS_EMAIL VARCHAR(100),
@AB_CAMBIAR_PWD_PRX_LOGON BIT,
@AB_NO_PUEDE_CAMBIAR_PWD BIT,
@AB_PWD_NUNCA_EXPIRA BIT,
@AB_BLOQUEADA BIT,
@AI_ID INT,
@AS_IDENTIFICACION VARCHAR(15),
@AB_CUALQUIER_ESTACION BIT,
@AI_TIEMPO_INACTIVIDAD INT,
@AS_USUARIO_ACT VARCHAR(15),
@AS_DIRECCION_FISICA varchar(20),
@AS_MSJ VARCHAR(100) OUTPUT,
@AI_ID_HORARIO INT, 
@AI_ID_ESTRUCTURA INT,
@AS_USUARIO_SUPERIOR VARCHAR(15),
@AI_ID_DASHBOARD_INICIO INT
AS

DECLARE @LS_USUARIO VARCHAR(15)
SELECT @LS_USUARIO = usuario.id_usuario
FROM seguridad.usuario
WHERE usuario.usuario_secuencial = @AI_ID
IF @LS_USUARIO <> @AS_USU_USUARIO
BEGIN
	IF EXISTS ( SELECT 1
				FROM seguridad.usuario
				WHERE usuario.usuario_secuencial <> @AI_ID 
				AND usuario.id_usuario = @AS_USU_USUARIO )
	BEGIN
		SET @AS_MSJ = 'USUARIO YA EXISTE'
		RETURN -1 
	END
END
IF ( @AS_USU_USUARIO IS NULL OR @AS_USU_USUARIO = '')
BEGIN
	SET @AS_MSJ = ' INGRESE USUARIO, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AI_ESTADO IS NULL )
BEGIN
	SET @AS_MSJ = ' INGRESE ESTADO, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AB_CAMBIAR_PWD_PRX_LOGON IS NULL )
BEGIN
	SET @AS_MSJ = ' INGRESE CAMBIAR PWD PRX LOGON, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AB_NO_PUEDE_CAMBIAR_PWD IS NULL )
BEGIN
	SET @AS_MSJ = ' INGRESE NO PUEDE CAMBIAR PWD, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AB_PWD_NUNCA_EXPIRA IS NULL )
BEGIN
	SET @AS_MSJ = ' INGRESE PWD NUNCA EXPIRA, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AB_BLOQUEADA IS NULL )
BEGIN
	SET @AS_MSJ = ' INGRESE BLOQUEADA, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AB_CUALQUIER_ESTACION IS NULL )
BEGIN
	SET @AS_MSJ = ' INGRESE CUALQUIER ESTACION, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AB_CUALQUIER_ESTACION IS NULL )
BEGIN
	SET @AS_MSJ = ' INGRESE CUALQUIER ESTACION, NO PUEDE SER NULO'
	RETURN -1
END
IF ( @AI_TIEMPO_INACTIVIDAD IS NULL AND @AI_TIEMPO_INACTIVIDAD > 0 )
BEGIN
	SET @AS_MSJ = ' INGRESE TIEMPO INACTIVIDAD, NO PUEDE SER NULO'
	RETURN -1
END
IF NOT EXISTS ( SELECT 1
				 FROM seguridad.estado_usuario
				WHERE estado_usuario.id_estado_usuario = @AI_ESTADO )
BEGIN
	SET @AS_MSJ = 'INGRESE UN ESTADO VALIDO'
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
IF NOT @AS_USUARIO_SUPERIOR  IS NULL
BEGIN
	IF NOT EXISTS  ( SELECT 1
						FROM seguridad.usuario
						WHERE usuario.id_usuario = @AS_USUARIO_SUPERIOR  )
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
					FROM [gerencial].[dashboard]
					WHERE id_dashboard = @AI_ID_DASHBOARD_INICIO )
BEGIN
	SET @AS_MSJ = 'INGRESE EL DASHBOARD DE INICIO VALIDO'
	RETURN -1
END
DECLARE @LS_ANTERIOR VARCHAR(100),
	@LS_NUEVO VARCHAR(100),
	@LI_RET  INT,
	@LI_CAMB INT
SELECT 	@LS_ANTERIOR = usuario.id_oficina,
	@LS_NUEVO = @AI_ID_OFICINA
FROM seguridad.usuario
WHERE usuario.usuario_secuencial = @AI_ID
IF @LS_ANTERIOR <> @LS_NUEVO
BEGIN
	EXEC @LI_RET = seguridad.proc_usuario_cambio_insertar
	@AI_ID = @LI_CAMB OUTPUT,
	@AS_USUARIO = @AS_USU_USUARIO,
	@AS_TIPO = 'CAMBIO OFICINA',
	@AS_ANTERIOR = @LS_ANTERIOR,
	@AS_NUEVO = @LS_NUEVO,
	@AS_USUARIO_ACT = @AS_USUARIO_ACT,
	@AS_MSJ = @AS_MSJ OUTPUT
	IF @LI_RET = -1
		RETURN -1
END
SELECT 	@LS_ANTERIOR = usuario.bloqueada,
	@LS_NUEVO = @AB_BLOQUEADA
FROM seguridad.usuario
WHERE usuario.usuario_secuencial = @AI_ID
IF @LS_ANTERIOR <> @LS_NUEVO
BEGIN
	EXEC @LI_RET = seguridad.proc_usuario_cambio_insertar
	@AI_ID = @LI_CAMB OUTPUT,
	@AS_USUARIO = @AS_USU_USUARIO,
	@AS_TIPO = 'DESBLOQUEAR',
	@AS_ANTERIOR = @LS_ANTERIOR,
	@AS_NUEVO = @LS_NUEVO,
	@AS_USUARIO_ACT = @AS_USUARIO_ACT,
	@AS_MSJ = @AS_MSJ OUTPUT
	IF @LI_RET = -1
		RETURN -1
END
SELECT 	@LS_ANTERIOR = usuario.id_estado_usuario,
	@LS_NUEVO = @AI_ESTADO
FROM seguridad.usuario
WHERE usuario.usuario_secuencial = @AI_ID
IF @LS_ANTERIOR <> @LS_NUEVO
BEGIN
	EXEC @LI_RET = seguridad.proc_usuario_cambio_insertar
	@AI_ID = @LI_CAMB OUTPUT,
	@AS_USUARIO = @AS_USU_USUARIO,
	@AS_TIPO = 'ESTADO',
	@AS_ANTERIOR = @LS_ANTERIOR,
	@AS_NUEVO = @LS_NUEVO,
	@AS_USUARIO_ACT = @AS_USUARIO_ACT,
	@AS_MSJ = @AS_MSJ OUTPUT
	IF @LI_RET = -1
		RETURN -1
END
UPDATE seguridad.usuario
SET 
	 usuario.id_oficina = @AI_ID_OFICINA,
	 usuario.id_estado_usuario = @AI_ESTADO, 
	 usuario.email = @AS_EMAIL, 
	 usuario.cambiar_pwd_proximo_logon = @AB_CAMBIAR_PWD_PRX_LOGON, 
	 usuario.no_puede_cambiar_pwd = @AB_NO_PUEDE_CAMBIAR_PWD, 
	 usuario.pwd_nunca_expira = @AB_PWD_NUNCA_EXPIRA, 
	 usuario.bloqueada = @AB_BLOQUEADA, 
	 usuario.identificacion = @AS_IDENTIFICACION, 
	 usuario.cualquier_estacion = @AB_CUALQUIER_ESTACION, 
	 usuario.tiempo_inactividad = @AI_TIEMPO_INACTIVIDAD,
	 modifica_usuario = @AS_USUARIO_ACT, 
	 modifica_fecha = GETDATE(),
	 modifica_equipo = @AS_DIRECCION_FISICA,
	 usuario.id_horario = @AI_ID_HORARIO,
	 usuario.id_estructura_organizacional = @AI_ID_ESTRUCTURA,
	 usuario.id_usuario_padre = @AS_USUARIO_SUPERIOR,
	 usuario.id_dashboard_inicio = @AI_ID_DASHBOARD_INICIO 
WHERE 
	 usuario.usuario_secuencial = @AI_ID AND usuario.id_usuario = @AS_USU_USUARIO
IF ( @@ERROR<> 0 )
BEGIN
	SET @AS_MSJ = 'ERROR AL ACTUALIZAR seguridad.usuario'
	RETURN -1
END
RETURN 1


GO