package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;

@Repository
public class SecaoDAO implements ISecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void getInserirSecao(Secao s){
		manager.persist(s);
	}
	
	public boolean getRemoverSecao(Long id){
		try {
			Secao rem = manager.find(Secao.class, id);
			manager.remove(rem);
			//System.out.println("REMOVIDO FÍ");
		} catch (Exception e){
			//System.out.println("NÃO REMOVEU FÍ");
			return false;
		}
		return true;
	}
	
	public void getAlterarSecao(Secao s){
		manager.merge(s);
	}
	
	public Secao getRecuperarSecao(Long id){
		Secao s = manager.find(Secao.class, id);
		
		return s;
	}
	
	public Long getRecuperarSecaoPorID(Long id){
		Long ret = manager.find(Secao.class, id).getIdSecao();
		return ret;
	}
	
	public List<Secao> getListarSecao(){
		List<Secao> secoes = manager.
				createQuery("select s from SECAO as s", Secao.class).
				getResultList();
		
		return secoes;
	}
}
