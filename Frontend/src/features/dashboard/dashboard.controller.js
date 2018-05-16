class DashController {
	constructor($scope) {
		this.estoque = 5;
		this.emprestado = 3;
		this.manutencao = 4;
		this.desativado = 2;

		this.data = {
		  series: [this.estoque, this.emprestado, this.manutencao, this.desativado]
		};

		this.options = {
          width: '300px',
          height: '300px',
          donut: true,
          donutWidth: 60,
          startAngle: 270,
          showLabel: true,
        };
	}

}

DashController.$inject = ['$scope'];
export default DashController;