USE [siisspolweb]
GO
/****** Object:  StoredProcedure [seguridad].[proc_usuario_cambiar_clave]    Script Date: 27/04/2017 16:38:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [seguridad].[proc_usuario_cambiar_clave]
@AS_TOKEN VARCHAR(150),
@AS_USU_CLAVE VARCHAR(100),
@AS_USUARIO varchar(20),
@AD_FECHA DATETIME,
@AS_EQUIPO VARCHAR(20),
@AS_MSJ varchar(100) OUTPUT
AS
DECLARE @AS_USU_USUARIO VARCHAR(20)

SELECT @AS_USU_USUARIO = id_usuario FROM seguridad.token WHERE dato = @AS_TOKEN AND eliminado = 0;

IF (@AS_USU_USUARIO IS NULL OR @AS_USU_USUARIO = '')
BEGIN
	SET @AS_MSJ = 'Usuario y/o Token no existe.'
	RETURN -1
END
IF NOT EXISTS (SELECT 1
			FROM seguridad.usuario
			WHERE usuario.id_usuario = @AS_USU_USUARIO
			AND usuario.eliminado = 0   )
BEGIN
	SET @AS_MSJ = 'Usuario no esta Activo'
	RETURN -1
END
IF EXISTS (SELECT 1
			FROM seguridad.usuario
			WHERE usuario.id_usuario = @AS_USU_USUARIO 
			AND usuario.no_puede_cambiar_pwd = 1 
			AND @AS_USUARIO = @AS_USU_USUARIO )
BEGIN
	SET @AS_MSJ = 'Usuario no puede cambiar la Contrasena'
	RETURN -1
END


DECLARE @VER_SINTETICA BIT,@LON_CLAVE  INT,
	@HAB_HISTORIAL BIT, @LON_HISTORIAL INT, @LI INT, @LI_HC INT

SELECT @VER_SINTETICA = ISNULL(verificacion_sintetica,0), @LON_CLAVE = ISNULL(minimo_longitud,6), @HAB_HISTORIAL = ISNULL(habilitar_hitorial,0),
@LON_HISTORIAL = ISNULL(tamano_historial,0)
FROM seguridad.politica_clave where defecto = 1;


IF @VER_SINTETICA = 1 AND ( @LON_CLAVE > LEN (@AS_USU_CLAVE) )
BEGIN
	SET @AS_MSJ = 'La contrasena debe tener ' + CONVERT ( VARCHAR, @LON_CLAVE ) + ' caracteres'
	RETURN -1
END


IF @HAB_HISTORIAL = 1 
BEGIN
	SELECT @LI_HC = MAX (hist_clave.id_hist_clave) FROM seguridad.hist_clave
			WHERE hist_clave.id_usuario = @AS_USU_USUARIO

	SET @LI = 1
	WHILE ( @LI <= @LON_HISTORIAL )
	BEGIN
		IF ( SELECT pwdcompare ( @AS_USU_CLAVE, hist_clave.clave ) 
				FROM seguridad.hist_clave
				WHERE hist_clave.id_hist_clave = @LI_HC 
			) = 1
		BEGIN
			SET @AS_MSJ = 	'La clave ya fue utilizada, ingrese otra.';
			RETURN -1
		END
		SELECT @LI_HC = MAX (hist_clave.id_hist_clave) FROM seguridad.hist_clave
			WHERE hist_clave.id_usuario = @AS_USU_USUARIO
			AND @LI_HC > hist_clave.id_hist_clave
		SET @LI = @LI + 1
	
		
	END
END 
DECLARE @LI_RET  INT
IF @VER_SINTETICA = 1
BEGIN
	EXEC @LI_RET = seguridad.proc_validar_clave_fuerte 
		@AS_USU_CLAVE = @AS_USU_CLAVE,
		@AS_MSJ = @AS_MSJ OUTPUT
	IF	@LI_RET = -1
		RETURN -1
END		
UPDATE seguridad.usuario
SET 	 usuario.clave = convert(varbinary(256), pwdencrypt( @AS_USU_CLAVE )),
	 usuario.fecha_ultimo_cambio_pwd = @AD_FECHA,intento_fallido = 0,fecha_fallido = null,
	 usuario.cambiar_pwd_proximo_logon = 0,modifica_usuario = @AS_USUARIO, modifica_fecha = @AD_FECHA, 
	 modifica_equipo = @AS_EQUIPO
WHERE usuario.id_usuario = @AS_USU_USUARIO
AND usuario.eliminado = 0;

UPDATE seguridad.token
	SET eliminado = 1, modifica_usuario = @AS_USUARIO, modifica_fecha = @AD_FECHA, modifica_equipo = @AS_EQUIPO
WHERE dato = @AS_TOKEN;

IF @@ERROR <> 0
BEGIN
	SET @AS_MSJ = 'Usuario no esta Activo'
	RETURN -1
END
INSERT seguridad.hist_clave (hist_clave.id_usuario, hist_clave.clave, creacion_usuario, creacion_fecha, creacion_equipo, modifica_usuario, modifica_fecha, modifica_equipo )
VALUES ( @AS_USU_USUARIO, convert(varbinary(256), pwdencrypt( @AS_USU_CLAVE )), @AS_USUARIO, @AD_FECHA, @AS_EQUIPO, @AS_USUARIO, @AD_FECHA, @AS_EQUIPO )
IF @@ERROR <> 0
BEGIN
	SET @AS_MSJ = 'Usuario no esta Activo'
	RETURN -1
END
	
RETURN 1
