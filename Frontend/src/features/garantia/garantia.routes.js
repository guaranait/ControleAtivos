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
    ;
}