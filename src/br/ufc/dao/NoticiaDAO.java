package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;

@Repository
public class NoticiaDAO implements INoticiaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void getInserirNoticia(Noticia n){
		manager.persist(n);
	}
	
	public boolean getRemoverNoticia(Long id){
		try {
			Noticia rem = manager.find(Noticia.class, id);
			manager.remove(rem);
			//System.out.println("REMOVIDO FÍ");
		} catch (Exception e){
			//System.out.println("NÃO REMOVEU FÍ");
			return false;
		}
		return true;
	}
	
	public boolean getRemoverNoticia(Noticia n){
		try {
			Noticia rem = manager.find(Noticia.class, n.getIdNoticia());
			manager.remove(rem);
			//System.out.println("REMOVIDO FÍ");
		} catch (Exception e){
			//System.out.println("NÃO REMOVEU FÍ");
			return false;
		}
		return true;
	}
	
	public boolean getRemoverNoticia2(Noticia n){
		try {
			String hql = "delete from NOTICIA where NOTICIA_ID = :n";
			
			Query query = this.manager.createQuery(hql);
			
			query.setParameter("n", n.getIdNoticia());
			query.executeUpdate();
			//System.out.println("REMOVIDO FÍ");
		} catch (Exception e){
			//System.out.println("NÃO REMOVEU FÍ");
			return false;
		}
		return true;
	}
	
	public void getAlterarNoticia(Noticia n){
		manager.merge(n);
	}
	
	public Noticia getRecuperarNoticia(Long id){
		Noticia n = manager.find(Noticia.class, id);
		
		return n;
	}
	
	public Noticia getRecuperarNoticia(String titulo){
		String hql = "select n from NOTICIA as n "
				+ " where n.titulo = :param_login";
		
		Query query = manager.createQuery(hql);
		List <Noticia>noticias = query.setParameter("param_login", titulo).getResultList();
		if(noticias.size() != 0)
		{
			return noticias.get(0);
		}
		return null;
	}
	
	public List<Noticia> getListarNoticia(){
		List<Noticia> noticias = manager.
				createQuery("select n from NOTICIA as n", Noticia.class).
				getResultList();
		
		return noticias;
	}
}
