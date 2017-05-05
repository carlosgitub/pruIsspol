'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormClaveController', ['$scope', '$http', '$state','servicio-usuario','ngNotify', 'servicio-login', 'servicio-seleccion',
    function($scope, $http, $state,servicioUsuario,ngNotify,serviceLogin,serviceSeleccion) {
        $scope.authError = null;
        $scope.datosBiometricos;

        $scope.login=function () {
            $scope.datosInicioSesion=serviceSeleccion.getDatosSesion();
            obtenerDatosBiometricos();
            serviceSeleccion.setDatosSesion($scope.datosInicioSesion);
                $state.go('app.dashboard-v2');
        };

        function obtenerDatosBiometricos() {
            $scope.datosBiometricos={};
            $scope.datosInicioSesion.datosBiometricos=$scope.datosBiometricos;
        }
    }])
;