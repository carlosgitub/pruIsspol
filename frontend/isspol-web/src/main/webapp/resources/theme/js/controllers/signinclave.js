'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormClaveController', ['$scope', '$http', '$state','servicio-usuario','ngNotify', 'servicio-login', 'blockUI','servicio-seleccion',
    function($scope, $http, $state,servicioUsuario,ngNotify,serviceLogin,blockUI,servicioSeleccion) {
        $scope.user={};
        $scope.authError = null;
        $scope.ingresadoUsuario={id:2};
        $scope.numeroIntentos=0;
        $scope.codigoBiometrico=0;
        $scope.esLoginCorrecto;
        $scope.mensajeError;
        $scope.debeCambiarClave=false;
        $scope.contadorIntentos=0;
        $scope.fechaSistema;
        $scope.usuarioSesion = {
            OFICINA: 0,
            NOMBRE_OFICINA:'',
            SUCURSAL:0,
            NOMBRE_SUCURSAL:'',
            PROVINCIA:'',
            CODIGO_AREA:'',
            CODIGO_REGION:'',
            NOMBRE_EMPRESA:'',
            DASHBOARD_INICIO:'',
            VER_TODAS_LAS_OFICINAS:0,
            VER_SOLO_OFICINAS_DE_SUCURSAL:0,
            MONEDA: null,
            GRUPO: 0,
            NOMBRE_GRUPO: ''
        };

        $scope.obtenerNombreUsuario=function () {
            $scope.user.nombre=serviceLogin.getUsuario();
            validarClaveUsuario();
        };

        /**
         * Metodos para iniciar login
         */
        function logAuditoria() {
            var response=servicioUsuario.logAuditoria($scope.mensajeError,"Login","ini",$scope.user.nombre);
            response.then(function (data) {
                console.log(data);
            },function (error) {
                console.log(error);
            });
        }

        function obtenerFecha() {
            var responce= servicioUsuario.obtenerFecha();
            responce.then(function (data) {
                $scope.fechaSistema=data.FECHA;
                blockUI.stop();
                console.log(data);
            }, function (error) {
                console.log(error);
            });
        };

        function obtenerListaFavoritos() {
            var response=servicioUsuario.obtenerListaFavoritos($scope.user.nombre);
            response.then(function (data) {
                $scope.usuarioSesion.listaFavoritos=data;
                obtenerCarpetaOpcionPorGrupo();
                console.log(data);
            },function (error) {
                console.log(error);
            });
        };

        function validarClaveUsuario() {
            var response=servicioUsuario.validarClaveUsuario($scope.user.nombre,$scope.user.clave);
            blockUI.start();
            response.then(function (data) {
                if(data.RETURN_VALUE==-1){
                    $scope.esLoginCorrecto=false;
                    $scope.mensajeError=data.AS_MSJ;
                }else if(data.RETURN_VALUE==1){
                    $scope.esLoginCorrecto=true;
                    if(data.AB_REQ_CAMBIO_PWD==1){
                        $scope.mensajeError='Debe cambiar su clave en el pr\u00f3ximo login';
                        $scope.debeCambiarClave=true;
                    }
                }

                if($scope.esLoginCorrecto==true){
                    if($scope.debeCambiarClave==true){
                        ngNotify.set($scope.mensajeError, {type: 'warn', sticky: true});
                    }
                    $scope.mensajeError='Ingreso exitoso de login';
                    logAuditoria();
                    obtenerInformacionSesion();
                    // blockUI.stop();
                    $state.go('access.signinBiometrico');
                }else if($scope.esLoginCorrecto==false){
                    blockUI.stop();
                    $state.go('access.signin');
                    $scope.mensajeError='Error en el ingreso: '+$scope.mensajeError;
                    logAuditoria();
                    $scope.contadorIntentos=$scope.contadorIntentos+1;
                    ngNotify.set($scope.mensajeError, {type: 'error', sticky: true});
                }
            },function (error) {
                console.log(error);
            });
        };

        function obtenerInformacionSesion() {
            var response=servicioUsuario.obtenerInformacionSesion($scope.user.nombre);
            response.then(function (data) {
                $scope.usuarioSesion=data;
                obtenerOficinaNombreOficina();
                console.log(data);
            },function (error) {
                console.log(error);
            });
        };

        function obtenerCarpetaOpcionPorGrupo() {
            var response=servicioUsuario.obtenerCarpetaOpcionPorGrupo($scope.usuarioSesion[0].GRUPO,$scope.user.nombre);
            response.then(function (data) {
                $scope.usuarioSesion.opcionCarpeta=data;
                obtenerOpcionUsoFrecuentes();
                console.log(data);
            },function (error) {
                console.log(error);
            });
        };

        function obtenerOpcionUsoFrecuentes() {
            var response=servicioUsuario.obtenerOpcionUsoFrecuentes($scope.user.nombre);
            response.then(function (data) {
                $scope.usuarioSesion.opcionesUsoFrecuente=data;
                $scope.usuarioSesion.idUsuario=$scope.user.nombre;
                servicioSeleccion.setDatosSesion($scope.usuarioSesion);
                obtenerFecha();
                console.log(data);
            },function (error) {
                console.log(error);
            });
        };

        function obtenerOficinaNombreOficina() {
            var response=servicioUsuario.obtenerOficinaNombreOficina($scope.usuarioSesion[0].OFICINA);
            response.then(function (data) {
                $scope.usuarioSesion.nombreOficina=data;
                obtenerSucursalOficina();
                console.log(data);
            },function (error) {
                console.log(error);
            });
        };

        function obtenerSucursalOficina() {
            var response=servicioUsuario.obtenerSucursalOficina($scope.usuarioSesion[0].OFICINA);
            response.then(function (data) {
                $scope.usuarioSesion.sucursalOficina=data;
                obtenerListaFavoritos();
                console.log(data);
            },function (error) {
                console.log(error);
            });
        };

    }])
;