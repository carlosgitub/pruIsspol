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
CREATE PROCEDURE proc_copiar_datos_tabla_inferior 
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

	DECLARE @sentenciaSql VARCHAR(100) = ''
	DECLARE @tabla_ VARCHAR(20) = ''
	DECLARE @esquema_ VARCHAR(20) = ''
	DECLARE @id_relacion_ VARCHAR(20) = ''

	DECLARE @indice_ VARCHAR(20) = ''
	SET @indice_ = @AS_ESQUEMA+@AS_TABLA+'id'+@AI_ID_ORIGINAL
	
	DECLARE @indice_inferior_ VARCHAR(20) = ''
	DECLARE @id_temporal INT = 0
	DECLARE @id_temporal_padre INT =0
	DECLARE @tabla_relacionada VARCHAR(20) = ''
	DECLARE @id_existente INT
	/*DECLARE @tabla TABLE*/

    -- Insert statements for procedure here

	SELECT 
		@tabla_relacionada = tr.name
	FROM 
		sys.foreign_keys fk
	INNER JOIN 
		sys.tables tp ON fk.parent_object_id = tp.object_id
	INNER JOIN 
		sys.tables tr ON fk.referenced_object_id = tr.object_id
	INNER JOIN 
		sys.foreign_key_columns fkc ON fkc.constraint_object_id = fk.object_id
	INNER JOIN 
		sys.columns cp ON fkc.parent_column_id = cp.column_id AND fkc.parent_object_id = cp.object_id
	INNER JOIN 
		sys.columns cr ON fkc.referenced_column_id = cr.column_id AND fkc.referenced_object_id = cr.object_id
	WHERE tp.name=@AS_TABLA
	ORDER BY
		tp.name, cp.column_id

	IF (@tabla_relacionada IS NULL)
	BEGIN
		SET @LI_RET = 1
		RETURN 1
	END 

	/*IF EXISTS(SELECT 1 
				FROM #dependencia_duplicar_temp
				WHERE @INDICE=@indice_)
	BEGIN
		SET @LI_RET =1
		RETURN 1
	END

	SET @sentenciaSql = 'insert into dependencia_duplicar_temp  
	SELECT tc.table_schema, tc.table_name, kcu.column_name,'''+@indice_+'''
	FROM information_schema.table_constraints tc 
	JOIN information_schema.key_column_usage kcu ON tc.constraint_name = kcu.constraint_name 
	JOIN information_schema.constraint_column_usage ccu ON ccu.constraint_name = tc.constraint_name 
	WHERE constraint_type = ''FOREIGN KEY''
	AND ccu.table_name= '''+@AS_TABLA+''' and ccu.table_schema = '''+@AS_ESQUEMA+''' and tc.table_name not like ''%_h''
	AND tc.table_name in ('+@tabla_relacionada+')
	AND tc.table_name not in (''bloque'',''unidad'')	'

	EXEC(@sentenciaSql)

	FOR @tabla IN
	SELECT * FROM #dependencia_duplicar_temp
	WHERE */

END
GO
