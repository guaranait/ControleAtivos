class GarantiaController {
    constructor(GarantiaService, $state, $stateParams, HomeService) {
        this.id_ativo;
        this.fornecedor;
        this.contato;
        this.criado_por = 1122;
        this.garantias = [{ativo: {descricao: 'Macbook Pro', id: '12'}, fornecedor: 'iPlace', contato: '3242-3454', dtValidade :'2018-06-30 15:46:22'}];
        this.GarantiaService = GarantiaService;
        this.dtValidade;
        this.$state = $state;
        //this.getGarantias();
        this.HomeService = HomeService;

        if($stateParams.ativo) {
            //$stateParams.dtValidade = new Date ($stateParams.dtValidade);
            this.objetoEdit = { ativo: { id: $stateParams.ativo.id }, fornecedor: $stateParams.fornecedor, contato: $stateParams.contato};
            this.objetoEdit.dtValidade = new Date ($stateParams.dtValidade);
        }
        
        //this.getAtivos();
        //this.ativos = [];
    }

    getAtivos() {
        this.HomeService.getAtivos().then( response => { 
            this.ativos = response.data 
            //console.log(this.ativos);
        }).catch( error => console.log(error) );
    }

    getGarantias() {
        this.GarantiaService.getGarantias().then(response => { 
            //this.garantias = response.data;
            //this.garantias[0].dtCriacao = moment().format('DD/MM/YYYY');
            console.log(response.data);
        }).catch(error => console.log(error));
    }

    cadastrarGarantia() {
        let objetoGarantia = {}

        objetoGarantia.ativo = {id: this.id_ativo};

        objetoGarantia.ativo.dtCompra = moment(this.dataCompra).format("YYYY-MM-DD HH:mm:ss");
        objetoGarantia.dtValidade = moment(this.dtValidade).format("YYYY-MM-DD HH:mm:ss");
        objetoGarantia.fornecedor = this.fornecedor;
        objetoGarantia.contato = this.contato;
        objetoGarantia.criadoPor = 1111;
        objetoGarantia.modificadoPor = 1111;
        //objetoGarantia.dtCriacao = moment(this.dtValidade).format("YYYY-MM-DD HH:mm:ss");
        //objetoGarantia.dtModificacao = moment(this.dtValidade).format("YYYY-MM-DD HH:mm:ss");;

        console.log(objetoGarantia);
        
        this.GarantiaService.cadastrarGarantia(objetoGarantia).then(response => {
            if(response.status == 200) {
                this.goGarantias();
            }
        }).catch(error => console.log(error));
    }

    alterarGarantia() {
        let objetoGarantia = angular.copy(this.objetoEdit);
        objetoGarantia.dtValidade = moment(this.objetoEdit.dtValidade).format("YYYY-MM-DD HH:mm:ss");
        console.log(objetoGarantia);
        this.GarantiaService.alterarGarantia(obj).then(response => console.log(response.data)).catch(error => console.log(error));
    }

    excluirGarantia(obj) {
        let objetoGarantia = obj;
        this.GarantiaService.excluirGarantia(obj).then(response => console.log(response.data)).catch(error => console.log(error));
    }

    goEditar(obj) {
        this.$state.go('editar-garantia', obj);
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
