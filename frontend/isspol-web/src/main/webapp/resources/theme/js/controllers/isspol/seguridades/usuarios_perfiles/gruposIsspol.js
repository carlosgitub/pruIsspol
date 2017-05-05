/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/**
 * Created by esyacelga
 */

app.controller("GruposIsspol", ['blockUI', 'servicio-grupo', 'ngNotify', "$scope", 'ngTableParams', '$http', '$state',
    function (blockUI, servicioGrupo, ngNotify, $scope, ngTableParams, $http, $state) {

        controller = this;
        controller.lstGrp = [];

        $scope.user = {};
        $scope.authError = null;


        var callbackObtenerGrupos = function (data) {
            console.log(data);
        };


        controller.visualiazaGrupos = function (objeto) {
            controller.grupoObj = objeto;
        };

        controller.nuevoGrupo = function () {
            controller.objGrupo = {}
        };


        controller.editarGrupo = function (objGrupo, opcion, $index) {
            controller.lstGrp.splice($index, 1);
            controller.objGrupo = objGrupo;
            controller.habilitarCampos = opcion;
        };


        controller.eliminarGrupo = function (obj,$index) {

            blockUI.start();
            var responce = servicioGrupo.eliminarGrupo(obj);
            responce.then(function (data) {
                blockUI.stop();
                ngNotify.set('Exito registro eliminado correctamente', 'success');
                controller.lstGrp.splice($index, 1);
                controller.cancelar();
            }, function (error) {
                ngNotify.set('Hubo un error al guardad el registro', 'error');
            });
            //listarGrupos();
        };

        controller.cancelar = function () {
            controller.objGrupo = undefined;
            controller.grupoObj = undefined;
            listarGrupos();
        };

        controller.guardar = function (objGrupo) {

            var valida = document.formGrupo.reportValidity();
            if (valida) {
                var respuesta = validarRepetidos(objGrupo);
                if (respuesta == 1) {
                    ngNotify.set('Nombre repetido!!', 'error');
                } else {
                    blockUI.start();
                    var responce = servicioGrupo.insertarActualizarGrupo(objGrupo);
                    responce.then(function (data) {
                        if(data.exception == undefined || data.exception == null){
                            blockUI.stop();
                            ngNotify.set('El registro se guardo correctamente', 'success');
                            controller.cancelar();

                        }else{
                            blockUI.stop();
                            console.log(data.exception);
                            ngNotify.set('Hubo un error al guardar el registro', 'error');
                        }

                    }, function (error) {
                        blockUI.stop();
                        ngNotify.set('Hubo un error al guardar el registro', 'error');
                    });


                   /* blockUI.start();
                    var responce = servicioGrupo.insertarActualizarGrupo(objGrupo);
                    responce.then(function (data) {
                        blockUI.stop();
                        ngNotify.set('El registro se guardo correctamente', 'success');
                        controller.cancelar();

                    }, function (error) {
                        ngNotify.set('Hubo un error al guardad el registro', 'error');
                    });*/
                }
            }


        };

        function listarGrupos() {
            blockUI.start();
            var responce = servicioGrupo.listarGrupos();
            responce.then(function (data) {
                controller.lstGrp = data;
                blockUI.stop();
            }, function (error) {
                ngNotify.set('Hubo un error al listar los roles', 'error');
            });

        }


        function iniciarFormulario() {
            controller.objGrupo = undefined;
        };

        function validarRepetidos(obj) {
            var respuesta = 0;
            for (var i = 0; i < controller.lstGrp.length; i++) {
                if (obj.nombre == controller.lstGrp[i].nombre) {
                    return 1;
                }
            }
        }

        iniciarFormulario();
        listarGrupos();

    }]);
