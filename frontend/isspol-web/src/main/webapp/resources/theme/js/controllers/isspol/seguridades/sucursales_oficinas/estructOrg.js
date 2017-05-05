
app.controller("EstructOrg",['$modal','general-message','blockUI','$q','ngNotify',"$scope", 'ngTableParams',
    function($modal,generalMessage ,blockUI,$q,ngNotify,  $scope , ngTableParams) {

        controller = this;
        controller.lstPerfiles= [];
        controller.lstNiveles = [];
        controller.objEstOrg = undefined;
        controller.editarObjeto= true;
        var modoEdicion = false;

        var tree;
        var popuptree;

        controller.my_data = [];
        controller.my_tree = tree = {};
        controller.popup_tree = popuptree = {};

        controller.my_tree_handlerPopUp = function(branch) {
            controller.objData.padreEstructuraOrganizacional = branch.id;
            controller.objData.labelPadre=branch.label;
        };

        controller.eliminarEstructura = function () {

            if (controller.objData== undefined){
                ngNotify.set("Debe seleccionar un registro", 'error');
            }else{
                blockUI.start();

            eliminarEstructuraOrganizacional(controller.objData).then(function (data) {
                if( data.exception.customMessage ==""){
                    blockUI.stop();
                    controller.editarObjeto= true;
                    ngNotify.set(generalMessage.SAVEMESSAGE, 'success');
                    controller.obtenerRoot();

                }else {
                    blockUI.stop();
                    console.log(data.exception);
                    ngNotify.set(data.exception.customMessage,"error");
                }
            },function (error) {
                console.log(error);
            });
            }
        };


        controller.abrirPanel = function () {
            blockUI.start();
            listarEstructuraOrganizacional().then(function (data) {
                controller.popup_data=data;
                controller.openModal('modal-confirmar-solicitud', 'sm');
                blockUI.stop();
            }, function (ex) {
                alert(ex);
            });
        };


        controller.openModal = function(modal_id, modal_size, modal_backdrop) {
            $scope.currentModal = $modal.open({
                templateUrl: modal_id,
                scope:$scope
            });
        };

        controller.close=function(){
            $scope.currentModal.dismiss();//$scope.modalInstance.close() also works I think
        };


        function eliminarEstructuraOrganizacional(estructura) {
            var def = $q.defer();
            try {
                EstructuraOrganizacional.elimiarEstructuraOrganizacional(estructura,function (data) {
                    def.resolve(data);
                });
            }catch (ex)  {
                def.reject(ex)
            }
            return def.promise;
        };


        function listarEstructuraOrganizacional() {
          var def = $q.defer();
          try {
              EstructuraOrganizacional.listarEstructuraOrganizacional(function (data) {
                  def.resolve(data);
              });
          }catch (ex)  {
            def.reject(ex)
          }
            return def.promise;
        };


        function listarTodosNivelEstructuraOrg() {
            var def = $q.defer();
            try {
                EstructuraOrganizacional.listarTodosNivelEstructuraOrg(function (data) {
                    def.resolve(data);
                });
            }catch (ex)  {
                def.reject(ex)
            }
            return def.promise;
        };



        function insertarEstructura (estructura){
            var deferred = $q.defer();
            if (modoEdicion){
                try{
                    EstructuraOrganizacional.insertarEstrOrganizacional(estructura, function (data) {
                        deferred.resolve(data);

                    });
                }catch (e){
                    deferred.reject(e);
                }

            }else{
                try{
                    var b = tree.get_selected_branch();
                    estructura.padreEstructuraOrganizacional = undefined;
                    if(b){
                        estructura.padreEstructuraOrganizacional =b.id;
                    }

                    EstructuraOrganizacional.insertarEstrOrganizacional(estructura, function (data) {
                        if( data.excepcion== undefined){
                            deferred.resolve(data)
                        }else {
                            ngNotify.set("Error al guardar","error");
                            console.log(data.excepcion);
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
            listarEstructuraOrganizacional().then(function (data) {
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
                    "label": null,
                    "idEstructuraPadre": controller.objData.idEstructuraPadre,
                    orden:null,
                    "labelPadre": controller.objData.label,
                    "status": null,
                    "catalogoPlaceType": null,
                    "children": []
                };
                controller.objData = objeto;

            }else{
                controller.objData={};
            };

        };


        controller.editarEstructura= function () {
            controller.editarObjeto= false;
            modoEdicion = true;

        };

        controller.guardarRama = function () {
            blockUI.start();
            var valida = document.formEstructura.reportValidity();
            if (controller.formValido){
                var respuesta = insertarEstructura(controller.objData);
                respuesta.then(function (data) {

                    if( data.exception.customMessage ==""){
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






        controller.cargarNiveles=function() {
            listarTodosNivelEstructuraOrg().then(
              function (miLista) {
                  controller.lstNiveles = miLista;
              },function (error) {
                    console.log(error);
                }
            );

        };


        controller.cargarNiveles();



        return controller.try_adding_a_branch = function() {
            var b, parentId;
            b = tree.get_selected_branch();

            if(b){
                parentId = b.id;
            }
            return tree.add_branch(b, {
                id : controller.objData.id,
                label : controller.objData.label,
                idEstructuraPadre : parentId,
                "idEstructuraPadre": controller.objData.idEstructuraPadre,
                nivel:controller.objData.nivel
            });
        };



    }]);
