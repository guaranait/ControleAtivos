angular.module("FuncionariosModulo", []).controller("FuncionariosController", function($scope, $http) {
    $scope.nome;
    $scope.cpf;
    $scope.cnpj;
    $scope.cargo;

    $scope.criarFuncionario = function() {
        var objetoFuncionario = {};

        objetoFuncionario.nome = $scope.nome;
        objetoFuncionario.cpf = $scope.cpf;
        objetoFuncionario.cnpj = $scope.cnpj;
        objetoFuncionario.cargo = $scope.cargo;

        console.log(objetoFuncionario);

        /*$http({
            url: '',
            method: "POST",
            data: objetoFuncionario
        })
        .then(function(response) {
            //sucesso
        }, error => console.log(error));*/
    }
});
