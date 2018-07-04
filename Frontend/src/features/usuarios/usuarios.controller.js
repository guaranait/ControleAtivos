class UsuariosController {
    constructor(UsuariosService, MessagesService, $state, $stateParams) {
        this.idPerfil;
        this.username;
        this.senha;
        this.UsuariosService = UsuariosService;
        this.MessagesService = MessagesService;
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
            this.objetoEdit.dtCriacao = $stateParams.dtCriacao;
        }
        this.getUsuarios();
        this.perfis = [
            {id: '1', descricao: 'Administrador'},
            {id: '2', descricao: 'Colaborador'}
        ];
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
        objetoUsuario.dtCriacao = moment().format("YYYY-MM-DD HH:mm:ss");
        objetoUsuario.dtModificacao = moment().format("YYYY-MM-DD HH:mm:ss");

        this.UsuariosService.criarUsuario(objetoUsuario).then(response => {
            if (response.status == 200) {
                this.MessagesService.setMessage('Usuário adicionado com sucesso!', 'success');
                this.limparFormulario();
                this.$state.go('listarUsuarios');
            }
        }).catch(error => console.log(error));
    }

    alterarUsuario() {
        this.UsuariosService.alterarUsuario(this.objetoEdit).then(response => {
            if (response.status == 200) {
                this.MessagesService.setMessage('Usuário editado com sucesso!', 'success');
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
                this.MessagesService.setMessage('Usuário removido com sucesso!', 'success');
                this.getUsuarios();
            }
        }).catch(error => console.log(error));
    }

    getUsuarios() {
        this.UsuariosService.getUsuarios().then(response => {
            if(response.status == 200) {
                this.usuarios = response.data
            }
        }).catch(error => console.log(error));
    }

    limparFormulario() {
        this.idPerfil = '';
        this.username = '';
        this.senha = '';
    }

    adicionarUsuario() {
        this.$state.go('adicionarUsuario');
    }

    getperfis() {
        return this.perfis;
    }

    getPerfil(idPerfil) {
        var descricao = 'Perfil ' + idPerfil;
        for (var i in this.perfis) {
            if (this.perfis[i].id == idPerfil) {
                descricao = this.perfis[i].descricao;
                break;
            }
        }
        return descricao;
    }
}

UsuariosController.$inject = ['UsuariosService', 'MessagesService', '$state', '$stateParams'];

export default UsuariosController;
