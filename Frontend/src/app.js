import 'bootstrap/dist/css/bootstrap.css';
import './public/assets/css/demo.css';
import './public/assets/css/paper-dashboard.css';
import './public/assets/css/animate.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './app.config';
import home from './features/home';
import dashboard from './features/dashboard';
import usuarios from './features/usuarios';
import funcionarios from './features/funcionarios';
import garantia from './features/garantia';
import angularmask from 'angular-input-masks/br';
import angularChartist from 'angular-chartist.js';
import angularBrFilters from 'angular-br-filters';

angular.module('app', [uirouter, angularChartist, angularmask, angularBrFilters, home, dashboard, usuarios, funcionarios, garantia])
    .config(routing);
