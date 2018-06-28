class EmprestimoController {
	constructor() {
		this.emprestimos = [];
		let obj = {}
		obj.funcionario = { nome: 'João da Silva' };
		obj.ativo = { id: '1234', descricao: 'Macbook pro 12' };
		obj.dataEmprestimo = '12/06/2018';
		this.emprestimos.push(obj);
		console.log(this.emprestimos);
	}

}

EmprestimoController.$inject = [];
export default EmprestimoController;