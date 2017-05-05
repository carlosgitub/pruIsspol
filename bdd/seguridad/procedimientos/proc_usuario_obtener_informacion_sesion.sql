USE [siisspolweb]
GO
/****** Object:  StoredProcedure [seguridad].[proc_usuario_obtener_informacion_sesion]    Script Date: 04/05/2017 13:05:33 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER ON
GO
/*
FECHA		AUTOR				DESCRIPCION
==========	======				============================================================
2013-10-22	HRM					CREACION
2017-05-02	Andres Campoverde	Modificacion en campos tiene_vencimiento y fecha_vencimiento
2017-05-04	Andres Campoverde	Modificacion en la restriccion de consulta de grupo y nombre de grupo para seleccionar no eliminados
*/
ALTER PROCEDURE [seguridad].[proc_usuario_obtener_informacion_sesion]
@AS_USUARIO VARCHAR(15)
AS
DECLARE @LI_VER_TODAS_LAS_OFICINAS INT, 
		@LI_VER_SOLO_OFICINAS_DE_SUCURSAL  INT
EXEC @LI_VER_TODAS_LAS_OFICINAS = seguridad.proc_usuario_permiso_proceso @AS_USUARIO,'PA_TODASOFICINAS' 
EXEC @LI_VER_SOLO_OFICINAS_DE_SUCURSAL = seguridad.proc_usuario_permiso_proceso @AS_USUARIO, 'PA_SOLOFICINASSUCURSAL'
	SELECT	OFICINA			= usuario.id_oficina,
			NOMBRE_OFICINA	= oficina.nombre,
			SUCURSAL		= oficina.id_sucursal, 
			NOMBRE_SUCURSAL = sucursal.nombre,
			PROVINCIA		= oficina.id_provincia, 
			CODIGO_AREA		= oficina.tel_codigo_area,
			CODIGO_REGION	= oficina.tel_codigo_region,
			NOMBRE_EMPRESA	= empresa.nombre,
			DASHBOARD_INICIO = ( SELECT codigo from gerencial.dashboard WHERE id_dashboard = usuario.id_dashboard_inicio ),
			VER_TODAS_LAS_OFICINAS = @LI_VER_TODAS_LAS_OFICINAS ,
			VER_SOLO_OFICINAS_DE_SUCURSAL = @LI_VER_SOLO_OFICINAS_DE_SUCURSAL,
			MONEDA = ( SELECT moneda  
						FROM comun.moneda WHERE moneda_local = 1 ),
			GRUPO = ( SELECT TOP 1 grupo_usuario.id_grupo 
						FROM seguridad.grupo_usuario 
						WHERE grupo_usuario.id_usuario = usuario.id_usuario 
						AND grupo_usuario.estado = 1
						AND grupo_usuario.eliminado <> 1
						AND (	( grupo_usuario.tiene_vencimiento = 0 ) 
							OR	( grupo_usuario.tiene_vencimiento = 1 
									AND grupo_usuario.fecha_vencimiento >= comun.func_fecha_sistema() 
								)
							)							
						ORDER by grupo_usuario.id_grupo 
					),
			NOMBRE_GRUPO = ( SELECT TOP 1 grupo.nombre
						FROM seguridad.grupo_usuario
								JOIN seguridad.grupo ON grupo.id_grupo = grupo_usuario.id_grupo 
						WHERE grupo_usuario.id_usuario = usuario.id_usuario 
						AND grupo_usuario.estado = 1
						AND grupo_usuario.eliminado <> 1
						AND grupo.eliminado<>1
						AND (	( grupo_usuario.tiene_vencimiento = 0 ) 
							OR	( grupo_usuario.tiene_vencimiento = 1 
									AND grupo_usuario.fecha_vencimiento >= comun.func_fecha_sistema() 
								)
							)
						ORDER by grupo_usuario.id_grupo 
					)
	FROM seguridad.usuario
		JOIN seguridad.oficina ON usuario.id_oficina = oficina.id_oficina 
		JOIN seguridad.sucursal ON oficina.id_sucursal = sucursal.id_sucursal,
		comun.empresa
	WHERE usuario.id_usuario = @AS_USUARIO


