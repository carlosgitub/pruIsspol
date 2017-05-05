USE [siisspolweb]
GO
/****** Object:  StoredProcedure [seguridad].[proc_usuario_verificar_bloqueo]    Script Date: 27/04/2017 17:10:09 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [seguridad].[proc_usuario_verificar_bloqueo]
@AB_MANUAL BIT,
@AI_USUARIO VARCHAR(20),
@AS_USUARIO VARCHAR(20),
@AD_FECHA DATETIME,
@AS_EQUIPO VARCHAR(20),
@AS_MSJ varchar(100) OUTPUT
AS
DECLARE @TIEMPO_BLOQUEO INT, @FECHA_BLOQUEO DATETIME;

IF (@AB_MANUAL = 1)
BEGIN
	UPDATE seguridad.usuario
			SET usuario.intento_fallido = 0,bloqueada = 0, modifica_usuario = @AS_USUARIO, modifica_fecha = @AD_FECHA, modifica_equipo = @AS_EQUIPO
			WHERE usuario.id_usuario = @AI_USUARIO
			AND usuario.id_estado_usuario = 1;
	RETURN 1;			
END

SELECT @TIEMPO_BLOQUEO = ISNULL(tiempo_bloqueo, 0)
	FROM seguridad.politica_clave WHERE defecto = 1 ;
SELECT @FECHA_BLOQUEO = fecha_fallido FROM seguridad.usuario WHERE id_usuario = @AI_USUARIO;

IF (@AD_FECHA > DATEADD ( ss, @TIEMPO_BLOQUEO, @FECHA_BLOQUEO))
BEGIN
	UPDATE seguridad.usuario
			SET usuario.intento_fallido = 0,bloqueada = 0, modifica_usuario = @AS_USUARIO, modifica_fecha = @AD_FECHA, modifica_equipo = @AS_EQUIPO
			WHERE usuario.id_usuario = @AI_USUARIO
			AND usuario.id_estado_usuario = 1;
	RETURN 1;			
END
	
RETURN 1

