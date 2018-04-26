import './home.css';
import './assets/css/demo.css';
import './assets/css/paper-dashboard.css';
import './assets/css/animate.min.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './home.routes';
import HomeController from './home.controller';

export default angular.module('app.home', [uirouter])
  .config(routing)
  .controller('HomeController', HomeController)
  .name;
