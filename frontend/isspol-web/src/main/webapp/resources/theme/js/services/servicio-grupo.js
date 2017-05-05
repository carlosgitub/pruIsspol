/**
 * @ngdoc service
 * @name app.catalogService
 * @description
 * # Servicio de persistencia con la entidad Usuario
 * Service in the angularSeedApp.
 */

/**
 * Created by Edison Aulestia on 18/04/2017.
 */


app.service('servicio-grupo', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    this.insertarActualizarGrupo= function (grupo) {
        var deferred = $q.defer();
        try {
            Grupo.insertarActualizarGrupo(grupo,function (data) {//el mismo como le nombre del dwr.
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };




    this.eliminarGrupo= function (grupo) {
        var deferred = $q.defer();
        try {
            Grupo.eliminarGrupo(grupo,function (data) {//el mismo como le nombre del dwr.
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

    this.listarGrupos= function () {
        var deferred = $q.defer();
        try {
            Grupo.listarGrupos(function (data) {//el mismo como le nombre del dwr.
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        };
        return deferred.promise;
    };

    this.buscarGrupoPorId= function (grupo) {
        var deferred = $q.defer();
        try {
            Grupo.buscarGrupoPorId(grupo,function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };
}]);
