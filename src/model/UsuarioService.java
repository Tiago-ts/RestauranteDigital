package model;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioService implements IUsuarioService {
	
	@Inject
	private UsuarioDAO repository;

	@Override
	public void cadastrar(Usuario usuario) {
		try {
			repository.salvarUsuario(usuario);
			System.out.println("usuario salvo");
		} catch (Exception e) {
			System.out.println("erro :" + e);
		}
		
	}

	@Override
	public void reset(String login, String senha) {
		login = null;
		senha = null;
		
	}

	
	public Usuario validar(String login, String senha) {
		return this.repository.buscar(login, senha);
	}

	

}
