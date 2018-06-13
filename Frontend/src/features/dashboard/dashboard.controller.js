class DashController {
	constructor($scope, $http) {
		this.estoque = 0;
		this.emprestado = 0;
		this.manutencao = 0;
		this.desativado = 0;

		
        this.$http = $http;
        //this.DashService = DashService;
        this.getContadorAtivos();
	}

	getContadorAtivos() {
		return this.$http({
			url: 'http://localhost:8080/Restful/dashboard/contadorAtivos',
			method: "GET"
		})
		.then( response => {
			console.log(response.data);

			if(response.data[0].DISPONIVEL) {
				this.estoque = response.data[0].DISPONIVEL;
			} else {
				this.estoque = 0;
			}

			if(response.data[0].EMPRESTADO) {
				this.response.data[0].EMPRESTADO;
			} else {
				this.emprestado = 0;
			}

			if(response.data[0].MANUTENCAO) {
				this.manutencao = response.data[0].MANUTENCAO;
			} else {
				this.manutencao = 0;
			}


			this.data = {
			  series: [this.estoque, this.emprestado, this.manutencao]
			};

			this.options = {
	          width: '300px',
	          height: '300px',
	          donut: true,
	          donutWidth: 60,
	          startAngle: 270,
	          showLabel: true,
	        };

		}).catch( error => error );
	}

}

DashController.$inject = ['$scope', '$http'];
export default DashController;