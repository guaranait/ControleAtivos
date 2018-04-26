angular.module("AtivosModulo", []).controller("AtivosController", function($scope, $http){
	
	$scope.descricao;
	$scope.fabricante;
	$scope.dataCompra;
	$scope.valorCompra;
	$scope.valorDepreciado;
	
	console.log('ENTROU AQUI');
	
	$scope.criarUsuario = function() {
        var objetoAtivo = {};

		objetoAtivo.descricao = $scope.descricao;
		objetoAtivo.fabricante = $scope.fabricante;
		objetoAtivo.dtCompra = $scope.dataCompra;
		objetoAtivo.vlCompra = $scope.valorCompra;
		objetoAtivo.vlDepreciado = $scope.valorDepreciado;
		
		console.log(objetoAtivo);
		
		/*$http({
			url: '',
			method: "POST",
			data: objetoAtivo
		})
		.then(function(response) {
			//sucesso
		}, error => console.log(error));*/
    }
    
});