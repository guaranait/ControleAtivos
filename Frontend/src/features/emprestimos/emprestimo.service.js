class EmprestimoService {
	constructor($http) {
		this.$http = $http;
	}

	getEmprestimos() {
		return this.$http({
			url: 'http://localhost:8080/Restful/emprestimo/listarEmprestimos',
			method: "GET"
		})
		.then( response => response ).catch( error => error );
	}
}

EmprestimoService.$inject = ['$http'];
export default EmprestimoService;