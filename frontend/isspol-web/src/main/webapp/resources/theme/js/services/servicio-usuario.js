/**
 * @ngdoc service
 * @name app.catalogService
 * @description
 * # Servicio de persistencia con la entidad Usuario
 * Service in the angularSeedApp.
 */

/**
 * Created by santiago.yacelga on 31/03/2017.
 */


app.service('servicio-usuario', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    this.listaUsuario = function () {
        var deferred = $q.defer();
        try {
            Usuario.listaUsuario(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listaEstadoUsuario = function () {
        var deferred = $q.defer();
        try {
            Usuario.listaEstadoUsuario(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listaHorario = function () {
        var deferred = $q.defer();
        try {
            Usuario.listaHorario(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };


    this.listaOficina = function () {
        var deferred = $q.defer();
        try {
            Usuario.listaOficina(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listaEstructura = function () {
        var deferred = $q.defer();
        try {
            Usuario.listaEstructura(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };


    this.actualizarUsuario = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.actualizarUsuario(usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.actualizarUsuarioSP = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.actualizarUsuarioSP(usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.insertarUsuario = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.insertarUsuario(usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.procUsuarioSolicitudCambioClave = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.procUsuarioSolicitudCambioClave(usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.buscarTokenPorDato = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.buscarTokenPorDato(usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.procUsuarioCambiarClave = function (usuario, clave, token) {
        var deferred = $q.defer();
        try {
            Usuario.procUsuarioCambiarClave(usuario, clave, token, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.procUsuarioVerificarBloqueo = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.procUsuarioVerificarBloqueo(usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.validarFormularioInsertarUsuario = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.validarFormularioInsertarUsuario(usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    /**
     * Metodos Andres Campoverde
     * @returns {Promise}
     */
    this.obtenerFecha = function () {
        var deferred = $q.defer();
        try {
            Usuario.obtenerFecha(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.validarClaveUsuario = function (nombre,clave) {
        var deferred = $q.defer();
        try {
            Usuario.validarClaveUsuario(nombre,clave,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.obtenerInformacionSesion = function (nombre) {
        var deferred = $q.defer();
        try {
            Usuario.obtenerInformacionSesion(nombre,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.logAuditoria = function (descripcion,referencia, tipo, usuario) {
        var deferred = $q.defer();
        try {
            Usuario.logAuditoria(descripcion,referencia, tipo, usuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.obtenerListaFavoritos = function (usuario) {
        var deferred = $q.defer();
        try {
            Usuario.obtenerListaFavoritos(usuario,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.obtenerOficinaNombreOficina = function (oficina) {
        var deferred = $q.defer();
        try {
            Usuario.obtenerOficinaNombreOficina(oficina,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.obtenerSucursalOficina = function (oficina) {
        var deferred = $q.defer();
        var temp= ""+oficina;
        try {
            Usuario.obtenerSucursalOficina(temp,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.obtenerCarpetaOpcionPorGrupo = function (grupo,nombre) {
        var deferred = $q.defer();
        try {
            Usuario.obtenerCarpetaOpcionPorGrupo(grupo,nombre,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.obtenerOpcionUsoFrecuentes = function (nombre) {
        var deferred = $q.defer();
        try {
            Usuario.obtenerOpcionUsoFrecuentes(nombre,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.verificarNombreUsuario = function (nombre) {
        var deferred = $q.defer();
        try {
            Usuario.verificarNombreUsuario(nombre,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listarUsuarioOficinaPorIdUsuario = function (nombre) {
        var deferred = $q.defer();
        try {
            UsuarioOficina.listarUsuarioOficinaPorIdUsuario(nombre,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    // INICIA METODOS Mavelin Ati
    //-----------------------------------------------------------------------------------------------------
    /**
     * Metodos EstacionUsuario
     */

    this.insertarActualizarEstacionUsuario = function (estacionUsuario) {
        var usuario= {
            idUsuario: estacionUsuario.usuario.idUsuario
        };
        estacionUsuario.usuario= usuario;

        var deferred = $q.defer();
        var response = $http.post('insertarActualizarEstacionUsuario_json.json', estacionUsuario);

        response.success(function (data, status, headers, config) {
            deferred.resolve(data);
        });
        response.error(function (data, status, headers, config) {
            deferred.reject(data);
        });
        return deferred.promise;
    };

    this.eliminarEstacionUsuario = function (estacionUsuario) {
        var usuario= {
            idUsuario: estacionUsuario.usuario.idUsuario
        };
        estacionUsuario.usuario= usuario;

        var deferred = $q.defer();
        var response = $http.post('eliminarEstacionUsuario_json.json', estacionUsuario);

        response.success(function (data, status, headers, config) {
            deferred.resolve(data);
        });
        response.error(function (data, status, headers, config) {
            deferred.reject(data);
        });
        return deferred.promise;
    };

    this.listarTodosEstacionUsuario = function () {
        var deferred = $q.defer();
        try {
            Usuario.listarTodosEstacionUsuario(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listarEstacionUsuarioPorUsuario = function (idUsuario) {
        var deferred = $q.defer();
        try {
            Usuario.listarEstacionUsuarioPorUsuario(idUsuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listarEstacionUsuarioNoEliminadoPorUsuario = function (filtros) {
        var deferred = $q.defer();
        try {
            Usuario.listarEstacionUsuarioNoEliminadoPorUsuario(filtros ,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

    /**
     * Metodos GrupoUsuario
     */

    this.insertarActualizarGrupoUsuario = function (grupoUsuario) {
        var usuario= {
            idUsuario: grupoUsuario.usuario.idUsuario
        };
        grupoUsuario.usuario= usuario;

        var deferred = $q.defer();
        var response = $http.post('insertarActualizarGrupoUsuario_json.json', grupoUsuario);

        response.success(function (data, status, headers, config) {
            deferred.resolve(data);
        });
        response.error(function (data, status, headers, config) {
            deferred.reject(data);
        });
        return deferred.promise;
    };

    this.eliminarGrupoUsuario = function (grupoUsuario) {
        var usuario= {
            idUsuario: grupoUsuario.usuario.idUsuario
        };
        grupoUsuario.usuario= usuario;

        var deferred = $q.defer();
        var response = $http.post('eliminarGrupoUsuario_json.json', grupoUsuario);

        response.success(function (data, status, headers, config) {
            deferred.resolve(data);
        });
        response.error(function (data, status, headers, config) {
            deferred.reject(data);
        });
        return deferred.promise;
    };

    this.listarTodosGrupoUsuario = function () {
        var deferred = $q.defer();
        try {
            Usuario.listarTodosGrupoUsuario(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listarGrupoUsuarioPorUsuario = function (idUsuario) {
        var deferred = $q.defer();
        try {
            Usuario.listarGrupoUsuarioPorUsuario(idUsuario, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };

    this.listarGrupoUsuarioNoEliminadoPorUsuario = function (filtros) {
        var deferred = $q.defer();
        try {
            Usuario.listarGrupoUsuarioNoEliminadoPorUsuario(filtros ,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

    //FIN METODOS Mavelin Ati
    //-----------------------------------------------------------------------------------------------
}
]);