USE [siisspolweb]
GO
/****** Object:  UserDefinedFunction [comun].[func_fecha_sistema]    Script Date: 20/04/2017 11:25:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER OFF
GO
ALTER   FUNCTION [comun].[func_fecha_sistema]()
RETURNS DATETIME
AS
BEGIN
	DECLARE @LDT_FECHA DATETIME
	/*cambiado el llamado de func_fecha_sistema a func_parametro_dt*/
	SET @LDT_FECHA = comun.func_parametro_dt('FECHASIS')
	
	RETURN (@LDT_FECHA )
	END