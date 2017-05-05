USE [siisspolweb]
GO
/****** Object:  StoredProcedure [auditoria].[proc_log]    Script Date: 24/04/2017 17:43:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER OFF
GO
ALTER PROCEDURE [auditoria].[proc_log] 
@AS_DESCRIPCION VARCHAR(255),
@AS_REFERENCIA VARCHAR(50) = NULL,
@AS_TIPO VARCHAR(3) = NULL,
@AS_USUARIO VARCHAR(15) = NULL, 
@AS_MAQUINA VARCHAR(50) = NULL, 
@AS_APLICACION VARCHAR(35) = NULL 
AS
BEGIN TRAN LOG1
DECLARE @LS_STR1 VARCHAR(50)
SET @LS_STR1 = host_name() 
IF @AS_USUARIO IS NULL OR @AS_USUARIO = ''
	SET @AS_USUARIO = auditoria.func_usuario( @LS_STR1 )
IF @AS_MAQUINA IS NULL OR @AS_MAQUINA = ''
	SET @AS_MAQUINA  = auditoria.func_maquina( @LS_STR1 )
IF @AS_APLICACION IS NULL OR @AS_APLICACION = ''
	SET @AS_APLICACION  = SUBSTRING(APP_NAME(),1,35) 
IF EXISTS ( SELECT * FROM auditoria.tipo_log
		WHERE tipo_log.id_tipo_log = @AS_TIPO ) OR @AS_TIPO IS NULL
INSERT INTO auditoria.log (
	log.fecha,  
	log.usuario,  
	log.maquina,  
	log.id_tipo_log,  
	log.referencia,  
	log.descripcion,  
	log.appl,
	log.creacion_usuario,
	log.creacion_fecha,
	log.creacion_equipo,
	log.modifica_usuario,
	log.modifica_fecha,
	log.modifica_equipo )
VALUES (
	GETDATE(), 
	@AS_USUARIO, 
	@AS_MAQUINA, 
	@AS_TIPO, 
	@AS_REFERENCIA, 
	@AS_DESCRIPCION, 
	@AS_APLICACION,
	@AS_USUARIO,
	GETDATE(),
	@AS_MAQUINA,
	@AS_USUARIO,
	GETDATE(),
	@AS_MAQUINA
)
COMMIT TRAN LOG1;
