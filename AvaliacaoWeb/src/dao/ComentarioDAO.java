package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Comentario;

public class ComentarioDAO {

private Connection conexao;
	
	public ComentarioDAO () {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void insert (Comentario comentario) {
		System.out.println("Entrou no insert");
		ComentarioDAO dao = new ComentarioDAO();
		String inserir = "INSERT INTO Comentario (id, nome, texto,fk_noticia_id)" + "VALUES(?,?,?,?)";
		
		Comentario not = new Comentario(); 
		
		try (PreparedStatement pst = conexao.prepareStatement(inserir)){
			pst.setInt(1, comentario.getId());
			pst.setString(2, comentario.getNome());
			pst.setString(3, comentario.getTexto());
			pst.setInt(4, comentario.getNoticiaId());
			
			not.setId(comentario.getId());
			not.setNome(comentario.getNome());
			not.setTexto(comentario.getTexto());
			
			pst.execute();
			
			String sqlQuery ="SELECT LAST_INSERT_ID()";
				try(PreparedStatement pst2 = conexao.prepareStatement(sqlQuery);ResultSet rs = pst2.executeQuery();){
					if(rs.next()) {
						comentario.setId(rs.getInt(1));
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
						
			System.out.println("Insert feito com sucesso");
			
		} catch(SQLException ex){ 
			System.out.println("Houve um erro ao inserir");
			ex.printStackTrace();
		}
	}
	
	public void delete (Comentario comentario) {
			
		String delete = "DELETE FROM Usuario WHERE apelido = ?";
			
		try (PreparedStatement pst = conexao.prepareStatement(delete)){
			pst.setInt(1, comentario.getId());
			pst.execute();
			
			System.out.println("Noticia excluida");
			
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Falha ao excluir a Noticia");
		}
	}
	
	public void upDate (Comentario comentario) {		
		String update = "UPDATE Comentario SET senha = ? WHERE apelido = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(update)){
			pst.setInt(1, comentario.getId());
			pst.setString(2, comentario.getNome());
			pst.setString(3, comentario.getTexto());
			pst.execute();
				
			System.out.println("Atualizado com sucesso!");
		} catch(SQLException ex){
			System.out.println("Erro ao atualizar");
			ex.printStackTrace();
		}
	}
	
	public Comentario select (Comentario comentario) {
		Comentario not = null;
		String consulta = "SELECT id, nome, texto FROM Comentario WHERE fk_noticia_id = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(consulta)){
			pst.setInt(1, comentario.getNoticiaId());
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
				not = new Comentario();
				
				int idNoticia = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String texto = resultado.getString("texto");
				
				not.setId(idNoticia);
				not.setNome(nome);
				not.setTexto(texto);
				System.out.println("Comentario: " + not.toString());
			}
			System.out.println("Consulta feita com sucesso");
			
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println("Falha na consulta");
		}
		return not;
	}
}
