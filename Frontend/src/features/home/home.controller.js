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
		this.money;

		this.objetoEdit = {};
		this.editarAtivo();
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

    editarAtivo() {
    	this.objetoEdit.descricao = 'Macbook Pro 16';
		this.objetoEdit.fabricante = 'Apple';
		this.objetoEdit.dtCompra = '14/05/2018';
		this.objetoEdit.vlCompra = 4000;
		this.objetoEdit.vlDepreciado = 0;
		this.objetoEdit.criadoPor = 1122;
		this.objetoEdit.idStatus = 1;
		this.objetoEdit.obs = ' HEUEHUEH EHUEHUEHE EHHEUEHHEHHE EHEHUEHEH ';

		console.log(this.objetoEdit);
    }

    getAtivos() {
    	this.HomeService.getAtivos().then( response => console.log(response) ).catch( error => console.log(error) );
    }
}

HomeController.$inject = ['HomeService'];

export default HomeController;