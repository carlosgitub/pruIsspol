USE [siisspolweb]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/*******************************************************************/
/*  Archivo:            proc_oficina_crud.sql					   */
/*  SP:                 proc_oficina_crud                          */
/*  Base de datos:      siisspolweb.seguridad                      */
/*  Producto:           Módulo Seguridades                         */
/*  Fecha de escritura: 26-04-2017                                 */
/*******************************************************************/
/*                        IMPORTANTE                               */
/*  Este programa es parte de los modulos propiedad del ISSPOL     */
/*  Su uso no autorizado queda expresamente prohibido asi como     */
/*  cualquier  alteración  o  agregado hecho por alguno de sus     */
/*  usuarios sin el debido consentimiento por escrito.             */
/*******************************************************************/
/*                          PROPOSITO                              */
/* Mantenimiento CRUD de coordinaciones del IISPOL				   */
/*******************************************************************/
/*                        MODIFICACIONES                           */
/*  FECHA             AUTOR            RAZON                       */
/*  26-04-2017    Javier Parada    Emisión inicial                 */
/*******************************************************************/

ALTER PROCEDURE [seguridad].[proc_oficina_crud]
@AS_OPERACION VARCHAR(1),
@AI_ID_OFICINA INT,
@AI_ID_SUCURSAL INT,
@AI_ID_TIPO_OFICINA INT,
@AS_NOMBRE VARCHAR(50),
@AS_CODIGO VARCHAR(50),
@AS_DIRECCION VARCHAR(50),
@AS_TELEFONO VARCHAR(20),
@AI_ID_PROVINCIA INT,
@AI_ID_CANTON INT,
@AI_HABILITADO INT,
@AI_ID_EMPRESA INT,
@AS_CODIGO_2 VARCHAR(20),/*INICIALES DE OFICIO*/
@AS_TEL_CODIGO_AREA VARCHAR(3),
@AS_TEL_CODIGO_REGION VARCHAR(3),
@AS_OTRO_TELEFONO VARCHAR(100),
@AF_LATITUD FLOAT,
@AF_LONGITUD FLOAT,
@AS_CREACION_USUARIO VARCHAR(20),
@AS_CREACION_EQUIPO VARCHAR(20),
@AS_MSJ varchar(100) OUTPUT

AS
BEGIN
	SET NOCOUNT ON;
	/*OPERACION CREACION NUEVO REGISTRO*/
	IF @AS_OPERACION = 'C' AND @AI_ID_OFICINA IS NULL/*C:CREATE; U:UPDATE; D:DELETE*/
	BEGIN
		IF EXISTS ( SELECT 1 FROM seguridad.oficina 
			WHERE oficina.nombre = @AS_NOMBRE )
		BEGIN
			SET @AS_MSJ = 'COORDINACION YA EXISTE'
			RETURN 1
		END

		BEGIN TRAN
		INSERT INTO seguridad.oficina
				(id_sucursal,
				id_tipo_oficina,
				nombre,
				codigo,
				direccion,
				telefono,
				id_provincia,
				id_canton,
				habilitado,
				id_empresa,
				codigo_2,
				tel_codigo_area,
				tel_codigo_region,
				otro_telefono,
				latitud,
				longitud,
				creacion_usuario,
				creacion_fecha,
				creacion_equipo,
				modifica_usuario,
				modifica_fecha,
				modifica_equipo)
		VALUES (@AI_ID_SUCURSAL,
				@AI_ID_TIPO_OFICINA,
				@AS_NOMBRE,
				@AS_CODIGO,
				@AS_DIRECCION,
				@AS_TELEFONO,
				@AI_ID_PROVINCIA,
				@AI_ID_CANTON,
				@AI_HABILITADO,
				@AI_ID_EMPRESA,
				@AS_CODIGO_2,
				@AS_TEL_CODIGO_AREA,
				@AS_TEL_CODIGO_REGION,
				@AS_OTRO_TELEFONO,
				@AF_LATITUD,
				@AF_LONGITUD,
				@AS_CREACION_USUARIO,
				GETDATE(),
				@AS_CREACION_EQUIPO,
				@AS_CREACION_USUARIO,
				GETDATE(),
				@AS_CREACION_EQUIPO);
				

		IF @@ERROR <> 0
		BEGIN
			RAISERROR('ERROR AL INSERTAR LA COORDINACION: NOMBRE %s', 16, -1, @AS_NOMBRE)	
			SET @AS_MSJ = 'ERROR AL INSERTAR LA COORDINACION';
			ROLLBACK TRAN
			RETURN 1;
		END;
		COMMIT TRAN
		SET @AS_MSJ = 'COORDINACION GUARDADA CORRECTAMENTE';
		RETURN 0;
	END /*FIN OPERACION CREACION*/
	
	/*OPERACION ACTUALIZACION*/
	IF @AS_OPERACION = 'U' AND @AI_ID_OFICINA IS NOT NULL
	BEGIN
		IF EXISTS ( SELECT 1 FROM seguridad.oficina 
			WHERE oficina.nombre = @AS_NOMBRE AND oficina.id_oficina <> @AI_ID_OFICINA)
		BEGIN
			SET @AS_MSJ = 'COORDINACION YA EXISTE!! VERIFIQUE EL NOMBRE'
			RETURN 1
		END

		BEGIN TRAN
		UPDATE seguridad.oficina
			SET id_sucursal = @AI_ID_SUCURSAL,
				id_tipo_oficina = @AI_ID_TIPO_OFICINA,
				nombre = @AS_NOMBRE,
				codigo = @AS_CODIGO,
				direccion = @AS_DIRECCION,
				telefono = @AS_TELEFONO,
				id_provincia = @AI_ID_PROVINCIA,
				id_canton = @AI_ID_CANTON,
				habilitado = @AI_HABILITADO,
				id_empresa = id_empresa,
				codigo_2 = @AS_CODIGO_2,
				tel_codigo_area = @AS_TEL_CODIGO_AREA,
				tel_codigo_region = @AS_TEL_CODIGO_REGION,
				otro_telefono = @AS_OTRO_TELEFONO,
				latitud = @AF_LONGITUD,
				longitud = @AF_LONGITUD,
				modifica_usuario = @AS_CREACION_USUARIO,
				modifica_fecha = GETDATE(),
				modifica_equipo = @AS_CREACION_EQUIPO
			WHERE id_oficina = @AI_ID_OFICINA

			IF @@ERROR <> 0
			BEGIN
				RAISERROR('ERROR AL ACTUALIZAR: ID_OFICINA %s - NOMBRE %s', 16, -1, @AI_ID_OFICINA, @AS_NOMBRE)	
				SET @AS_MSJ = 'ERROR AL ACTUALIZAR LA COORDINACION';
				ROLLBACK TRAN
				RETURN 1
			END
			COMMIT TRAN
			SET @AS_MSJ = 'COORDINACION ACTUALIZADA CORRECTAMENTE';
			RETURN 0
	END /*FIN OPERACION ACTUALIZACION*/
END