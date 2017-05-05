/**
 * Created by Javier on 03/05/2017.
 */

/**
 * @ngdoc service
 * @name app.catalogService
 * @description
 * # Servicio de persistencia con las entidades Comunes
 * Service in the angularSeedApp.
 */


app.service('servicio-comun', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    this.listarProvincias = function () {
        var deferred = $q.defer();
        try {
            Comun.listarProvincias(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

    this.listarCantonesPorProvincia = function (objProvincia) {
        var deferred = $q.defer();
        try {
            Comun.listarCantonesPorProvincia(objProvincia, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

    this.listarEstados = function () {
        var deferred = $q.defer();
        try {
            Comun.listarEstados(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };


}]);
