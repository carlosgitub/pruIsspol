/**
 * @ngdoc service
 * @name app.catalogService
 * @description
 * # Servicio de persistencia con la entidad Estacion
 * Service in the angularSeedApp.
 */

/**
 * Created by mavelin.ati on 24/03/2017.
 */

app.service('servicio-estacion', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    this.insertarActualizarEstacion= function (estacion) {
        var deferred = $q.defer();
        var response = $http.post('insertarActualizarEstacion_json.json', estacion);

        response.success(function (data, status, headers, config) {
            deferred.resolve(data);
        });
        response.error(function (data, status, headers, config) {
            deferred.reject(data);
        });
        return deferred.promise;
    };

    this.eliminarEstacion= function (estacion) {
        var deferred = $q.defer();
        var response = $http.post('eliminarEstacion_json.json', estacion);

        response.success(function (data, status, headers, config) {
            deferred.resolve(data);
        });
        response.error(function (data, status, headers, config) {
            deferred.reject(data);
        });
        return deferred.promise;
    };

    this.listarTodosEstacion = function () {
        var deferred = $q.defer();
        try {
            Estacion.listarTodosEstacion(function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };
}
]);