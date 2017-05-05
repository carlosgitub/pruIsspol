/**
 * Created by andres.campoverde on 17/03/2017.
 */

app.controller('UsuariosPerfiles', ['blockUI', 'servicio-usuario','servicio-grupo','servicio-estacion','servicio-comun','general-message','ngNotify', "$scope", 'ngTableParams',
                         function (blockUI, usuarioServicio, grupoServicio, estacionServicio, comunServicio, generalMessage, ngNotify, $scope, ngTableParams) {

        controller = this;

        controller.lstUsers = [];
        controller.lstCoordinaciones = [];
        controller.lstHorarios = [];
        controller.lstEstado = [];
        controller.lstEstadoGrupoUsuario = [];
        controller.lstEstructura = [];
        controller.idPersonaSubtipo = 0;

        controller.lstEstacion= [];
        controller.lstEstacionUsuario = [];
        controller.lstGrupo= [];
        controller.lstGrupoUsuario = [];

        controller.usuarioTemporal={
            idUsuario:'',
            identificacion:'',
            personaTipoSubtipo: null,
            email:''
        };

        controller.lstGrupoUsuario = [];
        controller.esUsuarioCopia=false;

        var index = undefined;
        controller.seleccionFuncion = undefined;
        controller.mostarBtnCancelaLin = false;

        /**
         * Metodo para cargar lista de usuarios
         * Paul Salgado
         * 20/04/2017
         */
        controller.listaUsuario = function () {
            blockUI.start();
            var respuesta = usuarioServicio.listaUsuario();
            respuesta.then(function (data) {
                    concatenarNombres(data);
                    blockUI.stop();
                },
                function (error) {
                    console.log(error);
                });
        };
        controller.listaUsuario();

        function concatenarNombres(lista) {
            for (var i = 0; i < lista.length; i++) {
                lista[i].nombres = lista[i].personaTipoSubtipo.persona.apellidoPaterno + " " + lista[i]
                        .personaTipoSubtipo.persona.apellidoMaterno + " " + lista[i]
                        .personaTipoSubtipo.persona.nombre;
            }
            controller.lstUsers = lista;
        }

        /**
         * Metodo para cargar lista de oficinas
         * Paul Salgado
         * 20/04/2017
         */
        function cargarOficinas() {
            var respuesta = usuarioServicio.listaOficina();
            respuesta.then(function (data) {
                    controller.lstCoordinaciones = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        /**
         * Metodo para cargar lista de horarios
         * Paul Salgado
         * 20/04/2017
         */
        function cargarHorarios() {
            var respuesta = usuarioServicio.listaHorario();
            respuesta.then(function (data) {
                    controller.lstHorarios = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        /**
         * Metodo para cargar lista de estados
         * Paul Salgado
         * 20/04/2017
         */
        function cargarEstados() {
            var respuesta = usuarioServicio.listaEstadoUsuario();
            respuesta.then(function (data) {
                    controller.lstEstado = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        /**
         * Metodo para cargar lista de estructura organizacional
         * Paul Salgado
         * 20/04/2017
         */
        function cargarEstructuras() {
            var respuesta = usuarioServicio.listaEstructura();
            respuesta.then(function (data) {
                    controller.lstEstructura = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        /**
         * Metodo para cargar lista de EstacionUsuario por Usuario
         * Mavelin Ati
         * 25/04/2017
         */
        function listarEstacionUsuarioPorUsuario(idUsuario) {
            var respuesta = usuarioServicio.listarEstacionUsuarioPorUsuario(idUsuario);
            respuesta.then(function (data) {
                    controller.lstEstacionUsuario = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        /**
         * Metodo para cargar lista de Estacion no eliminados
         * Mavelin Ati
         * 25/04/2017
         */
        function listarTodosEstacion() {
            var respuesta = estacionServicio.listarTodosEstacion();
            respuesta.then(function (data) {
                    controller.lstEstacion = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        /**
         * Metodo para cargar lista de GrupoUsuario por Usuario no eliminados
         * Mavelin Ati
         * 25/04/2017
         */
        function listarGrupoUsuarioPorUsuario(idUsuario) {
            var respuesta = usuarioServicio.listarGrupoUsuarioPorUsuario(idUsuario);
            respuesta.then(function (data) {
                    controller.lstGrupoUsuario = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        /**
         * Metodo para cargar toda la lista de Grupo
         * Mavelin Ati
         * 25/04/2017
         */
        function listarGrupo() {
            var respuesta = grupoServicio.listarGrupos();
            respuesta.then(function (data) {
                    controller.lstGrupo = data;
                },
                function (error) {
                    console.log(error);
                });
        };

        controller.notificacionBloqueo = function () {
            var validacion = document.formUsuarios.reportValidity();
            if (!validacion) {
                ngNotify.set('Ingrese un usuario antes de continuar', {type: 'error', sticky: true});
            }
        }

        controller.editarUsuario = function (objUsuario) {
            blockUI.start();
            controller.objUsuario = objUsuario;
            listarGrupoUsuarioPorUsuario(objUsuario.idUsuario);
            listarEstacionUsuarioPorUsuario(objUsuario.idUsuario);
            blockUI.stop();
        };

        controller.elimiarRegistro = function ($index) {
            controller.lstUsers.splice($index, 1);
            ngNotify.set('Exito registro eliminado correctamente', 'success');
        };

        controller.updateList = function () {
            if (controller.lstUsers.length == 0)
                return -1
            controller.lstAux = controller.lstUsers;
            controller.lstUsers = [];
            for (var i = 0; i < controller.lstAux.length; i++) {
                controller.lstUsers.push(controller.lstAux[i]);
            }
            ;
        };

        controller.nuevaLinea = function () {
            switch (seleccionFuncion) {
                case 1:
                    controller.objUsuario = {};
                    index = undefined;
                    break;
                case 2:
                    controller.mostarBtnCancelaLin = true;
                    controller.usrGrupoUsuario = {};
                    controller.usrGrupoUsuarioVer = undefined;
                    break;
                case 3:
                    controller.mostarBtnCancelaLin = true;
                    controller.usrEstacionUsuario = {};
                    controller.usrEstacionUsuarioVer = undefined;
                    break;
                case 4:
                    document.formEstacionUsuario.reportValidity();
                    break;
                case 5:
                    controller.object = {};
                    controller.mostarBtnCancelaLin = true;
                    break;
            }
        };

        controller.cancelarIngresoLineas = function () {
            controller.mostarBtnCancelaLin = false;
            controller.object = undefined;
            controller.usrGrupoUsuario = undefined;
            controller.usrEstacionUsuario = undefined;
        };

        controller.cancelarGrupoUsuario = function () {
            controller.usrGrupoUsuario = undefined
            controller.mostarBtnCancelaLin = false;
        };

        controller.cancelarEstacionUsuario = function () {
            controller.usrEstacionUsuario = undefined
            controller.mostarBtnCancelaLin = false;
        };

        controller.nuevo = function () {
            controller.updateList();
            controller.objUsuario = {
                cualquierEstacion: false,
                estadoUsuario : {
                    idEstadoUsuario: 1,
                    descripcion: 'Activo'
                },
                tiempoInactividad: 6000
            };
            controller.userTemp = {};
        };

        function cargarDashboard() {
            controller.lstDashBoard = [];
            var dashBoard = {
                id: 1,
                nombre: "DashBoard 1"
            };
            controller.lstDashBoard.push(dashBoard);

            dashBoard = {
                id: 2,
                nombre: "DashBoard 2"
            };
            controller.lstDashBoard.push(dashBoard);

            dashBoard = {
                id: 3,
                nombre: "DashBoard 3"
            };
            controller.lstDashBoard.push(dashBoard);
        };

        function cargarEstadoGrupoUsuario() {
            var respuesta = comunServicio.listarEstados();
            respuesta.then(function (data) {
                    controller.lstEstadoGrupoUsuario = data;
                },
                function (error) {
                    console.log(error);
                });
        }

        controller.guardarUsuario = function (objetoUsuario) {
            var objUsuario = {};
            if (objetoUsuario.usuario != null) {
                objUsuario.usuario = angular.copy(objetoUsuario.usuario);
                var usuario = {
                    idUsuario: objUsuario.usuario.idUsuario
                }
                objUsuario.usuario = usuario;
            }
            if (objetoUsuario.estructuraOrganizacional != null) {
                objUsuario.estructuraOrganizacional = angular.copy(objetoUsuario.estructuraOrganizacional);
                var estructuraOrganizacional = {
                    id: objetoUsuario.estructuraOrganizacional.id
                }
                objUsuario.estructuraOrganizacional = estructuraOrganizacional;
            }
            if (objetoUsuario.estadoUsuario != null) {
                objUsuario.estadoUsuario = angular.copy(objetoUsuario.estadoUsuario);
                var estadoUsuario = {
                    idEstadoUsuario: objetoUsuario.estadoUsuario.idEstadoUsuario
                }
                objUsuario.estadoUsuario = estadoUsuario;
            }
            if (objetoUsuario.horario != null) {
                objUsuario.horario = angular.copy(objetoUsuario.horario);
                var horario = {
                    idHorario: objetoUsuario.horario.idHorario
                }
                objUsuario.horario = horario;
            }
            var personaSubtipo = {
                idPersonaTipoSubtipo: controller.idPersonaSubtipo
            }
            objUsuario.personaTipoSubtipo = personaSubtipo;
            objUsuario.idUsuario = objetoUsuario.idUsuario;
            objUsuario.email = objetoUsuario.email;
            objUsuario.identificacion = objetoUsuario.identificacion;
            objUsuario.cualquierEstacion = objetoUsuario.cualquierEstacion;
            objUsuario.tiempoInactividad = objetoUsuario.tiempoInactividad;
            objUsuario.cambiarPwdProximoLogon = objetoUsuario.cambiarPwdProximoLogon;
            objUsuario.noPuedeCambiarPwd = objetoUsuario.noPuedeCambiarPwd;
            objUsuario.pwdNuncaExpira = objetoUsuario.pwdNuncaExpira;
            objUsuario.bloqueada = objetoUsuario.bloqueada;
            objUsuario.usuarioSecuencial = objetoUsuario.usuarioSecuencial;
            objUsuario.idDashboardInicio = 1;
            blockUI.start();
            if (objetoUsuario.usuarioSecuencial == null || objetoUsuario.usuarioSecuencial == 0) {
                usuarioServicio.insertarUsuario(objUsuario).then(function (data) {
                    console.log(data);
                    blockUI.stop();
                    if (data.RETURN_VALUE == 1) {
                        ngNotify.set('Usuario Ingresado Exitosamente', 'success');
                        controller.cambioClave(objUsuario);
                    } else {
                        ngNotify.set(data.AS_MSJ, 'warm');
                    }
                });
            } else {
                usuarioServicio.actualizarUsuarioSP(objUsuario).then(function (data) {
                    console.log(data);
                    blockUI.stop();
                    if (data.RETURN_VALUE == 1) {
                        ngNotify.set('Usuario Actualizado Exitosamente', 'success');
                    } else {
                        ngNotify.set(data.AS_MSJ, 'warm');
                    }
                });
            }
            controller.listaUsuario();
        };

        controller.cambioClave = function (objUsuario) {
            blockUI.start();
            usuarioServicio.procUsuarioSolicitudCambioClave(objUsuario).then(function (data) {
                console.log(data);
                blockUI.stop();
                if (data.RETURN_VALUE == 1) {
                    ngNotify.set(generalMessage.CORREOCAMBIOCONTRASENA, 'success');
                } else {
                    ngNotify.set(data.AS_MSJ, 'warm');
                }
            });
        }

        controller.desbloquearCuenta = function (objUsuario) {
            blockUI.start();
            usuarioServicio.procUsuarioVerificarBloqueo(objUsuario).then(function (data) {
                console.log(data);
                blockUI.stop();
                if (data.RETURN_VALUE == 1) {
                    ngNotify.set(generalMessage.SAVEMESSAGE_OK, 'success');
                    controller.objUsuario.bloqueada = 0;
                } else {
                    ngNotify.set(data.AS_MSJ, 'warm');
                }
            });
        }

        controller.actualizarUsuario = function (objUsuario) {
            blockUI.start();
            usuarioServicio.actualizarUsuario(objUsuario).then(function (data) {
                console.log(data);
                blockUI.stop();
                if (data == null) {
                    ngNotify.set('Registro guardado correctamente', 'success');
                } else {
                    ngNotify.set(data, 'warm');
                }
            });
        };

        controller.validarFormularioInsertarUsuario = function (objUsuario) {
            if (objUsuario.usuarioSecuencial == null) {
                blockUI.start();
                usuarioServicio.validarFormularioInsertarUsuario(objUsuario).then(function (data) {
                    console.log(data.AS_MSJ);
                    blockUI.stop();
                    if (data == null) {
                        ngNotify.set('No se ha podido recuperar el usuario', 'error');
                    } else {
                        if (data.RETURN_VALUE == -1) {
                            controller.objUsuario.idUsuario = null;
                            controller.userTemp.apellidoPaterno = null;
                            controller.userTemp.apellidoMaterno = null;
                            controller.userTemp.nombres = null;
                            controller.objUsuario.email = null;
                            controller.idPersonaSubtipo = null;
                            ngNotify.set(data.AS_MSJ, 'warn');
                        } else {
                            controller.objUsuario.idUsuario = data.AS_IDUSUARIO;
                            controller.userTemp.apellidoPaterno = data.AS_APELLIDOPATERNO;
                            controller.userTemp.apellidoMaterno = data.AS_APELLIDOMATERNO;
                            controller.userTemp.nombres = data.AS_NOMBRES;
                            controller.objUsuario.email = data.AS_CORREO;
                            controller.idPersonaSubtipo = data.AI_IDPERSONASUBTIPO;
                        }
                    }
                });
            }
        };

        controller.guardar = function () {
            $scope;
            switch (seleccionFuncion) {
                case 1:
                    var valida = document.formUsuarios.reportValidity();
                    var invalid = $scope.$$childTail.$$childHead.$$childHead.formUsuarios.$valid;
                    if (valida && invalid) {
                        controller.guardarUsuario(controller.objUsuario);
                        break;
                    } else {
                        ngNotify.set('Debe ingresar todos los campos marcados en *', 'error');
                        break;
                    }
                case 2:
                    var valida = document.formGrupoUsuario.reportValidity();
                    if (valida && controller.usrGrupoUsuario.grupo !== undefined
                        && controller.usrGrupoUsuario.estado !== undefined) {
                        controller.guardarGrupoUsuario(controller.usrGrupoUsuario);
                        break;
                    } else {
                        ngNotify.set('Debe ingresar todos los campos marcados en *', 'error');
                        break;
                    }
                case 3:
                    var valida = document.formEstacionUsuario.reportValidity();
                    if (valida && controller.usrEstacionUsuario.estacion !== undefined) {
                        controller.guardarEstacionUsuario(controller.usrEstacionUsuario);
                        break;
                    } else {
                        ngNotify.set('Debe ingresar todos los campos marcados en *', 'error');
                        break;
                    }
                case 4:
                    document.formEstacionUsuario.reportValidity();
                    break;
                case 5:
                    var validacion = document.formCoordinaciones.reportValidity();
                    if (validacion && controller.object.oficina !== undefined) {
                        controller.guardarCoordinaciones();
                        break;
                    } else {
                        ngNotify.set('Debe ingresar todos los campos marcados en *', 'error');
                        break;
                    }
            }
        };

        controller.guardarGrupoUsuario = function (usrGrupoUsuario) {
            var valida = document.formGrupoUsuario.reportValidity();
            if (valida) {
                blockUI.start();
                usrGrupoUsuario.usuario = controller.objUsuario;
                usrGrupoUsuario.estado = controller.usrGrupoUsuario.estado.idEstado;
                if (usrGrupoUsuario.tieneVencimiento != null) {
                    usrGrupoUsuario.tieneVencimiento = controller.usrGrupoUsuario.tieneVencimiento;
                } else {
                    usrGrupoUsuario.tieneVencimiento = false;
                }
                usrGrupoUsuario.fechaVencimiento = controller.usrGrupoUsuario.fechaVencimiento;

                var responce = usuarioServicio.insertarActualizarGrupoUsuario(usrGrupoUsuario);
                responce.then(function (data) {
                        if (data.exception == undefined || data.exception == null) {
                            blockUI.stop();
                            ngNotify.set('El registro se guardo correctamente', 'success');
                            controller.cancelarGrupoUsuario();
                        } else {
                            blockUI.stop();
                            console.log(data.exception);
                            ngNotify.set('Error al guardar el registro', 'error');
                        }
                        listarGrupoUsuarioPorUsuario(controller.objUsuario.idUsuario);
                    }, function (error) {
                        blockUI.stop();
                        ngNotify.set('Error al guardar el registro', 'error');
                    }
                );
            }
        }

        controller.guardarEstacionUsuario = function (usrEstacionUsuario) {
            var valida = document.formEstacionUsuario.reportValidity();
            if (valida) {
                blockUI.start();
                usrEstacionUsuario.usuario = controller.objUsuario;

                var responce = usuarioServicio.insertarActualizarEstacionUsuario(usrEstacionUsuario);
                responce.then(function (data) {
                        if (data.exception == undefined || data.exception == null) {
                            blockUI.stop();
                            ngNotify.set('El registro se guardo correctamente', 'success');
                            controller.cancelarEstacionUsuario();
                        } else {
                            blockUI.stop();
                            console.log(data.exception);
                            ngNotify.set('Error al guardar el registro', 'error');
                        }
                    listarEstacionUsuarioPorUsuario(controller.objUsuario.idUsuario);
                    }, function (error) {
                        blockUI.stop();
                        ngNotify.set('Error al guardar el registro', 'error');
                    }
                );
            }
        }

        controller.seleccionarTab = function (steep) {
            controller.activarFoto = steep;
            seleccionFuncion = steep;
        };

        //Inicio de creacion de oficinas para un usuario

        controller.usuarioRegistro = {
            idUsuario: 1,
            nombre: "Javier Almeida"
        };

        function buscarUsuario(objUsuario) {
            for (var i = 0; i < controller.lstUsers.length; i++) {
                if (controller.lstUsers[i].idUsuario = objUsuario.idUsuario)
                    controller.lstUsers[i] = objUsuario;
            }
        };

        function actualizarLista() {
            if (index != undefined)
                controller.lstUsers[index] = controller.objUsuario;

            if (index == undefined) {
                // var ind = controller.lstUsers.indexOf(controller.user);
                // controller.lstUsers[ind]= controller.user;
                buscarUsuario(controller.objUsuario);
            } else {

            }
        };

        controller.guardarCoordinaciones = function () {
            if (controller.object == undefined) {
                ngNotify.set('Debe ingresar un nuevo registro para poder continuar', 'warn');
            } else {
                controller.object.creacionUsuario = controller.usuarioRegistro;
                controller.object.creacionFecha = new Date();
                if (controller.lstCoordinaciones == undefined)
                    controller.lstCoordinaciones = [];

                controller.lstCoordinaciones.push(controller.object);
                ngNotify.set('Exito registro guardado correctamente', 'success');
                actualizarLista();
                controller.cancelarIngresoLineas();
            }
        };

        controller.lstCoordinaciones = [];
        controller.logActividades = [];

        function cargarActividades() {
            var objActividad = {
                tipoActividad: 'DESBLOQUEAR',
                anteriorActividad: '1',
                nuevoActividad: '0',
                creacionUsuarioActividad: 'Admin',
                creacionFechaActividad: '09/03/2017'
            };
            controller.logActividades.push(objActividad);
        }

        controller.insertarOficina = function (objOficina) {
            controller.lstCoordinaciones.push(objOficina);
        };

        controller.cancelar = function () {
            controller.objUsuario = undefined;
        };

        //CRUD GrupoUSuario
        //------------------------------------------------------
        controller.actualizarGrupoUsuario = function (registro, $index) {
            controller.lstGrupoUsuario.splice($index, 1);
            controller.usrGrupoUsuario = registro;
            controller.mostarBtnCancelaLin = false;
        };

        controller.verGrupoUsuario = function (registro, $index) {
            controller.usrGrupoUsuario = undefined;
            controller.usrGrupoUsuarioVer = registro;
            controller.mostarBtnCancelaLin = true;
        };

        controller.editarGrupoUsuario = function (registro, $index) {
            controller.lstGrupoUsuario.splice($index, 1);
            controller.usrGrupoUsuario = registro;
            controller.usrGrupoUsuarioVer = undefined;
            controller.mostarBtnCancelaLin = true;
        };

        controller.eliminarGrupoUsuario = function (registro, $index) {
            blockUI.start();
            var responce = usuarioServicio.eliminarGrupoUsuario(registro);
            responce.then(function (data) {
                blockUI.stop();
                ngNotify.set('Exito registro eliminado correctamente', 'success');
                controller.lstGrupoUsuario.splice($index, 1);
                controller.cancelarGrupoUsuario();
            }, function (error) {
                ngNotify.set('Error al guardar el registro', 'error');
            });
        };

        // CRUD EstacionUsuario
        // -----------------------------------------------------------------------------
        controller.verEstacionUsuario = function (registro, $index) {
            controller.usrEstacionUsuario = undefined;
            controller.usrEstacionUsuarioVer = registro;
            controller.mostarBtnCancelaLin = true;
        };

        controller.eliminarEstacionUsuario = function (registro, $index) {
            blockUI.start();
            var responce = usuarioServicio.eliminarEstacionUsuario(registro);
            responce.then(function (data) {
                blockUI.stop();
                ngNotify.set('Exito registro eliminado correctamente', 'success');
                controller.lstEstacionUsuario.splice($index, 1);
                controller.cancelarEstacionUsuario();
            }, function (error) {
                ngNotify.set('Error al guardar el registro', 'error');
            });
        };

        controller.editarOficina = function (registro, $index) {
            controller.lstCoordinaciones.splice($index, 1);
            controller.object = registro;
            controller.mostarBtnCancelaLin = false;
        };

        controller.eliminarOficina = function ($index) {
            controller.lstCoordinaciones.splice($index, 1);
        };

        controller.copiarUsuario=function (usuario,$index) {
            // controller.usuarioTemporal=usuario;
            controller.usuarioTemporal=angular.copy(usuario);
            controller.esUsuarioCopia=true;
            controller.userTemp = {};
            controller.usuarioTemporal.usuarioSecuencial=null;
            controller.lstUsers.push(controller.usuarioTemporal);
            // console.log(controller.lstUsers);
            controller.objUsuario=controller.usuarioTemporal;
        };

        cargarOficinas();
        cargarEstados();
        cargarEstadoGrupoUsuario();
        cargarEstructuras();
        cargarActividades();
        cargarHorarios();
        cargarDashboard();
        listarTodosEstacion();
        listarGrupo();
    }
])
;