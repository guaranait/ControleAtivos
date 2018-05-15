routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
    $stateProvider
        .state('usuarios', {
            url: '/usuarios',
            template: require('./usuarios.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        })
        .state('add', {
            url: '/adicionar-usuario',
            template: require('./add.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        });
        .state('edit', {
            url: '/editar-usuario',
            template: require('./edit.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        });
}
