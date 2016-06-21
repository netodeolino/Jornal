package br.ufc.dao;

import java.util.List;

import br.ufc.model.Secao;

public interface ISecaoDAO {

	public void getInserirSecao(Secao s);
	public boolean getRemoverSecao(Long id);
	public void getAlterarSecao(Secao s);
	public Secao getRecuperarSecao(Long id);
	public Long getRecuperarSecaoPorID(Long id);
	public List<Secao> getListarSecao();
}
