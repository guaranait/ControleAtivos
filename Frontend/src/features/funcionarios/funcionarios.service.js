class FuncionariosService {
    constructor($http) {
        this.$http = $http;
    }

    criarFuncionario(objetoFuncionario) {
        console.log(objetoFuncionario);
        var url = "http://localhost:8080/Restful/funcionario/cadastrarFuncionario?nome="
            +objetoFuncionario.nome
            +"&cpf="+objetoFuncionario.cpf
            +"&cnpj="+objetoFuncionario.cnpj
            +"&cargo="+objetoFuncionario.cargo;

        return this.$http({
            url: url,
            method: "POST",
            data: objetoFuncionario
        })
        .then(response => response).catch(error => error);
    }

    getFuncionarios() {
        return this.$http({
            url: 'http://localhost:8080/Restful/funcionario/listarFuncionarios',
            method: "GET"
        })
        .then(response => response).catch(error => error);
    }

    alterarFuncionario(objetoFuncionario) {
        return this.$http({
            url:'http://localhost:8080/Restful/funcionario/alterarFuncionario',
            method: "POST",
            data: objetoFuncionario
        })
        .then(response => response).catch(error => error);
    }

    excluirFuncionario(objetoFuncionario) {
        let obj = {};
        obj.id = objetoFuncionario.id;
        return this.$http({
            url: 'http://localhost:8080/Restful/funcionario/excluirFuncionario',
            method: "POST",
            data: obj
        })
        .then( response => response ).catch( error => error );
    }
}

FuncionariosService.$inject = ['$http'];

export default FuncionariosService;
