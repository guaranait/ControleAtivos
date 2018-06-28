import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './emprestimo.routes';
import EmprestimoController from './emprestimo.controller';
import EmprestimoService from './emprestimo.service';

export default angular.module('app.emprestimo', [uirouter])
  .config(routing)
  .controller('EmprestimoController', EmprestimoController)
  .service('EmprestimoService', EmprestimoService)
  .name;