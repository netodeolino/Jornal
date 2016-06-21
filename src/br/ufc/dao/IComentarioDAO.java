package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comentario;

public interface IComentarioDAO {

	public void getInserirComentario(Comentario c);
	public boolean getRemoverComentario(Long id);
	public void getAlterarComentario(Comentario c);
	public Comentario getRecuperarComentario(Long id);
	public List<Comentario> getListarComentario();
}
