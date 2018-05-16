class UsuariosController {
    constructor(UsuariosService) {
        this.idPerfil;
        this.username;
        this.senha;
        this.UsuariosService = UsuariosService;

        this.objetoModal;

        this.objetoEdit = {};
        this.editarUsuario();
    }

    view(obj) {
        this.objetoModal = obj;
    }

    criarUsuario() {
        let objetoUsuario = {};

        objetoUsuario.idPerfil = this.idPerfil;
        objetoUsuario.username = this.username;
        objetoUsuario.senha = this.senha;
        objetoUsuario.criadoPor = 1010;

        this.UsuariosService.criarUsuario(objetoUsuario).then(response => console.log(response)).catch(error => console.log(error));
    }

    editarUsuario() {
        this.objetoEdit.idPerfil = '1';
        this.objetoEdit.username = 'username123';
        this.objetoEdit.senha = 'senha123';
        this.objetoEdit.criadoPor = 1010;

        console.log(this.objetoEdit);
    }

    getUsuarios() {
        this.UsuariosService.getUsuarios().then(response => console.log(response)).catch(error => console.log(error));
    }
}

UsuariosController.$inject = ['UsuariosService'];

export default UsuariosController;
