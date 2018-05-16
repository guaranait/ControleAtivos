class FuncionariosController {
    constructor(FuncionariosService, $state, $stateParams) {
        this.nome;
        this.cpfCnpj;
        this.cargo;
        this.FuncionariosService = FuncionariosService;

        this.funcionarios = [];
        this.objetoModal;
        this.$state = $state;
        this.objetoEdit = {};
        if ($stateParams.nome) {
            this.objetoEdit.nome = $stateParams.nome;
            this.objetoEdit.cpfCnpj = $stateParams.cpfCnpj;
            this.objetoEdit.cargo = $stateParams.cargo;
            this.objetoEdit.criadoPor = $stateParams.criadoPor;
            this.objetoEdit.id = $stateParams.id;
        }
        this.getFuncionarios();
    }

    view(obj) {
        this.$state.go('editarFuncionario', obj);
    }

    viewRemove(obj) {
        this.objetoModal = obj;
    }

    criarFuncionario() {
        let objetoFuncionario = {};

        objetoFuncionario.nome = this.nome;
        objetoFuncionario.cpfCnpj = this.cpfCnpj;
        objetoFuncionario.cargo = this.cargo;
        objetoFuncionario.criadoPor = 1010;

        this.FuncionariosService.criarFuncionario(objetoFuncionario).then(response => {
            if (response.status == 200) {
                this.limparFormulario();
                this.$state.go('listarFuncionarios');
            }
        }).catch(error => console.log(error));
    }

    alterarFuncionario() {
        this.FuncioariosService.alterarFuncionario(this.objetoEdit).then(response => {
            if (response.status == 200) {
                this.$state.go('listarFuncionarios');
            }
        }).catch(error => console.log(error) );
    }

    cancelarEdicao() {
        this.$state.go('listarFuncionarios');
    }

    excluirFuncionario(obj) {
        this.FuncionariosService.excluirFuncionario(obj).then(response => {
            if (response.status == 200) {
                console.log(response);
            }
        }).catch(error => console.log(error));
    }

    getFuncionarios() {
        this.FuncionariosService.getFuncionarios().then(response => this.funcionarios = response.data).catch(error => console.log(error));
    }

    limparFormulario() {
        this.nome = '';
        this.cpfCnpj = '';
        this.cargo = '';
    }

    adicionarFuncionario() {
        this.$state.go('adicionarFuncionario');
    }
}

FuncionariosController.$inject = ['FuncionariosService', '$state', '$stateParams'];

export default FuncionariosController;
