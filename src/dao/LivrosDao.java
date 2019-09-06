package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Livros;
import jdbc.ConnectionFactory;

public class LivrosDao {
	
	private Connection conexao;
	
	public LivrosDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void InsereLivro(Livros livro) {
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
			System.out.println("ERRO DE CADASTRO " + ex);
		}
	}
	
	public List<Livros> ListLivros(){
		List<Livros> livro = new ArrayList<>();
		
		String sql = "SELECT NOME, CLASSIFICACAO, PAGINAS, AUTOR, VALOR FROM LIVROS";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Livros livros = new Livros();
				livros.setNome(rs.getString("NOME"));
				livros.setClassificacaoIndicativa(rs.getInt("CLASSIFICACAO"));
				livros.setPaginas(rs.getInt("PAGINAS"));
				livros.setAutor(rs.getString("AUTOR"));
				livros.setValor(rs.getFloat("VALOR"));
				livro.add(livros);
			}
			stmt.close();
			rs.close();
			conexao.close();
			
		}catch(SQLException ex) {
			System.out.println("ERRO AO LISTAR LIVROS : " + ex);
		}
		
		return livro;
	}
	
	public void DeletaLivro(Livros livro) {
		String sql = "DELETE FROM LIVROS WHERE NOME = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, livro.getNome());
			
			stmt.execute();
			stmt.close();
			conexao.close();
			
		}catch(Exception ex){
			System.out.println("ERRO AO DELETAR LIVRO : "+ ex);
		}
	}
	
	public void AlteraLivro(Livros livro) {
		String sql = "UPDATE LIVROS SET CLASSIFICACAO = ?, PAGINAS = ?, AUTOR = ?, VALOR = ? "
				+ "WHERE NOME = ? ";
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, livro.getClassificacaoIndicativa());
			stmt.setInt(2, livro.getPaginas());
			stmt.setString(3, livro.getAutor());
			stmt.setFloat(4, livro.getValor());
			
			stmt.execute();
			stmt.close();
			conexao.close();	
			
		}catch(Exception ex) {
			System.out.println("ERRO AO ATUALIZAR LIVROS " + ex);
		}
		
	}
}
