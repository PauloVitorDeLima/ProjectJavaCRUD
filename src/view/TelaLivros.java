package view;

import java.util.List;
import java.util.Scanner;

import dao.LivrosDao;
import entidade.Livros;

public class TelaLivros {
	Scanner in = new Scanner(System.in);
	public String menuLivros() {
		return lerDados("Oq deseja realizar?    \n"
				+ "1 - Cadastro de Livros;    \n"
				+ "2 - Atualizar livros;    \n"
				+ "3 - Excluir Livros;    \n"
				+ "4 - Listar Livros;    \n"
				+ "99 - Sair;");
		
		
		
	}
	public void cadastroLivros() {
		Livros livro = new Livros();
		LivrosDao dao = new LivrosDao();
		livro.setNome(lerDados("Informe o nome do Livro: "));
		livro.setAutor(lerDados("Informe o nome do Autor do livro: "));
		livro.setClassificacaoIndicativa(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a idade permitida para leitura: ")));
		livro.setPaginas(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a quantidade de páginas: ")));
		livro.setValor(Float.parseFloat(lerDados("** (FLOAT) ** \n Informe o valor do livro: ")));
		
		dao.InsereLivro(livro);
		System.out.println("Cadastro de Livro efetuado com sucesso!!");
		
		}
	
	public void AtualizarLivros() {
		Livros livro = new Livros();
		LivrosDao dao = new LivrosDao();
		livro.setNome(lerDados("Informe o nome do livro para alterar: "));
		livro.setAutor(lerDados("Informe o novo nome do Autor do livro: "));
		livro.setClassificacaoIndicativa(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a nova idade permitida para leitura: ")));
		livro.setPaginas(Integer.parseInt(lerDados(" ** (INT) ** \n Informe a nova quantidade de páginas: ")));
		livro.setValor(Float.parseFloat(lerDados("** (FLOAT) ** \n Informe o novo valor do livro: ")));
		
		
		dao.AlteraLivro(livro);
		System.out.println("Alteração de livro efetuada com sucesso!!");
		
		
	}
	public void DeletaLivros() {
		Livros livro = new Livros();
		LivrosDao dao = new LivrosDao();
		livro.setNome(lerDados("Informe o nome do livro para deletar: "));
		dao.DeletaLivro(livro);
		
	}
	public void ListaLivros() {
		LivrosDao dao = new LivrosDao();
		
		List<Livros> listLivros = dao.ListLivros();
		for(int i = 0; i >= listLivros.size(); i++) {
		System.out.println("LIVRO " + i + " / " + listLivros.size());
		System.out.println("Nome do Livro: " + listLivros.get(i).getNome());
		System.out.println("Autor do livro: "+ listLivros.get(i).getAutor());
		System.out.println("Idade minima para leitura: "+listLivros.get(i).getClassificacaoIndicativa()+" Anos");
		System.out.println("Quantidade de paginas: "+listLivros.get(i).getPaginas()+" Paginas");
		System.out.println("Valor do livro: "+listLivros.get(i).getValor()+" Reais");
		}
	}
	
	private String lerDados(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		return in.nextLine();
	}
	
	
}
