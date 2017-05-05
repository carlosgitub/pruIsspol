/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/**
 * Created by nmavelin
 */

app.controller("OficinasIsspol", ['ngTableParams', 'general-message', 'blockUI', 'servicio-sucursal', 'servicio-comun', 'ngNotify', "$scope", 'ngTableParams', '$http', '$state',
    function (ngTableParams, generalMessage, blockUI, servicioSucursal, servicioComun, ngNotify, $scope, ngTableParams, $http, $state) {

        controller = this;
        controller.lstOficinas = [];
        controller.lstTipos = [];
        controller.lstSucursal = [];
        controller.lstProvincia = [];
        controller.lstCanton = [];
        controller.lstEmpresa = [];
        controller.lstEstado = [];

        $scope.user = {};
        $scope.authError = null;

        controller.tableParams = new ngTableParams({
            page: 1,                    // show first page
            count: generalMessage.ITEMSPERPAGE_FEW,                      // count per page
            sorting: {
                nombre: 'asc'     // initial sorting
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
                var response = servicioSucursal.listarOficinasPaginado(paramFilter);
                response.then(function (data) {
                    var valor = data;
                    controller.lstOficinas = data;
                    $scope.items = data.items;
                    params.total(data.totalCount);
                    $defer.resolve(data.items);
                    blockUI.stop();
                }, function (error) {
                    ngNotify.set(generalMessage.MESSAGE_ERROR, 'error');
                });


            }
        });

        controller.nuevaOficina = function () {
            controller.objOficina = {};
        };

        controller.visualiazarOficinas = function (objeto) {
            controller.objOficinaVi = objeto;
        }

        controller.editarOficina = function (objOficina, $index) {
            controller.lstOficinas.splice($index, 1);
            controller.objOficina = objOficina;
        };

        controller.eliminarOficina = function ($index) {
            controller.lstOficinas.splice($index, 1);
            ngNotify.set('Exito, registro eliminado correctamente', 'success');
        };

        controller.cancelar = function () {
            controller.objOficina = undefined;
            controller.objOficinaVi = undefined;
        };

        controller.guardar = function (objetoOficina) {

            blockUI.start();
            servicioSucursal.insertarActualizarOficina(objetoOficina).then(function (data) {
                console.log(data);
                blockUI.stop();
                if (data == '') {
                    ngNotify.set(generalMessage.SAVEMESSAGE_OK, 'success');
                } else {
                    ngNotify.set(data, 'warm');
                }
            });
        };


        function iniciarFormulario() {
            controller.objOficina = undefined;
        };


        function cargarSucursales() {
            var respuesta = servicioSucursal.listarSucursal();
            respuesta.then(function (data) {
                    controller.lstSucursal = data;
                },
                function (error) {
                    console.log(error);
                });

        };

        function cargarTipos() {
            var respuesta = servicioSucursal.listarTipoOficinas();
            respuesta.then(function (data) {
                    controller.lstTipos = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        function cargarProvincias() {
            var respuesta = servicioComun.listarProvincias();
            respuesta.then(function (data) {
                    controller.lstProvincia = data;
                },
                function (error) {
                    console.log(error);
                });

        };

        controller.cargarCantonesPorProvincia = function (objProvincia) {/*se hace publico*/
            var respuesta = servicioComun.listarCantonesPorProvincia(objProvincia);
            respuesta.then(function (data) {
                    controller.lstCanton = data;
                },
                function (error) {
                    console.log(error);
                });

        };

        function cargarEstados() {
            var respuesta = servicioComun.listarEstados();
            respuesta.then(function (data) {
                    controller.lstEstado = data;
                },
                function (error) {
                    console.log(error);
                });

        };

        iniciarFormulario();
        cargarSucursales();
        cargarTipos();
        cargarProvincias();
        cargarEstados();

    }]);
