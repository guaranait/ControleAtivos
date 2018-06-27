class HomeController {
	constructor(HomeService, $state, $stateParams) {
		this.descricao;
		this.fabricante;
		this.dataCompra;
		this.valorCompra;
		this.valorDepreciado = 0;
		this.observacao = " ";
		this.HomeService = HomeService;
		//this.ativos = [{id: 2, idStatus: 1, descricao: 'Macbook Pro 13', fabricante: 'Apple', vlCompra: 3000, vlDepreciado: 300}];
		this.ativos = [];
		this.objetoModal;
		this.money;
		this.$state = $state;
		this.objetoEdit = {};
		if($stateParams.descricao) {
			this.objetoEdit.descricao = $stateParams.descricao;
			this.objetoEdit.fabricante = $stateParams.fabricante;
			//Alterar no Backend
			this.objetoEdit.dtCompra = moment($stateParams.dtCompra).format('DD/MM/YYYY');
			this.objetoEdit.vlCompra = $stateParams.vlCompra;
			this.objetoEdit.vlDepreciado = $stateParams.vlDepreciado;
			this.objetoEdit.criadoPor = $stateParams.criadoPor;
			this.objetoEdit.idStatus = $stateParams.idStatus;
			this.objetoEdit.obs = $stateParams.obs;
			this.objetoEdit.id = $stateParams.id;
			/* OBSERVAÇÃO */
			this.objetoEdit.obs = $stateParams.observacao;
		}
		this.getAtivos();
	}

	view(obj) {
		this.$state.go('edit', obj);
	}

	viewRemove(obj) {
		this.objetoModal = obj;
	}

	viewManutencao(obj) {
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
		objetoAtivo.observacao = this.observacao;

		this.HomeService.criarAtivo(objetoAtivo).then( response => {
			if(response.status == 200) {
				this.limparFormulario();
				this.$state.go('ativos');
			}
		} ).catch( error => console.log(error) );
    }

    alterarAtivo() {
    	/* SALVAR OBSERVAÇÃO */
    	this.objetoEdit.dtCompra = moment(this.objetoEdit.dtCompra).format("YYYY-MM-DD HH:mm:ss");
    	this.HomeService.alterarAtivo(this.objetoEdit).then( response => {
			if(response.status == 200) {
				this.$state.go('ativos');
			}
		} ).catch( error => console.log(error) );
    }

    cancelarEdicao() {
    	this.$state.go('ativos');
    }

    cancelarCriacao() {
    	this.$state.go('ativos');
    }

    excluirAtivo(obj) {
    	this.HomeService.excluirAtivo(obj).then( response => {
			if(response.status == 200) {
				this.getAtivos();
			}
		} ).catch( error => console.log(error) );
    }

    getAtivos() {
    	this.HomeService.getAtivos().then( response => { 
    		this.ativos = response.data 
    		console.log(response.data);
    	}).catch( error => console.log(error) );
    }

    limparFormulario() {
    	this.descricao = '';
		this.fabricante = '';
		this.dataCompra = '';
		this.valorCompra = '';
		this.valorDepreciado = '';
		this.observacao = '';
    }

    adicionarAtivo() {
		this.$state.go('home');
	}

	cadastrarManutencao() {
		let obj = {};
		obj.ativo = this.objetoModal;
		obj.ativo.dtCompra = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.ativo.dtCriacao = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.ativo.dtModificacao = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.descricao = this.objetoModal.descricao;
		obj.dtConserto = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.criadoPor = 1111;
		obj.modificadoPor = 1111;
		obj.dtCriacao = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.dtModificacao = moment().format("DD-MM-YYYY HH:mm:ss");

		this.HomeService.cadastrarManutencao(obj).then( response => {
			if(response.status == 200) {
				this.getAtivos();
			}
		}).catch( error => console.log(error) );
	}

	concluirManutencao() {
		let obj = {};
		obj.ativo = this.objetoModal;
		obj.ativo.dtCompra = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.ativo.dtCriacao = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.ativo.dtModificacao = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.descricao = this.objetoModal.descricao;
		obj.dtConserto = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.criadoPor = 1111;
		obj.modificadoPor = 1111;
		obj.dtCriacao = moment().format("DD-MM-YYYY HH:mm:ss");
		obj.dtModificacao = moment().format("DD-MM-YYYY HH:mm:ss");

		this.HomeService.concluirManutencao(obj).then( response => {
			if(response.status == 200) {
				this.getAtivos();
			}
		}).catch( error => console.log(error) );
	}

	dicionarioManutencao(idStatus) {
		if (idStatus == 1) {
			return "Não"
		} else if (idStatus == 2) {
			return "Sim"
		} else {
			return idStatus
		}
	}
}

HomeController.$inject = ['HomeService', '$state', '$stateParams'];

export default HomeController;