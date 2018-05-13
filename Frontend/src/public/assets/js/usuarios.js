angular.module("UsuariosModulo", []).controller("UsuariosController", function($scope, $http) {
    $scope.idPerfil;
    $scope.username;
    $scope.senha;

    $scope.criarUsuario = function() {
        var objetoUsuario = {};

        objetoUsuario.idPerfil = $scope.idPerfil;
        objetoUsuario.username = $scope.username;
        objetoUsuario.senha = $scope.senha;

        console.log(objetoUsuario);

        /*$http({
            url: '',
            method: "POST",
            data: objetoUsuario
        })
        .then(function(response) {
            //sucesso
        }, error => console.log(error));*/
    }
});
