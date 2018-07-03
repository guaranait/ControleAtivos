class HomeController {
	constructor(HomeService, $state, $stateParams) {
		this.descricao;
		this.fabricante;
		this.dataCompra;
		this.valorCompra;
		this.valorDepreciado = 0.0;
		this.observacao = " ";
		this.HomeService = HomeService;
		this.ativos = [];
		this.objetoModal;
		this.money;
		this.$state = $state;
		this.objetoEdit = {};
		if($stateParams.descricao) {
			this.objetoEdit.descricao = $stateParams.descricao;
			this.objetoEdit.fabricante = $stateParams.fabricante;
			this.objetoEdit.dtCompra = moment($stateParams.dtCompra).format('DD/MM/YYYY');
			this.objetoEdit.vlCompra = $stateParams.vlCompra;
			this.objetoEdit.vlDepreciado = $stateParams.vlDepreciado;
			this.objetoEdit.criadoPor = $stateParams.criadoPor;
			this.objetoEdit.idStatus = $stateParams.idStatus;
			this.objetoEdit.obs = $stateParams.obs;
			this.objetoEdit.id = $stateParams.id;
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
		let objetoAtivo = {
			descricao: this.descricao,
			fabricante: this.fabricante,
			dtCompra: moment(this.dataCompra).format("YYYY-MM-DD HH:mm:ss"),
			vlCompra: this.valorCompra,
			vlDepreciado: this.valorDepreciado,
			criadoPor: 1122,
			idStatus: 1,
			observacao: this.observacao
		};
		if(!this.valorDepreciado) {
			objetoAtivo.vlDepreciado = 0.01
		} 
		this.HomeService.criarAtivo(objetoAtivo).then( response => {
			if(response.status == 200) {
				this.limparFormulario();
				this.$state.go('ativos');
			}
		} ).catch( error => console.log(error) );
    }

    alterarAtivo() {
    	this.objetoEdit.dtCompra = moment(this.objetoEdit.dtCompra).format("YYYY-MM-DD HH:mm:ss");
    	if(!this.objetoEdit.vlDepreciado) {
			this.objetoEdit.vlDepreciado = 0.01
		} 
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