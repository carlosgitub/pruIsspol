/**
 * Created by andres.campoverde on 03/05/2017.
 */
app.service('servicio-oficina', ['$q', '$http', function ($q, $http) {
    this.buscarOficinaPorId = function (idOficina) {
        var deferred = $q.defer();
        try {
            Oficina.buscarOficinaPorId(idOficina, function (data) {
                deferred.resolve(data)
            });
        } catch (error) {
            deferred.reject(error);
        }
        return deferred.promise;
    };
}]);