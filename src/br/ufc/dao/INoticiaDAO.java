package br.ufc.dao;

import java.util.List;

import br.ufc.model.Noticia;

public interface INoticiaDAO {

	public void getInserirNoticia(Noticia n);
	public boolean getRemoverNoticia(Long id);
	public boolean getRemoverNoticia(Noticia n);
	public boolean getRemoverNoticia2(Noticia n);
	public void getAlterarNoticia(Noticia n);
	public Noticia getRecuperarNoticia(Long id);
	public Noticia getRecuperarNoticia(String titulo);
	public List<Noticia> getListarNoticia();
}
