/* 
Nombre: proc_usuario_solicitud_cambio_clave
Descripción: Ingresar solicitud para cambio de Contrasena
	
************** Histórico **************
Fecha		 siglas/nombre		 Descripción
26/04/2017	 Carlos Calo		 Primera versión

*/

ALTER PROCEDURE [seguridad].[proc_usuario_solicitud_cambio_clave]
@AS_CORREO VARCHAR(100),
@AS_DATO VARCHAR(255),
@AS_CODIGO_TIPO_TOKEN VARCHAR(50),
@AS_CODIGO_PROCESO_NOTIFICACION VARCHAR(50),
@AS_USUARIO VARCHAR(20),
@AD_FECHA DATETIME,
@AS_EQUIPO VARCHAR(50),
@AS_MSJ VARCHAR(200) OUTPUT
AS

SET NOCOUNT ON;

DECLARE
@ID_TIPO_TOKEN INT,
@ID_PROCESO_NOTIFICACION INT,
@DT_CADUCIDAD_FECHA DATETIME,
@AI_USUARIO VARCHAR(20)

SET @DT_CADUCIDAD_FECHA = @AD_FECHA;

SELECT @ID_TIPO_TOKEN = id_tipo_token FROM seguridad.tipo_token WHERE codigo = @AS_CODIGO_TIPO_TOKEN;
SELECT @ID_PROCESO_NOTIFICACION = id_proceso_notificacion FROM comun.proceso_notificacion WHERE codigo = @AS_CODIGO_PROCESO_NOTIFICACION;
SELECT @DT_CADUCIDAD_FECHA = DATEADD(ss,tiempo_validez_token,@DT_CADUCIDAD_FECHA) FROM seguridad.politica_clave WHERE defecto = 1;
SELECT @AI_USUARIO = id_usuario FROM seguridad.usuario WHERE email = @AS_CORREO;


IF (@AI_USUARIO IS NULL OR @AI_USUARIO = '' )
BEGIN
	SET @AS_MSJ = 'El Usuario indicado no existe';
	RETURN -1;
END;

IF EXISTS (SELECT 1 FROM seguridad.token 
		WHERE id_tipo_token = @ID_TIPO_TOKEN AND eliminado = 0 AND id_usuario = @AI_USUARIO
		AND @AD_FECHA < caducidad_fecha )
BEGIN
	SET @AS_MSJ = 'Existe una solicitud de cambio activa';
	RETURN -1;
END;

IF(@AS_USUARIO IS NULL OR @AS_USUARIO = '')
	SET @AS_USUARIO = @AI_USUARIO;


INSERT INTO seguridad.token(eliminado, dato, id_usuario, id_tipo_token, caducidad_fecha, creacion_usuario, creacion_fecha, creacion_equipo, modifica_usuario, modifica_fecha, modifica_equipo )
VALUES (0, @AS_DATO, @AI_USUARIO, @ID_TIPO_TOKEN, @DT_CADUCIDAD_FECHA, @AS_USUARIO, @AD_FECHA, @AS_EQUIPO, @AS_USUARIO, @AD_FECHA, @AS_EQUIPO);

INSERT INTO comun.notificacion_correo(id_proceso_notificacion, id_usuario, notificado, creacion_usuario, creacion_fecha, creacion_equipo, modifica_usuario, modifica_fecha, modifica_equipo )
VALUES (@ID_PROCESO_NOTIFICACION, @AI_USUARIO, 0, @AS_USUARIO, @AD_FECHA, @AS_EQUIPO, @AS_USUARIO, @AD_FECHA, @AS_EQUIPO);


IF @@ERROR <> 0
    BEGIN
        SET @AS_MSJ = 'Error';
        RETURN -1;
    END;
RETURN 1;






