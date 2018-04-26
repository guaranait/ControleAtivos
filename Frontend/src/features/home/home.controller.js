class HomeController {
  constructor() {
    this.descricao;
	this.fabricante;
	this.dataCompra;
	this.valorCompra;
	this.valorDepreciado;

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
		
		/*$http({
			url: '',
			method: "POST",
			data: objetoAtivo
		})
		.then(function(response) {
			//sucesso
		}, error => console.log(error));*/
    }
}

export default HomeController;