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

app.service('servicio-login', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    var usuario=undefined;

        this.setUsuario= function (usuarioLog) {
            usuario=usuarioLog;
        }

        this.getUsuario= function () {
            return usuario;
        }
}
]);