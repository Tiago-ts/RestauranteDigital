package control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.IUsuarioService;
import model.Usuario;
import model.UsuarioService;

@SuppressWarnings("serial")
@SessionScoped
@Named("login")
public class UsuarioCtrl implements Serializable {
	
	
	
	@Inject
	private IUsuarioService userService;

	private Usuario usuario;
	private String login;
	private String senha;
	private int idUsuario;


	public void reset() {
		userService.reset(login, senha);
	}
	public String logIn() {
	
		String link = null;
		usuario =userService.validar(getLogin(), getSenha());
		boolean usuarioLogado = usuario.val;
		if (usuarioLogado == false) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválidos", "Login Inválido"));
			link = null;
		} else {

			link = "MenuView.xhtml";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário localizado", "Login Válido"));
		}
		// return "CadastroUsuario.xhtml?facesRedirect=true";
		return link;
	}
	
	
	
	public synchronized int getIdUsuario() {
		return idUsuario;
	}
	public synchronized void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public IUsuarioService getUser() {
		return userService;
	}

	public void setUser(UsuarioService user) {
		this.userService = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
