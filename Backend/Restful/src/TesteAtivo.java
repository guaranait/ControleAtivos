import java.io.Console;
import java.util.Date;

import java.util.Scanner;
import br.com.restful.dao.AtivoDAO;
import br.com.restful.model.Ativo;

public class TesteAtivo {
	static AtivoDAO ativoDAO = new AtivoDAO();

	public static void main(String args[]) {
		menu();
	}
	
	public static void menu(){
		int opcao = 0;
		do {
			System.out.println("\n\n### Teste Controle de Ativos - KOBE ###");
			System.out.println("\n                   ============================");
			System.out.println("                  |     1 - Cadastrar          |");
			System.out.println("                  |     2 - Alterar            |");
			System.out.println("                  |     3 - Excluir            |");
			System.out.println("                  |     4 - Listar Todos       |");
			System.out.println("                  |     5 - Listar Único       |");
			System.out.println("                  |     0 - Sair               |");
			System.out.println("                   ============================\n");
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Opção -> ");
			opcao = scan.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				cadastrar();
				break;
			case 2:
				alterar();
				break;
			case 3:
				excluir();
			case 4:
				listarTodos();
			case 5:
				//listarUnico();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
	}
	
	public static void cadastrar(){
		// Cria um contato e salva no banco
		Ativo ativo = new Ativo();
		ativo.setDescricao("MacBook Pro");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Apple");
		ativo.setVlDepreciado(800.0);
		ativo.setVlCompra(7000.0);
		ativo.setIdStatus(1);
		ativo.setId(1);
		ativo.setCriadoPor(0);
		ativo.setDtCriacao(new Date());

		ativoDAO.cadastrarAtivo(ativo);
	}
	
	public static void alterar(){
		// Atualiza o contato com id = 1 com os dados do objeto contato1
		Ativo ativo = new Ativo();
		ativo.setDescricao("MacBook Pro alteracao");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Apple alteracao");
		ativo.setVlDepreciado(200.0);
		ativo.setVlCompra(10000.0);
		ativo.setIdStatus(1);
		ativo.setId(1);
		ativo.setModificadoPor(0);
		ativo.setDtModificacao(new Date());

		ativoDAO.alterarAtivo(ativo);
	}
	
	public static void excluir(){
		// Remove o contato com id = 1
		ativoDAO.excluirAtivo(1);
	}
	
	public static void listarTodos(){
		// Lista todos os contatos do banco de dados
		for (Ativo a : ativoDAO.listarAtivos()) {
			System.out.println(a.toString());
		}
	}
}
