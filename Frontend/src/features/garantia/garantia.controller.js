class GarantiaController {
    constructor(GarantiaService, $state, $stateParams, HomeService) {
        this.id_ativo;
        this.fornecedor;
        this.contato;
        this.criado_por = 1122;
        this.garantias = [{ativo: 'Macbook Pro', fornecedor: 'iPlace', contato: '3242-3454'}];
        this.GarantiaService = GarantiaService;
        this.dataGarantia;
        this.$state = $state;
        this.getGarantias();
        this.HomeService = HomeService;
        this.getAtivos();
        this.ativos = [];
    }

    getAtivos() {
        this.HomeService.getAtivos().then( response => { 
            this.ativos = response.data 
            console.log(this.ativos);
        }).catch( error => console.log(error) );
    }

    getGarantias() {
        this.GarantiaService.getGarantias().then(response => console.log(response.data)).catch(error => console.log(error));
    }

    cadastrarGarantia() {
        let objetoGarantia = {}
        moment(this.dataCompra).format("YYYY-MM-DD HH:mm:ss");

        objetoGarantia.ativo = this.ativos[0];
        objetoGarantia.id_ativo = objetoGarantia.ativo.id;
        objetoGarantia.ativo.dtCompra = moment(this.dataCompra).format("YYYY-MM-DD HH:mm:ss");
        objetoGarantia.ativo.dtCriacao = moment(this.dataCompra).format("YYYY-MM-DD HH:mm:ss");
        objetoGarantia.fornecedor = this.fornecedor;
        objetoGarantia.contato = this.contato;
        objetoGarantia.criadoPor = 1111;
        objetoGarantia.modificadoPor = this.criadoPor;
        objetoGarantia.dtCriacao = moment(this.dataGarantia).format("YYYY-MM-DD HH:mm:ss");
        objetoGarantia.dtModificacao = moment(this.dataGarantia).format("YYYY-MM-DD HH:mm:ss");;

        
        this.GarantiaService.adicionarGarantia(objetoGarantia).then(response => console.log(response.data)).catch(error => console.log(error));
    }

    goAdicionarGarantia() {
        this.$state.go('adicionar-garantia');
    }

    goGarantias() {
        this.$state.go('garantia');
    }
}

GarantiaController.$inject = ['GarantiaService', '$state', '$stateParams', 'HomeService'];

export default GarantiaController;
