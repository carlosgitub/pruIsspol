/**
 * Created by andres.campoverde on 28/04/2017.
 */

app.service('servicio-seleccion',['$q','$http',function ($q,$http) {
        var datosSesion=undefined;

        this.setDatosSesion=function (datosSesionLogin) {
            datosSesion=datosSesionLogin;
        };

        this.getDatosSesion= function () {
            return datosSesion;
        };
    }
    ]
);