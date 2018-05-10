import moment from 'moment';

class HomeController {
	constructor(HomeService) {
		this.descricao;
		this.fabricante;
		this.dataCompra;
		this.valorCompra;
		this.valorDepreciado;
		this.HomeService = HomeService;
	}

	criarAtivo() {
		var objetoAtivo = {};

		objetoAtivo.descricao = this.descricao;
		objetoAtivo.fabricante = this.fabricante;
		objetoAtivo.dtCompra = moment(this.dataCompra).format("YYYY-MM-DD HH:mm:ss");
		objetoAtivo.vlCompra = this.valorCompra;
		objetoAtivo.vlDepreciado = this.valorDepreciado;
		objetoAtivo.criadoPor = 1122;
		objetoAtivo.idStatus = 1;

		//Fazer o POST
		this.HomeService.criarAtivo(objetoAtivo).then( response => console.log(response) ).catch( error => console.log(error) );
		
		//Testar o GET
		//this.getAtivos();
    }

    getAtivos() {
    	this.HomeService.getAtivos().then( response => console.log(response) ).catch( error => console.log(error) );
    }
}

HomeController.$inject = ['HomeService'];

export default HomeController;