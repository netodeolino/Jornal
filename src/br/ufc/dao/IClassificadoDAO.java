package br.ufc.dao;

import java.util.List;

import br.ufc.model.Classificado;

public interface IClassificadoDAO {

	public void getInserirClassificado(Classificado c);
	public boolean getRemoverClassificado(Long id);
	public void getAlterarClassificado(Classificado c);
	public Classificado getRecuperarClassificado(Long id);
	public List<Classificado> getListarClassificado();
	
}
