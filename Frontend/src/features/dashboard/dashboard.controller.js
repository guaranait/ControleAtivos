class DashController {
	constructor($scope, DashService) {
        this.DashService = DashService;
        this.getContadorAtivos();
        this.getContadorGarantias();
	}

	getContadorGarantias() {
		this.DashService.getContadorGarantias().then( response => {
			if(response.status == 200) {
				if(response.data[0].aVencer) {
					this.aVencer = response.data[0].aVencer;
				} else {
					this.aVencer = 0;
				}
				if(response.data[0].venceMes) {
					this.venceMes = response.data[0].venceMes;
				} else {
					this.venceMes = 0;
				}
				if(response.data[0].vencida) {
					this.vencida = response.data[0].vencida;
				} else {
					this.vencida = 0;
				}
				this.dataGarantias = {
				  series: [this.aVencer, this.venceMes, this.vencida]
				};
				this.optionsGarantias = {
		          width: '300px',
		          height: '300px',
		          donut: true,
		          donutWidth: 60,
		          startAngle: 270,
		          showLabel: true,
	        	};
			}
		} ).catch( error => console.log(error) );
	}

	getContadorAtivos() {
		this.DashService.getContadorAtivos().then( response => {
			if(response.status == 200) {
				if(response.data[0].disponivel) {
					this.estoque = response.data[0].disponivel;
				} else {
					this.estoque = 0;
				}
				if(response.data[0].emprestado) {
					this.emprestado = response.data[0].emprestado;
				} else {
					this.emprestado = 0;
				}
				if(response.data[0].manutencao) {
					this.manutencao = response.data[0].manutencao;
				} else {
					this.manutencao = 0;
				}
				this.dataAtivos = {
				  series: [this.estoque, this.emprestado, this.manutencao]
				};
				this.optionsAtivos = {
		          width: '300px',
		          height: '300px',
		          donut: true,
		          donutWidth: 60,
		          startAngle: 270,
		          showLabel: true,
		        };
			}
		} ).catch( error => console.log(error) );
	}

}

DashController.$inject = ['$scope', 'DashService'];
export default DashController;