class EmprestimoController {
	constructor(EmprestimoService) {
		this.EmprestimoService = EmprestimoService;
		this.emprestimos = [];
		/*let obj = {}
		obj.funcionario = { nome: 'João da Silva' };
		obj.ativo = { id: '1234', descricao: 'Macbook pro 12' };
		obj.dataEmprestimo = '12/06/2018';
		this.emprestimos.push(obj);*/
		//console.log(this.emprestimos);
		this.getEmprestimos();
	}

	getEmprestimos() {
    	this.EmprestimoService.getEmprestimos().then( response => { 
    		this.emprestimos = response.data 
    		//console.log(response);
    	}).catch( error => console.log(error) );
    }

    removerVinculo(obj) {
    	let objDevolucao = {};
    	objDevolucao.dtDevolucao = moment().format("YYYY-MM-DD HH:mm:ss");
    	objDevolucao.ativo = {id: obj.ativo.id};
    	objDevolucao.funcionario = {id: obj.funcionario.id};
    	objDevolucao.modificadoPor = 9999;

    	this.EmprestimoService.devolverEmprestimo(objDevolucao).then( response => { 
    		console.log(response);
    	}).catch( error => console.log(error) );
    }

}

EmprestimoController.$inject = ['EmprestimoService'];
export default EmprestimoController;