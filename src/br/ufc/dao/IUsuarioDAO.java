package br.ufc.dao;

import java.util.List;

import br.ufc.model.Usuario;

public interface IUsuarioDAO {

	public void getInserirUsuario(Usuario u);
	public boolean getRemoverUsuario(Long id);
	public void getAlterarUsuario(Usuario u);
	public Usuario getRecuperarUsuario(Long id);
	public List<Usuario> getListarUsuarios();
}
