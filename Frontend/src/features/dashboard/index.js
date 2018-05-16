import './dashboard.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './dashboard.routes';
import DashController from './dashboard.controller';

export default angular.module('app.dashboard', [uirouter])
  .config(routing)
  .controller('DashController', DashController)
  .name;
