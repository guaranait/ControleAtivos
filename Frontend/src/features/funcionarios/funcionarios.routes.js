routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
    $stateProvider
        .state('listarFuncionarios', {
            url: '/funcionarios',
            template: require('./funcionarios.html'),
            controller: 'FuncionariosController',
            controllerAs: 'funcionarios'
        })
        .state('adicionarFuncionario', {
            url: '/adicionar-funcionario',
            template: require('./add.html'),
            controller: 'FuncionariosController',
            controllerAs: 'funcionarios'
        })
        .state('editarFuncionario', {
            url: '/editar-funcionario',
            params: {
                id: null,
                nome: null,
                cpf: null,
                cnpj: null,
                cargo: null,
                criadoPor: null,
                modificadoPor: null,
                dtCriacao: null,
                dtModificacao: null
            },
            template: require('./edit.html'),
            controller: 'FuncionariosController',
            controllerAs: 'funcionarios'
        });
}
