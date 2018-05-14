import moment from 'moment';

class HomeController {
	constructor(HomeService) {
		this.descricao;
		this.fabricante;
		this.dataCompra;
		this.valorCompra;
		this.valorDepreciado;
		this.HomeService = HomeService;
		this.ativos = [];
		this.ativos.push({descricao: 'Macbook', fabricante: 'Apple', valorCompra: 4000, valorDepreciado: 0, criadoPor: 1212, idStatus: 1});
		this.ativos.push({descricao: 'Macbook 2', fabricante: 'Apple', valorCompra: 4000, valorDepreciado: 0, criadoPor: 1212, idStatus: 1});
		this.ativos.push({descricao: 'Macbook 3', fabricante: 'Apple', valorCompra: 4000, valorDepreciado: 0, criadoPor: 1212, idStatus: 1});
		this.ativos.push({descricao: 'Macbook 4', fabricante: 'Apple', valorCompra: 4000, valorDepreciado: 0, criadoPor: 1212, idStatus: 1});
		this.objetoModal;
		//this.getAtivos();
	}

	view(obj) {
		this.objetoModal = obj;
	}

	criarAtivo() {
		let objetoAtivo = {};

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