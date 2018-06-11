class HomeService {
	constructor($http) {
		this.$http = $http;
	}

	criarAtivo(objetoAtivo) {
		//var url = "http://localhost:8080/Restful/ativo/cadastrarAtivo?descricao=Mouse&dtCompra=01-01-2018&fabricante=Dell&vlDepreciado=45&vlCompra=50&idStatus=0";
		var url = "http://localhost:8080/Restful/ativo/cadastrarAtivo?descricao="
			+objetoAtivo.descricao
			+"&dtCompra="+objetoAtivo.dtCompra
			+"&fabricante="+objetoAtivo.fabricante
			+"&vlDepreciado="+objetoAtivo.vlDepreciado
			+"&vlCompra="+objetoAtivo.vlCompra
			+"&idStatus=0";

		return this.$http({
			url:'http://localhost:8080/Restful/ativo/cadastrarAtivo',
			method: "POST",
			data: objetoAtivo
		})
		.then( response => response ).catch( error => error );
	}

	getAtivos() {
		return this.$http({
			url: 'http://localhost:8080/Restful/ativo/listarAtivos',
			method: "GET"
		})
		.then( response => response ).catch( error => error );
	}

	alterarAtivo(objetoAtivo) {
		return this.$http({
			url:'http://localhost:8080/Restful/ativo/alterarAtivo',
			method: "POST",
			data: objetoAtivo
		})
		.then( response => response ).catch( error => error );
	}

	excluirAtivo(objetoAtivo) {
		let obj = {};
		obj.id = objetoAtivo.id;
		return this.$http({
			url: 'http://localhost:8080/Restful/ativo/excluirAtivo',
			method: "POST",
			data: obj
		})
		.then( response => response ).catch( error => error );
	}

	cadastrarManutencao(objetoManutencao) {
		console.log(objetoManutencao);
		return this.$http({
			url: 'http://localhost:8080/Restful/manutencao/cadastrarManutencao',
			method: "POST",
			data: objetoManutencao
		})
		.then( response => response ).catch( error => error );
	}

	removeManutencao() {
		console.log(objetoManutencao);
		return this.$http({
			url: 'http://localhost:8080/Restful/manutencao/cadastrarManutencao',
			method: "POST",
			data: objetoManutencao
		})
		.then( response => response ).catch( error => error );
	}
}

HomeService.$inject = ['$http'];

export default HomeService;