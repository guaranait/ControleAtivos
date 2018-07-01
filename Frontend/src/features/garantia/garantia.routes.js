routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
  $stateProvider
    .state('garantia', {
      url: '/garantias',
      template: require('./garantia.html'),
      controller: 'GarantiaController',
      controllerAs: 'garantia'
    })
    .state('adicionar-garantia', {
      url: '/adicionar-garantia',
      template: require('./adicionar.html'),
      controller: 'GarantiaController',
      controllerAs: 'garantia'
    })
    .state('editar-garantia', {
      url: '/editar-garantia',
      params: { 
                id: null,
                ativo: null,
                dtValidade: null,
                contato: null,
                fornecedor: null,
              },
      template: require('./editar.html'),
      controller: 'GarantiaController',
      controllerAs: 'garantia'
    })
    ;
}