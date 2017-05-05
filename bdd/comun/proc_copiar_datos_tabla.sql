-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Andres Campoverde
-- Create date: 28-04-2017
-- Description:	Procedimiento para copiar los datos de una tabla y sus hijos
-- =============================================
CREATE PROCEDURE proc_copiar_datos_tabla 
	-- Add the parameters for the stored procedure here
	@AS_TABLA VARCHAR(50)=NULL, 
	@AS_ESQUEMA VARCHAR(50)=NULL,
	@AI_ID_ORIGINAL INT,
	@AS_USUARIO VARCHAR(15)=NULL,
	@AS_EQUIPO VARCHAR(50)=NULL,
	@LI_RET INT OUTPUT,
	@AI_ID_SOLICITUD INT OUTPUT,
	@AS_MSJ VARCHAR(100) OUTPUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	DECLARE @sentenciaSql VARCHAR(100)= ''
	DECLARE @LI_ID_NUEVO INT = 0
	DECLARE @AD_FECHA DATETIME = GETDATE()

	/*DROP TABLE dependencia_duplicar_temp;
	DROP TABLE hijos_duplicar_temp;*/

    -- Insert statements for procedure here
	SELECT @AS_MSJ= 'INSERT INTO '+@AS_ESQUEMA+'.'+@AS_TABLA+'('
	+COLUMN_NAME+')'
	+' SELECT '+COLUMN_NAME
	+' FROM '+@AS_ESQUEMA+'.'+@AS_TABLA+
	' WHERE id= '+@AI_ID_ORIGINAL+';'	
	FROM INFORMATION_SCHEMA.COLUMNS
	WHERE COLUMN_NAME NOT IN ('id')
	AND TABLE_NAME=@AS_TABLA
	AND TABLE_SCHEMA=@AS_ESQUEMA;

	EXEC (@sentenciaSql);

	/*SET IDENTITY_INSERT @AS_ESQUEMA+'.'+@AS_TABLA ON */
	
	DECLARE @dependencia_duplicar_temp TABLE(TABLE_SCHEMA VARCHAR(50), COLUMN_NAME VARCHAR(50), TABLE_NAME VARCHAR(50),INDICE INT)
	DECLARE @hijos_duplicar_temp TABLE(ID_PK INT,INDICE INT)
	DECLARE @Param INT = 1

	/*EXEC comun.proc_copiar_datos_tabla_inferior @AS_ESQUEMA @AS_TABLA @AI_ID_ORIGINAL @AS_USUARIO @AS_EQUIPO*/

END
GO
