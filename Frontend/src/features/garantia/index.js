import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './garantia.routes';
import GarantiaController from './garantia.controller';
import GarantiaService from './garantia.service';

export default angular.module('app.garantia', [uirouter])
  .config(routing)
  .controller('GarantiaController', GarantiaController)
  .service('GarantiaService', GarantiaService)
  .name;