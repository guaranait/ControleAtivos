class UsuariosService {
    constructor($http) {
        this.$http = $http;
    }

    criarUsuario(objetoUsuario) {
        console.log(objetoUsuario);
        var url = "http://localhost:8080/Restful/usuario/cadastrarUsuario?username="
            +objetoUsuario.username
            +"&idPerfil="+objetoUsuario.idPerfil
            +"&senha="+objetoUsuario.senha;

        return this.$http({
            url: url,
            method: "POST",
            data: objetoUsuario
        })
        .then(response => response).catch(error => error);
    }

    getUsuarios() {
        return this.$http({
            url: 'http://localhost:8080/Restful/usuario/listarUsuarios',
            method: "GET"
        })
        .then(response => response).catch(error => error);
    }

    alterarUsuario(objetoUsuario) {
        return this.$http({
            url:'http://localhost:8080/Restful/usuario/alterarUsuario',
            method: "POST",
            data: objetoUsuario
        })
        .then(response => response).catch(error => error);
    }

    excluirUsuario(objetoUsuario) {
        return this.$http({
            url: 'http://localhost:8080/Restful/usuario/excluirUsuario?id=' + objetoUsuario.id,
            method: "POST"
        })
        .then(response => response).catch(error => error);
    }
}

UsuariosService.$inject = ['$http'];

export default UsuariosService;
