package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class LoginDAO implements ILoginDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public Usuario getBuscarPorLogin(Usuario usu){
		String hql = "select u from USUARIO u where u.login='" + usu.getLogin() + "'";
		List<?> resultado = manager.createQuery(hql).getResultList();
		if(!resultado.isEmpty()){
			return manager.createQuery(hql, Usuario.class).getResultList().get(0);
		}
		return null;
	}
}
