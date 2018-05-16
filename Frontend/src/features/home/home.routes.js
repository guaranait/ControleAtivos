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
      params: {
                id: null,
                descricao: null,
                fabricante: null,
                dtCompra: null,
                vlCompra: null,
                vlDepreciado: null,
                idStatus: null,
                criadoPor: null,
                modificadoPor: null,
                dtCriacao: null,
                dtModificacao: null
              },
      template: require('./edit.html'),
      controller: 'HomeController',
      controllerAs: 'home'
    })
    ;
}