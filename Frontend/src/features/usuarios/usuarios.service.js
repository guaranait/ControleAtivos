class UsuariosService {
    constructor($http) {
        this.$http = $http;
    }

    criarUsuario(objetoUsuario) {
        console.log(objetoUsuario);
        var url = "http://localhost:8080/Restful/usuarios/cadastrarUsuario?username="
            +objetoUsuario.username
            +"&idPerfil="+objetoUsuario.idPerfil
            +"&senha="+objetoUsuario.senha;

        console.log(url);

        return this.$http({
            url: url,
            method: "POST",
            data: objetoUsuario
        })
        .then(response => response).catch(error => error);
    }

    getUsuarios() {
        return this.$http({
            url: 'http://localhost:8080/Restful/usuarios/listarUsuarios',
            method: "GET"
        })
        .then(response => response).catch(error => error);
    }
}

UsuariosService.$inject = ['$http'];

export default UsuariosService;
