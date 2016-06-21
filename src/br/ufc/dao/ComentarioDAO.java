package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;

@Repository
public class ComentarioDAO implements IComentarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void getInserirComentario(Comentario c) {
		manager.persist(c);
	}
	
	public boolean getRemoverComentario(Long id){
		try {
			Comentario rem = manager.find(Comentario.class, id);
			manager.remove(rem);
		} catch (Exception e){
			return false;
		}
		return true;
	}
	
	public void getAlterarComentario(Comentario c){
		manager.merge(c);
	}
	
	public Comentario getRecuperarComentario(Long id){
		Comentario c = manager.find(Comentario.class, id);
		
		return c;
	}

	public List<Comentario> getListarComentario() {
		List<Comentario> comentarios = manager.createQuery(
				"select c from COMENTARIO as c", Comentario.class)
				.getResultList();
		
		return comentarios;
	}
}
