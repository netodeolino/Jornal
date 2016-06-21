package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO implements IClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void getInserirClassificado(Classificado c){
		manager.persist(c);
	}
	
	public boolean getRemoverClassificado(Long id){
		try {
			Classificado rem = manager.find(Classificado.class, id);
			manager.remove(rem);
			//System.out.println("REMOVIDO FÍ");
		} catch (Exception e){
			//System.out.println("NÃO REMOVEU FÍ");
			return false;
		}
		return true;
	}
	
	public void getAlterarClassificado(Classificado c){
		manager.merge(c);
	}
	
	public Classificado getRecuperarClassificado(Long id){
		Classificado c = manager.find(Classificado.class, id);
		
		return c;
	}
	
	public List<Classificado> getListarClassificado(){
		List<Classificado> classificados = manager.
				createQuery("select c from CLASSIFICADO as c", Classificado.class).
				getResultList();
		
		return classificados;
	}
}
