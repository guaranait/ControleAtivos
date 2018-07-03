class GarantiaController {
    constructor(GarantiaService, $state, $stateParams, HomeService) {
        this.id_ativo;
        this.fornecedor;
        this.contato;
        this.criado_por = 1122;
        this.garantias; //= [{ativo: {descricao: 'Macbook Pro', id: '12'}, fornecedor: 'iPlace', contato: '3242-3454', dtValidade :'2018-06-30 15:46:22'}];
        this.GarantiaService = GarantiaService;
        this.dtValidade;
        this.$state = $state;
        this.getGarantias();
        this.HomeService = HomeService;
        this.objetoModal;
        this.ativoSelecionado;
        if($stateParams.ativo) {
            this.objetoEdit = { id: $stateParams.id, ativo: { id: $stateParams.ativo.id }, fornecedor: $stateParams.fornecedor, contato: $stateParams.contato};
            this.objetoEdit.dtValidade = new Date ($stateParams.dtValidade);
        }
        this.getAtivos();
        this.ativos = [];
    }

    getAtivos() {
        this.HomeService.getAtivos().then( response => { 
            if(response.status == 200){
                this.ativos = response.data 
            }
        }).catch( error => console.log(error) );
    }

    getGarantias() {
        this.GarantiaService.getGarantias().then(response => { 
            if(response.status == 200){
                this.garantias = response.data;
            }
        }).catch(error => console.log(error));
    }

    cadastrarGarantia() {
        let objetoGarantia = {
            ativo: this.ativoSelecionado,
            dtValidade: moment(this.dtValidade).format("YYYY-MM-DD HH:mm:ss"),
            fornecedor: this.fornecedor,
            contato: this.contato,
            criadoPor: 1111,
            modificadoPor: 1111
        }

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
        this.GarantiaService.alterarGarantia(objetoGarantia).then(response => {
            if(response.status == 200){
                console.log(response);
                this.goGarantias();
            }
        }).catch(error => console.log(error));
    }

    viewRemove(obj) {
        this.objetoModal = obj;
    }

    excluirGarantia(obj) {
        let objetoGarantia = obj;
        this.GarantiaService.excluirGarantia(obj).then(response => { 
            if(response.status == 200){
                this.getGarantias();
            }
        }).catch(error => console.log(error));
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
