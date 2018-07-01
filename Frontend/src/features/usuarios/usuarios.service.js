class UsuariosService {
    constructor($http) {
        this.$http = $http;
    }

    criarUsuario(objetoUsuario) {
        console.log(objetoUsuario);

        return this.$http({
            url: 'http://localhost:8080/Restful/usuario/cadastrarUsuario',
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
            url: 'http://localhost:8080/Restful/usuario/excluirUsuario',
            method: "POST",
            data: objetoUsuario
        })
        .then(response => response).catch(error => error);
    }
}

UsuariosService.$inject = ['$http'];

export default UsuariosService;
