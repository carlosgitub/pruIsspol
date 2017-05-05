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

app.controller("SucursalesIsspol", ['ngTableParams', 'general-message', 'blockUI', 'servicio-sucursal', 'ngNotify', "$scope", 'ngTableParams', '$http', '$state',
    function (ngTableParams, generalMessage, blockUI, servicioSucursal, ngNotify, $scope, ngTableParams, $http, $state) {

        controller = this;
        controller.lstSuc = [];

        $scope.user = {};
        $scope.authError = null;

        controller.tableParams = new ngTableParams({
            page: 1,                    // show first page
            count: generalMessage.ITEMSPERPAGE_FEW,                      // count per page
            sorting: {
                idSucursal: 'desc'     // initial sorting
            }
        }, {
            total: 0,           // length of data
            getData: function ($defer, params) {

                var paramFilter = {
                    "firstResult": (params.page() - 1) * params.count(),
                    "itemsPerPage": params.count(),
                    "filterByFields": params.filter(),
                    "orderBy": params.sorting()
                };
                blockUI.start();
                var response = servicioSucursal.listarSucursalPaginado(paramFilter);
                response.then(function (data) {
                    var valor = data;
                    controller.lstSuc = data;
                    $scope.items = data.items;
                    params.total(data.totalCount);
                    $defer.resolve(data.items);
                    blockUI.stop();
                }, function (error) {
                    ngNotify.set(generalMessage.MESSAGE_ERROR, 'error');
                });


            }
        });


        var callbackObtenerOficinas = function (data) {
            console.log(data);
        };


        controller.visualiazaSucursales = function (objeto) {
            controller.sucursalObj = objeto;
        };

        controller.nuevaSucursal = function () {
            controller.objSucursal = {}
        };


        controller.editarSucursal = function (objSucursal, opcion) {
            // var obj = controller.lstSuc[$index];
            controller.objSucursal = objSucursal;
            controller.habilitarCampos = opcion;
        };


        controller.eliminarSucursal = function (objSucursal, $index) {
            blockUI.start();
            var responce = servicioSucursal.eliminarSucursal(objSucursal);
            responce.then(function (data) {
                if (data.exception == undefined || data.exception == null) {
                    blockUI.stop();
                    ngNotify.set(generalMessage.DELETEMESSAGE_OK, 'success');
                    controller.lstSuc.items.splice($index);
                } else {
                    blockUI.stop();
                    console.log(data.exception);
                    ngNotify.set(generalMessage.DELETEMESSAGE_ERROR, 'error');
                }

            }, function (error) {
                blockUI.stop();
                ngNotify.set(generalMessage.DELETEMESSAGE_ERROR, 'error');
            });
        };


        controller.cancelar = function () {
            controller.objSucursal = undefined;
            controller.sucursalObj = undefined;
            listarSucursales();
        };

        controller.guardar = function (objSucursal) {
            var nombreUpperCase = objSucursal.nombre;
            objSucursal.nombre = nombreUpperCase.toUpperCase();
            var valida = document.formSucursal.reportValidity();
            if (valida) {
                blockUI.start();
                var responce = servicioSucursal.insertarSucursal(objSucursal);
                responce.then(function (data) {
                    if (data.exception == undefined || data.exception == null) {
                        blockUI.stop();
                        ngNotify.set(generalMessage.SAVEMESSAGE_OK, 'success');
                        controller.cancelar();
                    } else {
                        blockUI.stop();
                        console.log(data.exception);
                        ngNotify.set(generalMessage.SAVEMESSAGE_ERROR, 'error');
                    }
                }, function (error) {
                    blockUI.stop();
                    console.log(data.exception);
                    ngNotify.set(generalMessage.SAVEMESSAGE_ERROR, 'error');
                });
            }
        };

        function listarSucursales() {
            blockUI.start();
            var responce = servicioSucursal.listarSucursal();
            responce.then(function (data) {
                controller.lstSuc = data;
                blockUI.stop();
            }, function (error) {
                ngNotify.set(generalMessage.MESSAGE_ERROR, 'error');
            });
        }


        function testPaginado() {
            var filtro = {
                itemsPerPage: 3,
                firstResult: 0
            }
            listarSucursalPaginado(filtro);
        }


        function iniciarFormulario() {
            controller.objSucursal = undefined;
        };

        function validarRepetidos(obj) {
            var respuesta = 0;
            if (controller.lstSuc.items.length == 0 || controller.lstSuc.items == undefined)
                return 0;
            for (var i = 0; i < controller.lstSuc.items.length; i++) {
                if (obj.nombre == controller.lstSuc.items[i].nombre)
                    return 1;
            }
        }

        iniciarFormulario();
        //listarSucursales();

    }]);
