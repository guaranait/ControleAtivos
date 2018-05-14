routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
  $stateProvider
    .state('home', {
      url: '/',
      template: require('./home.html'),
      controller: 'HomeController',
      controllerAs: 'home'
    })
    .state('ativos', {
      url: '/ativos',
      template: require('./ativos.html'),
      controller: 'HomeController',
      controllerAs: 'home'
    })
    .state('edit', {
      url: '/editar-ativo',
      template: require('./edit.html'),
      controller: 'HomeController',
      controllerAs: 'home'
    })
    ;
}