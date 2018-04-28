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
		objetoAtivo.dtCompra = this.dataCompra;
		objetoAtivo.vlCompra = this.valorCompra;
		objetoAtivo.vlDepreciado = this.valorDepreciado;
		
		console.log(objetoAtivo);
		
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