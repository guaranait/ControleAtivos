class GarantiaService {
	constructor($http) {
		this.$http = $http;
	}

	getGarantias() {
		return this.$http({
			url: 'http://localhost:8080/Restful/garantia/listarGarantias',
			method: "GET"
		})
		.then( response => response ).catch( error => error );
	}

	adicionarGarantia(objetoGarantia) {
		console.log(objetoGarantia);
		return this.$http({
			url:'http://localhost:8080/Restful/garantia/cadastrarGarantia',
			method: "POST",
			data: objetoGarantia
		})
		.then( response => response ).catch( error => error );
	}

	excluirGarantia(objetoGarantia) {
		console.log(objetoGarantia);
		return this.$http({
			url:'http://localhost:8080/Restful/garantia/excluirGarantia',
			method: "POST",
			data: objetoGarantia
		})
		.then( response => response ).catch( error => error );
	}

}

GarantiaService.$inject = ['$http'];

export default GarantiaService;