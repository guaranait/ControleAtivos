class EmprestimoController {
	constructor(EmprestimoService, $state, HomeService, FuncionariosService) {
		this.EmprestimoService = EmprestimoService;
		this.emprestimos = [];
        this.$state = $state;
        this.HomeService = HomeService;
        this.FuncionariosService = FuncionariosService;
        this.ativos;
        this.funcionarios;
        this.dtEmprestimo;
        this.funcionarioSelecionado;
        this.ativoSelecionado;
        this.objetoModal;
        this.getEmprestimos();
        this.getAtivos();
        this.getFuncionarios();
	}

    getAtivos() {
        this.HomeService.getAtivos().then( response => { 
            if(response.status == 200){
                this.ativos = response.data 
            }
        }).catch( error => console.log(error) );
    }

    getFuncionarios() {
        this.FuncionariosService.getFuncionarios().then( response => { 
            if(response.status == 200){
                this.funcionarios = response.data 
            }
        }).catch( error => console.log(error) );
    }

	getEmprestimos() {
    	this.EmprestimoService.getEmprestimos().then( response => { 
            if(response.status == 200) {
                this.emprestimos = response.data 
            }
    	}).catch( error => console.log(error) );
    }

    vincular() {
        this.selectAtivo;
        this.selectFuncionario;
        
        let objetoEmprestimo = {
            funcionario: this.funcionarioSelecionado,
            ativo: this.ativoSelecionado,
            dtEmprestimo: moment(this.dtEmprestimo).format("YYYY-MM-DD HH:mm:ss"),
            //Não esta aceitando data nula
            dtDevolucao: moment().format("YYYY-MM-DD HH:mm:ss"),//moment().format("YYYY-MM-DD HH:mm:ss"),
            criadoPor: 1,
            modificadoPor: 1,
            dtCriacao: moment().format("YYYY-MM-DD HH:mm:ss"),
            dtModificacao: moment().format("YYYY-MM-DD HH:mm:ss")
        };

        this.EmprestimoService.cadastrarEmprestimo(objetoEmprestimo).then( response => { 
            if(response.status == 200) {
                this.$state.go('emprestimo');
            }
        }).catch( error => console.log(error) );
    }
    
    desvincular() {
    	let objDevolucao = angular.copy(this.objetoModal);
    	objDevolucao.dtDevolucao = moment().format("YYYY-MM-DD HH:mm:ss");
    	this.EmprestimoService.devolverEmprestimo(objDevolucao).then( response => { 
            if(response.status == 200) {
                this.getEmprestimos();
            }
    	}).catch( error => console.log(error) );
    }

    goVincular() {
        this.$state.go('adicionar-vinculo');
    }

    cancelar() {
        this.$state.go('emprestimo');
    }

    viewRemove(obj) {
        this.objetoModal = angular.copy(obj);
    }

}

EmprestimoController.$inject = ['EmprestimoService', '$state', 'HomeService', 'FuncionariosService'];
export default EmprestimoController;