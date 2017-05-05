/**
 * Created by carlos.calo
 * @date 27/04/2017
 */
app.controller('UsuarioCambioClave', ['blockUI', 'servicio-usuario', 'general-message', 'ngNotify', '$scope', '$http', 'ngTableParams', '$location',
    function (blockUI, usuarioServicio, generalMessage, ngNotify, $scope, $http, ngTableParams, $location) {

        $scope.add = function(){
            $http.get($scope.url).then(function(response) {
                $scope.newMessage = response.data.queries.request.totalResults;
                $scope.messages.push($scope.newMessage);
            });
        };

        $scope.objUsuario = {};
        $scope.claveNueva = '';
        $scope.claveNuevaRepite = '';
        $scope.token = undefined;
        $scope.isCollapsed = true;
        $scope.prueba = '';

        $scope.cambiarClaveUsuario = function (objClave) {
            blockUI.start();
            usuarioServicio.procUsuarioCambiarClave($scope.objUsuario, objClave, $scope.token).then(function (data) {
                blockUI.stop();
                if (data.RETURN_VALUE == 1) {
                    $scope.isCollapsed = false;
                    $scope.claveNueva = '';
                    $scope.claveNuevaRepite = '';
                } else {
                    ngNotify.set(data.AS_MSJ, 'warm');
                }
            });
        };

        function verificarUsuarioToken() {
            $scope.token = getValueParameterUrl('token');
            blockUI.start();
            usuarioServicio.buscarTokenPorDato($scope.token).then(function (data) {
                blockUI.stop();
                if (data.exception == undefined || data.exception == null) {
                    $scope.container = true;
                    $scope.objUsuario = data.usuario;
                } else {
                    console.log(data.exception);
                    $scope.objUsuario = undefined;
                }
            });

        };

        function getValueParameterUrl(parameter) {
            var result = '', urlCorrect = [],
            tmp = [];
            urlCorrect = location.hash.split("?");
            if(urlCorrect.length > 1) {
                urlCorrect[1]
                    .split("&")
                    .forEach(function (item) {
                        tmp = item.split("=");
                        if (tmp[0] === parameter) {
                            result = decodeURIComponent(tmp[1])
                        }
                        ;
                    });
            }
            return result;
        };

            verificarUsuarioToken();
    }
]);