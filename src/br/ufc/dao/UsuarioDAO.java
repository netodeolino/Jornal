package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void getInserirUsuario(Usuario u){
		manager.persist(u);
	}
	
	public boolean getRemoverUsuario(Long id){
		try {
			Usuario rem = manager.find(Usuario.class, id);
			manager.remove(rem);
			//System.out.println("REMOVIDO FÍ");
		} catch (Exception e){
			//System.out.println("NÃO REMOVEU FÍ");
			return false;
		}
		return true;
	}
	
	public void getAlterarUsuario(Usuario u){
		manager.merge(u);
	}
	
	public Usuario getRecuperarUsuario(Long id){
		Usuario u = manager.find(Usuario.class, id);
		
		return u;
	}
	
	public List<Usuario> getListarUsuarios(){
		List<Usuario> usuarios = manager.
				createQuery("select u from USUARIO as u", Usuario.class).
				getResultList();
		
		return usuarios;
	}
}
