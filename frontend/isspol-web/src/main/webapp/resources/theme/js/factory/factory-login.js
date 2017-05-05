/**
 * Created by andres.campoverde on 26/04/2017.
 */

angular.module('app').factory('login-factory',loginUsuario,['$http','$q',function ($http,$q) {

}]);

function loginUsuario() {

    var usuario=undefined;

    var usuarioInterfaz={

        setUsuario: function (usuarioLog) {
            usuario=usuarioLog;
        },

        getUsuario: function () {
            return usuario;
        }
    };
    return usuarioInterfaz;
};