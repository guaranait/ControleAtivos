import 'bootstrap/dist/css/bootstrap.css';
import './public/assets/css/demo.css';
import './public/assets/css/paper-dashboard.css';
import './public/assets/css/animate.min.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './app.config';
import home from './features/home';
import dashboard from './features/dashboard';
import usuarios from './features/dashboard';
import angularmask from 'angular-input-masks/br';

angular.module('app', [uirouter, angularmask, home, dashboard, usuarios])
    .config(routing);