package view;

import java.util.Scanner;

import entidade.Livros;

public class TelaLivros {
	Scanner in = new Scanner(System.in);
	public String menuLivros() {
		return lerDados("Oq deseja realizar? "
				+ "1 - Cadastro de Livros;"
				+ "2 - Atualizar livros;"
				+ "3 - Excluir Livros;"
				+ "4 - Listar Livros;"
				+ "99 - Sair;");
		
		
		
	}
	public void cadastroLivros() {
		Livros livro = new Livros();
		livro.setNome(lerDados("Informe o nome do Livro: "));
		livro.setAutor(lerDados("Informe o nome do Autor do livro: "));
		livro.setClassificacaoIndicativa(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a idade permitida para leitura: ")));
		livro.setPaginas(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a quantidade de páginas: ")));
		livro.setValor(Float.parseFloat(lerDados("** (FLOAT) ** \n Informe o valor do livro: ")));
		
		/*
		 CADASTRO NO BANCO AQUI!!
		 */
		
		}
	
	public void AtualizarLivros() {
		Livros livro = new Livros();
		livro.setNome(lerDados("Informe o nome do livro para alterar: "));
		livro.setAutor(lerDados("Informe o novo nome do Autor do livro: "));
		livro.setClassificacaoIndicativa(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a nova idade permitida para leitura: ")));
		livro.setPaginas(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a nova quantidade de páginas: ")));
		livro.setValor(Float.parseFloat(lerDados("** (FLOAT) ** \n Informe o novo valor do livro: ")));
		
		/*
		 UPDATE NO BANCO AQUI!!
		 */
		
		
	}
	public void DeletaLivros() {
		Livros livro = new Livros();
		livro.setNome(lerDados("Informe o nome do livro para deletar: "));
		
		/*
		 DELETE NO BANCO AQUI!!
		 */
	}
	public void ListaLivros() {
		/*
		 * Listar do banco aqui!!
		 */
	}
	
	private String lerDados(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		return in.nextLine();
	}
	
	
}
