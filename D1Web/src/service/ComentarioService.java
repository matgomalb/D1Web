package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import model.Comentario;
import model.Noticia;

public class ComentarioService {

	ComentarioDAO dao = new ComentarioDAO();
	
	public int criar(Comentario comentario) {
		dao.insert(comentario);
		return comentario.getId();
	}
	
	public void atualizar(Comentario comentario){
		dao.upDate(comentario);
	}
	
	public void excluir(Comentario comentario){
		dao.delete(comentario);
	}
	
	public ArrayList<Comentario> carregar(Noticia noticia){
		return dao.select(noticia);
	}
	
}
