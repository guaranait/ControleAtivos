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
		return this.$http({
			url:'http://localhost:8080/Restful/garantia/cadastrarGarantia',
			method: "POST",
			data: objetoGarantia
		})
		.then( response => response ).catch( error => error );
	}

}

GarantiaService.$inject = ['$http'];

export default GarantiaService;