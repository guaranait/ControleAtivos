routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
  $stateProvider
    .state('emprestimo', {
      url: '/emprestimo',
      template: require('./emprestimo.html'),
      controller: 'EmprestimoController',
      controllerAs: 'emprestimo'
    })
    .state('adicionar-vinculo', {
      url: '/adicionar-vinculo',
      template: require('./adicionar-vinculo.html'),
      controller: 'EmprestimoController',
      controllerAs: 'emprestimo'
    });
}