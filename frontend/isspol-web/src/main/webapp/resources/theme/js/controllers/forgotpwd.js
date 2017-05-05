/**
 * Created by carlos.calo
 * @date 27/04/2017
 */
app.controller('UsuarioOlvidoClave', ['blockUI', 'servicio-usuario', 'general-message', 'ngNotify', "$scope", 'ngTableParams',
    function (blockUI, usuarioServicio, generalMessage, ngNotify, $scope, ngTableParams) {

        $scope.correo = undefined;
        $scope.isCollapsed = true;

        $scope.solicitudCambioClaveUsuario = function (objCorreo) {
            $scope.usuario = {
                email : objCorreo
            }
            blockUI.start();
            usuarioServicio.procUsuarioSolicitudCambioClave($scope.usuario).then(function (data) {
                console.log(data);
                blockUI.stop();
                if (data.RETURN_VALUE == 1) {
                    $scope.correo = undefined;
                    $scope.isCollapsed = false;
                    ngNotify.set(generalMessage.SEGENEROCORREO, 'success');
                } else {
                    ngNotify.set(data.AS_MSJ, 'warm');
                }
            });
        };

        function verificarUsuarioSesion() {
            $scope.correo = undefined;
        };

        verificarUsuarioSesion();
    }
])
;