class GarantiaController {
    constructor(GarantiaService, $state, $stateParams) {
        this.id_ativo;
        this.fornecedor;
        this.contato;
        this.criado_por = 1122;
        this.data_criacao = moment().format('DD/MM/YYYY');
        this.garantias = [{ativo: 'Macbook Pro', fornecedor: 'iPlace', contato: '3242-3454'}];
        this.GarantiaService = GarantiaService;
        this.$state = $state;
        this.getGarantias();
    }

    getGarantias() {
        this.GarantiaService.getGarantias().then(response => console.log(response.data)).catch(error => console.log(error));
    }

    adicionarGarantia() {
        let objetoGarantia = {}
        this.GarantiaService.adicionarGarantia(objetoGarantia).then(response => console.log(response.data)).catch(error => console.log(error));
    }

    goAdicionarGarantia() {
        this.$state.go('adicionar-garantia');
    }

    goGarantias() {
        this.$state.go('garantia');
    }
}

GarantiaController.$inject = ['GarantiaService', '$state', '$stateParams'];

export default GarantiaController;
