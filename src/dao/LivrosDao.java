package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidade.Livros;
import jdbc.ConnectionFactory;

public class LivrosDao {
	
	private Connection conexao;
	
	public LivrosDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	
	public void insert(Livros livro) {
		String sql = "INSERT INTO LIVROS( NOME, CLASSIFICACAO, PAGINAS, AUTOR, VALOR) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt =conexao.prepareStatement(sql);
			stmt.setString(1, livro.getNome());
			stmt.setInt(2, livro.getClassificacaoIndicativa());
			stmt.setInt(3, livro.getPaginas());
			stmt.setString(4, livro.getAutor());
			stmt.setFloat(5, livro.getValor());
			
			stmt.execute();
			
			stmt.close();
			conexao.close();
			
		}catch(Exception ex){
			System.out.println("ERRO DE CADASTRO "+ex);
		}
		
		
	}
}
