routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
    $stateProvider
        .state('listarUsuarios', {
            url: '/usuarios',
            template: require('./usuarios.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        })
        .state('adicionarUsuario', {
            url: '/adicionar-usuario',
            template: require('./add.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        })
        .state('editarUsuario', {
            url: '/editar-usuario',
            params: {
                id: null,
                idPerfil: null,
                username: null,
                senha: null,
                criadoPor: null,
                modificadoPor: null,
                dtCriacao: null,
                dtModificacao: null
            },
            template: require('./edit.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        });
}
