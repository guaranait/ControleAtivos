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
            template: require('./edit.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        });
}
