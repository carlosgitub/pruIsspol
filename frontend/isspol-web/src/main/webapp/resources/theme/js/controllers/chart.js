'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('FlotChartDemoCtrl', ['$modal','$scope', 'servicio-seleccion','servicio-oficina','servicio-grupo','servicio-usuario',
      function($modal,$scope,servicioSeleccion,servicioOficina,servicioGrupo,servicioUsuario) {
    $scope.d = [ [1,6.5],[2,6.5],[3,7],[4,8],[5,7.5],[6,7],[7,6.8],[8,7],[9,7.2],[10,7],[11,6.8],[12,7] ];

    $scope.d0_1 = [ [0,7],[1,6.5],[2,12.5],[3,7],[4,9],[5,6],[6,11],[7,6.5],[8,8],[9,7] ];

    $scope.d0_2 = [ [0,4],[1,4.5],[2,7],[3,4.5],[4,3],[5,3.5],[6,6],[7,3],[8,4],[9,3] ];

    $scope.d1_1 = [ [10, 120], [20, 70], [30, 70], [40, 60] ];

    $scope.d1_2 = [ [10, 50],  [20, 60], [30, 90],  [40, 35] ];

    $scope.d1_3 = [ [10, 80],  [20, 40], [30, 30],  [40, 20] ];

    $scope.d2 = [];

    $scope.mostrarSeleccion=undefined;
    $scope.gruposUsuario={};
    $scope.oficinasUsuario={};
          $scope.lstOficinas={
              creacionEquipo: null,
              creacionFecha: null,
              creacionUsuario: null,
              eliminado: null,
              exception: null,
              idUsuarioOficina: null,
              modificaEquipo: null,
              modificaFecha: null,
              modificaUsuario: null,
              oficina: null,
              usuario: null
          };

    function abrirModal() {
        // $scope.popup_data=data;
        $scope.openModal('modal-solicitar-opciones', 'sm');
    };

      $scope.openModal = function(modal_id, modal_size, modal_backdrop) {
          $scope.currentModal = $modal.open({
              templateUrl: modal_id,
              scope:$scope
          });
      };

      $scope.close=function(){
          $scope.currentModal.dismiss();//$scope.modalInstance.close() also works I think
      };

    function obtenerDatosSesion() {
        if($scope.datosInicioSesion===undefined||$scope.datosInicioSesion===null){
            $scope.datosInicioSesion=servicioSeleccion.getDatosSesion();
            obtenerOficinasPorIdUsuario();
            abrirModal();
        }
    }

    function obtenerOficinaPorId() {
        var response=servicioOficina.buscarOficinaPorId($scope.datosInicioSesion[0].OFICINA);
        response.then(function (data) {
            $scope.oficinaUsuario=data;
        },function (error) {
            console.log(error);
        });
    }

          function obtenerGrupoPorId() {
              var response=servicioGrupo.buscarGrupoPorId($scope.datosInicioSesion[0].GRUPO);
              response.then(function (data) {
                  $scope.grupoUsuario=data;
              },function (error) {
                  console.log(error);
              });
          }
    
    function obtenerOficinasPorIdUsuario() {
        var response=servicioUsuario.listarUsuarioOficinaPorIdUsuario($scope.datosInicioSesion.idUsuario);
        response.then(function (data) {
            $scope.lstOficinas=data;
            // $scope.lstTOficinas=angular.copy(data);
            // for(var i=0;i<$scope.lstTOficinas.length;i++){
            //     // $scope.oficina=data[i];
            //     $scope.lstOficinas.push($scope.lstTOficinas[i]);
            // }
            // console.log($scope.lstOficinas[0].oficina.nombre);
            obtenerGruposPorIdUsuario();
        },function (error) {
            console.log(error);
        });
    }

    function obtenerGruposPorIdUsuario() {
        var response=servicioUsuario.listarGrupoUsuarioPorUsuario($scope.datosInicioSesion.idUsuario);
        response.then(function (data) {
            $scope.lstGrupoUsuario=data;
            console.log(data);
        },function (error) {
            console.log(error);
        });
    }
    $scope.buscarDefault=function () {
        obtenerOficinaPorId();
        obtenerGrupoPorId();
    };

    for (var i = 0; i < 20; ++i) {
      $scope.d2.push([i, Math.sin(i)]);
    }   

    $scope.d3 = [ 
      { label: "iPhone5S", data: 40 }, 
      { label: "iPad Mini", data: 10 },
      { label: "iPad Mini Retina", data: 20 },
      { label: "iPhone4S", data: 12 },
      { label: "iPad Air", data: 18 }
    ];

    $scope.refreshData = function(){
      $scope.d0_1 = $scope.d0_2;
    };

    $scope.getRandomData = function() {
      var data = [],
      totalPoints = 150;
      if (data.length > 0)
        data = data.slice(1);
      while (data.length < totalPoints) {
        var prev = data.length > 0 ? data[data.length - 1] : 50,
          y = prev + Math.random() * 10 - 5;
        if (y < 0) {
          y = 0;
        } else if (y > 100) {
          y = 100;
        }
        data.push(y);
      }
      // Zip the generated y values with the x values
      var res = [];
      for (var i = 0; i < data.length; ++i) {
        res.push([i, data[i]])
      }
      return res;
    }

    $scope.d4 = $scope.getRandomData();
    obtenerDatosSesion();
  }]);