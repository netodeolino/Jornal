package br.ufc.dao;

import java.util.List;

import br.ufc.model.Papel;

public interface IPapelDAO {

	public void getInserirPapel(Papel p);
	public boolean getRemoverPapel(Long id);
	public void getAlterarPapel(Papel p);
	public Papel getRecuperarPapel(Long id);
	public List<Papel> getListarPapel();
}
