
app.controller("OrgMenu",['$modal','general-message','blockUI','$q','ngNotify',"$scope", 'ngTableParams',
    function($modal,generalMessage ,blockUI,$q,ngNotify,  $scope , ngTableParams) {

        controller = this;
        controller.lstCarpeta= [];
        controller.objCarpetaOpcion = undefined;
        controller.editarObjeto= true;
        var modoEdicion = false;

        var tree;
        var popuptree;

        controller.my_data = [];
        controller.my_tree = tree = {};
        controller.popup_tree = popuptree = {};

        controller.my_tree_handlerPopUp = function(branch) {
            controller.objData.idCarpetaOpcion = branch.id;
            controller.objData.nombreCarpetaOpcion=branch.label;
        };

        function listarCarpetaOpcion() {
            var def = $q.defer();
            try {
                OrganizacionMenu.listarCarpetaOpcion(function (data) {
                    def.resolve(data);
                });
            }catch (ex)  {
                def.reject(ex)
            }
            return def.promise;
        };

        function insertarCarpetaOpcion (carpeta){
            var deferred = $q.defer();
            if (modoEdicion){
                try{
                    OrganizacionMenu.insertarCarpetaOpcion(carpeta, function (data) {
                        deferred.resolve(data);
                    });
                }catch (e){
                    deferred.reject(e);
                }
            }else{
                try{
                    var b = tree.get_selected_branch();
                    carpeta.idCarpetaOpcion = undefined;
                    if( b ){
                        estructura.idCarpetaOpcion = b.id;
                    }
                    OrganizacionMenu.listarCarpetaOpcion(carpeta, function (data) {
                        if( data != null){
                            deferred.resolve(data)
                        }else{
                            ngNotify.set("Error al guardar","error");
                            console.log(data);
                            deferred.resolve(data)
                        }

                    });
                }catch (e){
                    deferred.reject(e);
                }
            }
            return deferred.promise;
        }

        controller.obtenerRoot = function () {
            blockUI.start();
            listarCarpetaOpcion().then(function (data) {
                controller.my_data = data;
                blockUI.stop();
            }, function (ex) {
                alert(ex);
            });
        };

        controller.obtenerRoot();

        controller.deselectBranch = function(){
            controller.objData=undefined;
            controller.editarObjeto= true;
            modoEdicion=false;
            tree.select_branch(null);
        };

        controller.my_tree_handler = function(branch) {
            var _ref;
            controller.editarObjeto= true;
            controller.objData = branch;
            controller.output = branch.label;
            if ((_ref = branch.data) != null ? _ref.description : void 0) {
                return controller.output += '(' + branch.data.description + ')';
            }
        };

        controller.nuevo= function () {
            controller.editarObjeto= false;
            if (controller.objData!=undefined){
                var objeto ={
                    id: null,
                    "nombre": null,
                    "idCarpetaOpcion": controller.objData.idCarpetaOpcion,
                    orden:null,
                    "nombreCarpetaOpcion": controller.objData.nombreCarpetaOpcion,
                    "status": null,
                    "catalogoPlaceType": null,
                    "children": []
                };
                controller.objData = objeto;

            }else{
                controller.objData={};
            };

        };


        controller.editarCarpetaOpcion= function () {
            controller.editarObjeto= false;
            modoEdicion = true;
        };

        controller.guardarRama = function () {
            blockUI.start();
            var valida = document.formCarpetaOpcion.reportValidity();
            if (controller.formValido){
                var respuesta = insertarCarpetaOpcion(controller.objData);
                respuesta.then(function (data) {
                    if( data != null){
                        blockUI.stop();
                        if(modoEdicion){
                            controller.obtenerRoot();
                        }else{
                            controller.try_adding_a_branch();
                        }
                        controller.editarObjeto= true;
                        ngNotify.set(generalMessage.SAVEMESSAGE, 'success');
                    }else {
                        blockUI.stop();
                        console.log(data.exception);
                        ngNotify.set(data.exception.customMessage,"error");
                    }
                    modoEdicion=false;

                },function (error) {
                    blockUI.stop();
                    console.log("Error al insertar");
                });

            }else {
                blockUI.stop();
                ngNotify.set('Debe ingresar todos los campos marcados en *', 'error');
            }
        };

        return controller.try_adding_a_branch = function() {
            var b, parentId;
            b = tree.get_selected_branch();

            if(b){
                parentId = b.id;
            }
            return tree.add_branch(b, {
                id : controller.objData.id,
                label : controller.objData.nombre,
                idCarpetaOpcion : parentId,
                "idCarpetaOpcion": controller.objData.idCarpetaOpcion
            });
        };

    }]);
