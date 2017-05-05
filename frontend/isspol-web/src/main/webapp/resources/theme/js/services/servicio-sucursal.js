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


app.service('servicio-sucursal', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    this.insertarSucursal = function (sucursal) {
        var deferred = $q.defer();
        try {
            Sucursal.insertarSucursal(sucursal, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        ;
        return deferred.promise;
    };

    this.listarSucursal = function () {
        var deferred = $q.defer();
        try {
            Sucursal.listarSucursales(function (data) {//el mismo como le nombre del dwr
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        ;
        return deferred.promise;
    };

    this.listarSucursalPaginado = function (filtros) {
        var deferred = $q.defer();
        try {
            Sucursal.listarSucursalPaginado(filtros, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        ;
        return deferred.promise;
    };


    this.eliminarSucursal = function (sucursal) {
        var deferred = $q.defer();
        try {
            Sucursal.eliminarSucursal(sucursal, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        ;
        return deferred.promise;
    };

    this.listarOficinasPaginado = function (filtros) {
        var deferred = $q.defer();
        try {
            Sucursal.listarOficinaPaginado(filtros, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        ;
        return deferred.promise;

    };

    this.listarTipoOficinas = function () {
        var deferred = $q.defer();
        try {
            Sucursal.listarTipoOficinas(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        ;
        return deferred.promise;

    };

    this.buscarSucursalPorId= function (idSucursal) {
        var deferred = $q.defer();
        try {
            Sucursal.buscarSucursalPorId(idSucursal,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

    this.insertarActualizarOficina = function (oficina) {
        var deferred = $q.defer();
        try {
            Sucursal.insertarActualizarOficina(oficina, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };


}]);
