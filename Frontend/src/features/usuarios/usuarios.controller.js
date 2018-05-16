class UsuariosController {
    constructor(UsuariosService, $state, $stateParams) {
        this.idPerfil;
        this.username;
        this.senha;
        this.UsuariosService = UsuariosService;

        this.usuarios = [];
        this.objetoModal;
        this.$state = $state;
        this.objetoEdit = {};
        if ($stateParams.username) {
            this.objetoEdit.idPerfil = $stateParams.idPerfil;
            this.objetoEdit.username = $stateParams.username;
            this.objetoEdit.senha = $stateParams.senha;
            this.objetoEdit.criadoPor = $stateParams.criadoPor;
            this.objetoEdit.id = $stateParams.id;
        }
        this.getUsuarios();
    }

    view(obj) {
        this.$state.go('editarUsuario', obj);
    }

    viewRemove(obj) {
        this.objetoModal = obj;
    }

    criarUsuario() {
        let objetoUsuario = {};

        objetoUsuario.idPerfil = this.idPerfil;
        objetoUsuario.username = this.username;
        objetoUsuario.senha = this.senha;
        objetoUsuario.criadoPor = 1010;

        this.UsuariosService.criarUsuario(objetoUsuario).then(response => {
            if (response.status == 200) {
                this.limparFormulario();
                this.$state.go('listarUsuarios');
            }
        }).catch(error => console.log(error));
    }

    alterarUsuario() {
        this.UsuariosService.alterarUsuario(this.objetoEdit).then(response => {
            if (response.status == 200) {
                this.$state.go('listarUsuarios');
            }
        }).catch(error => console.log(error) );
    }

    cancelarEdicao() {
        this.$state.go('listarUsuarios');
    }

    excluirUsuario(obj) {
        this.UsuariosService.excluirUsuario(obj).then(response => {
            if (response.status == 200) {
                console.log(response);
            }
        }).catch(error => console.log(error));
    }

    getUsuarios() {
        this.UsuariosService.getUsuarios().then(response => this.usuarios = response.data).catch(error => console.log(error));
    }

    limparFormulario() {
        this.idPerfil = '';
        this.username = '';
        this.senha = '';
    }

    adicionarUsuario() {
        this.$state.go('adicionarUsuario');
    }
}

UsuariosController.$inject = ['UsuariosService', '$state', '$stateParams'];

export default UsuariosController;
