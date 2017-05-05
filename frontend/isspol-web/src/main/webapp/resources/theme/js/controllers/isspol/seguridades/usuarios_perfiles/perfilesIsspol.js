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

app.controller("PerfilesIsspol",['ngNotify',"$scope", 'ngTableParams',
    function( ngNotify,  $scope , ngTableParams) {

        controller = this;
        controller.lstPerfiles = [];

        controller.nuevoPerfil = function(){
            controller.perfil = {}
        };

        controller.visualizarPerfil=function (objeto) {
            controller.objPerfilVi= objeto;
        }

        controller.editarPerfil = function(perfil,$index){
            controller.lstPerfiles.splice($index,1);
            controller.perfil= perfil;
        };

        controller.eliminarPerfil = function($index){
            controller.lstPerfiles.splice($index, 1);
            ngNotify.set('Exito, registro eliminado correctamente', 'success');
        };

        controller.cancelar = function(){
            controller.perfil = undefined;
            controller.objPerfilVi = undefined;
        };

        controller.guardar = function(perfil){
            var validacion=document.formPerfil.reportValidity();
            if(validacion){
                var of = {
                    id:perfil.id,
                    tipo:perfil.tipo,
                    nombre:perfil.nombre,
                    ciudad:perfil.ciudad,
                    direccion:perfil.direccion,
                    telefono: perfil.telefono
                };
                controller.lstPerfiles.push(of);
                ngNotify.set('Exito, registro creado correctamente', 'success');
                iniciarFormulario();
            }else{
                ngNotify.set('Debe ingresar todos los campos marcados en *', 'error');
            }

        };

        function iniciarFormulario(){
            controller.perfil = undefined;
        };

        iniciarFormulario();
    }]);
