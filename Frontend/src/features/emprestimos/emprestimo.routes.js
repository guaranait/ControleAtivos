routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
  $stateProvider
    .state('emprestimo', {
      url: '/emprestimo',
      template: require('./emprestimo.html'),
      controller: 'EmprestimoController',
      controllerAs: 'emprestimo'
    });
}