/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/**
 * Created by mavelin.ati
 */

app.controller("EstacionIsspol", ['blockUI', 'servicio-estacion', 'ngNotify', "$scope", 'ngTableParams', '$http', '$state',
    function (blockUI, servicioEstacion, ngNotify, $scope, ngTableParams, $http, $state) {

        controller = this;
        controller.lstEstacion = [];

        $scope.user = {};
        $scope.authError = null;

        var callbackObtenerEstacion = function (data) {
            console.log(data);
        };

        controller.nuevoEstacion = function () {
            controller.objEstacion = {}
        };

        controller.editarEstacion = function (objEstacion, opcion, $index) {
            controller.lstEstacion.splice($index, 1);
            controller.objEstacion = objEstacion;
            controller.habilitarCampos = opcion;
        };

        controller.verEstacion = function (objeto) {
            controller.estacionObj = objeto;
        };

        controller.eliminarEstacion = function (obj,$index) {
            blockUI.start();
            var responce = servicioEstacion.eliminarEstacion(obj);
            responce.then(function (data) {
                blockUI.stop();
                ngNotify.set('Registro eliminado correctamente', 'success');
                controller.lstEstacion.splice($index, 1);
                listarTodosEstacion();
                controller.cancelar();
            }, function (error) {
                ngNotify.set('Error al guardar el registro', 'error');
            });
        };

        controller.cancelar = function () {
            controller.objEstacion = undefined;
            controller.estacionObj = undefined;
            listarTodosEstacion();
        };

        controller.guardar = function (objEstacion) {
            var valida = document.formEstacion.reportValidity();
            if (valida) {
                var respuesta = validarRepetidos(objEstacion);
                if (respuesta == 1) {
                    ngNotify.set('Ingrese Hostname diferente', 'error');
                } else {
                    blockUI.start();
                    var responce = servicioEstacion.insertarActualizarEstacion(objEstacion);
                    responce.then(function (data) {
                        if(data.exception == undefined || data.exception == null){
                            blockUI.stop();
                            ngNotify.set('El registro se guardo correctamente', 'success');
                            listarTodosEstacion();
                            controller.cancelar();
                        }else{
                            blockUI.stop();
                            console.log(data.exception);
                            ngNotify.set('Error al guardar el registro', 'error');
                        }
                    }, function (error) {
                        blockUI.stop();
                        ngNotify.set('Error al guardar el registro', 'error');
                    });
                }
            }
        };

        function listarTodosEstacion() {
            blockUI.start();
            var responce = servicioEstacion.listarTodosEstacion();
            responce.then(function (data) {
                controller.lstEstacion = data;
                blockUI.stop();
            }, function (error) {
                ngNotify.set('Error listar las Estaciones', 'error');
            });
        }

        function iniciarFormulario() {
            controller.objEstacion = undefined;
        };

        function validarRepetidos(obj) {
            var respuesta = 0;
            for (var i = 0; i < controller.lstEstacion.length; i++) {
                if (obj.hostname == controller.lstEstacion[i].hostname) {
                    return 1;
                }
            }
        }

        iniciarFormulario();
        listarTodosEstacion();

}]);
