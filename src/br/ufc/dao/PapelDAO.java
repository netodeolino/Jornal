package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;

@Repository
public class PapelDAO implements IPapelDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void getInserirPapel(Papel p){
		manager.persist(p);
	}
	
	public boolean getRemoverPapel(Long id){
		try {
			Papel rem = manager.find(Papel.class, id);
			manager.remove(rem);
			//System.out.println("REMOVIDO FÍ");
		} catch (Exception e){
			//System.out.println("NÃO REMOVEU FÍ");
			return false;
		}
		return true;
	}
	
	public void getAlterarPapel(Papel p){
		manager.merge(p);
	}
	
	public Papel getRecuperarPapel(Long id){
		Papel p = manager.find(Papel.class, id);
		
		return p;
	}
	
	public List<Papel> getListarPapel(){
		List<Papel> papeis = manager.
				createQuery("select p from PAPEL as p", Papel.class).
				getResultList();
		
		return papeis;
	}
}
