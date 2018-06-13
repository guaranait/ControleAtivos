class DashService {
	constructor($http) {
		this.$http = $http;
	}

	getContadorAtivos() {
		return this.$http({
			url: 'http://localhost:8080/Restful/dashboard/contadorAtivos',
			method: "GET"
		})
		.then( response => response ).catch( error => error );
	}
}

DashService.$inject = ['$http'];
export default DashService;