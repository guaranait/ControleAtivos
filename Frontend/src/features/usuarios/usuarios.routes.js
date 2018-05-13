routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
    $stateProvider
        .state('usuarios', {
            url: '/',
            template: require('./usuarios.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        })
        .state('teste', {
            url: '/teste',
            template: require('./teste.html'),
            controller: 'UsuariosController',
            controllerAs: 'usuarios'
        });
}
