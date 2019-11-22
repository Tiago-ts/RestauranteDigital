package model;

import javax.ejb.Local;

@Local
public interface IUsuarioService {

	public void cadastrar(Usuario usuario);

	public void reset(String login, String senha);

	public Usuario validar(String login, String senha);

}
