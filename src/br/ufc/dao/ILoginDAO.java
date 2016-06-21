package br.ufc.dao;

import br.ufc.model.Usuario;

public interface ILoginDAO {

	public Usuario getBuscarPorLogin(Usuario usu);
	
}
