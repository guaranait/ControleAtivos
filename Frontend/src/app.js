import 'bootstrap/dist/css/bootstrap.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './app.config';
import home from './features/home';
import dashboard from './features/dashboard';

angular.module('app', [uirouter, home, dashboard])
  .config(routing);