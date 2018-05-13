class UsuariosController {
    constructor(UsuariosService) {
        this.idPerfil;
        this.username;
        this.senha;
        this.UsuariosService = UsuariosService;
    }

    criarUsuario() {
        var objetoUsuario = {};

        objetoUsuario.idPerfil = this.idPerfil;
        objetoUsuario.username = this.username;
        objetoUsuario.senha = this.senha;
        objetoUsuario.criadoPor = 1010;

        this.UsuariosService.criarUsuario(objetoUsuario).then(response => console.log(response)).catch(error => console.log(error));
    }

    getUsuarios() {
        this.UsuariosService.getUsuarios().then(response => console.log(response)).catch(error => console.log(error));
    }
}

UsuariosController.$inject = ['UsuariosService'];

export default UsuariosController;
