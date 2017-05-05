'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state','servicio-usuario','ngNotify', 'servicio-login',
    function($scope, $http, $state,servicioUsuario,ngNotify,servicioLogin) {
        $scope.authError = null;
        $scope.usuarioExiste=false;

        $scope.envioUsuarioLogin=function (usuarioNombre) {
            verificarNombreUsuario();

        };

        function verificarNombreUsuario() {
            var response=servicioUsuario.verificarNombreUsuario($scope.usuarioNombre);
            response.then(function (data) {
                $scope.usuarioExiste=data;
                if($scope.usuarioExiste){
                    servicioLogin.setUsuario($scope.usuarioNombre);
                    $state.go('access.signinClave');
                }else{
                    ngNotify.set('El usuario no existe', {type: 'error', sticky: true});
                }
                console.log(data);
            },function (error) {
                console.log(error);
            });
        };
    }])
;