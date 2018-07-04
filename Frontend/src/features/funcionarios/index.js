import './funcionarios.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './funcionarios.routes';
import FuncionariosController from './funcionarios.controller';
import FuncionariosService from './funcionarios.service';
import MessagesService from './../../public/assets/js/messages.service';

export default angular.module('app.funcionarios', [uirouter])
    .config(routing)
    .controller('FuncionariosController', FuncionariosController)
    .service('FuncionariosService', FuncionariosService)
    .service('MessagesService', MessagesService)
    .name;
