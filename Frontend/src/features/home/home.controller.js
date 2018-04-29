import moment from 'moment';

class HomeController {
  constructor($http) {
    this.descricao;
	this.fabricante;
	this.dataCompra;
	this.valorCompra;
	this.valorDepreciado;
	this.$http = $http;
  }

  changeName() {
    this.name = 'Tutorial UI-Route';
  }

  criarAtivo() {
        var objetoAtivo = {};

		objetoAtivo.descricao = this.descricao;
		objetoAtivo.fabricante = this.fabricante;
		objetoAtivo.dtCompra = moment(this.dataCompra).format("DD-MM-YYYY");
		objetoAtivo.vlCompra = this.valorCompra;
		objetoAtivo.vlDepreciado = this.valorDepreciado;
		
		console.log(objetoAtivo);
		
		//URL para exemplo
		//var url = "http://localhost:8080/Restful/ativo/cadastrarAtivo?descricao=Mouse&dtCompra=01-01-2018&fabricante=Dell&vlDepreciado=45&vlCompra=50&idStatus=0";
		var url = "http://localhost:8080/Restful/ativo/cadastrarAtivo?descricao="
			+this.descricao
			+"&dtCompra="+this.dataCompra
			+"&fabricante="+this.fabricante
			+"&vlDepreciado="+this.valorDepreciado
			+"&vlCompra="+this.valorCompra
			+"&idStatus=0";

		this.$http({
			url: 'http://localhost:8080/Restful/ativo/cadastrarAtivo',
			method: "POST",
			data: objetoAtivo
		})
		.then(function(response) {
			//sucesso
			console.log(response.data);
		}, error => console.log(error));

		/* Exemplo de como fazer um GET */
		/*this.$http({
			url: 'http://localhost:8080/Restful/ativo/listarAtivos',
			method: "GET",
			data: objetoAtivo
		})
		.then(function(response) {
			//sucesso
			console.log(response.data);
		}, error => console.log(error));*/
    }
}

export default HomeController;