package mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.UserRn;
import Dominio.User;

@SessionScoped
@ManagedBean
public class SessaoMB {
	private User usuarioLogado;
	
	private UserRn rn;

	private User usuarioForm;

	@PostConstruct
	public void iniciar() {
		usuarioForm = new User();
	}

	public User getUsuarioForm() {
		return usuarioForm;
	}

	public void setUsuarioForm(User usuarioForm) {
		this.usuarioForm = usuarioForm;
	}

	public String entrar() {
		UserRn rn = new UserRn();
		User usuario = rn.buscarPorEmail(usuarioForm.getEmail());
		
		if ( usuario != null && usuarioForm.getEmail().equalsIgnoreCase(usuario.getEmail())
				&& usuarioForm.getSenha().equals(usuario.getSenha())) {
			usuarioLogado = usuarioForm;
			System.out.println("Entrou");
			return "/index";
			
		}
		
		System.out.println("Não Entrou");
		return "";
	}

	public String sair() {
		usuarioLogado = null;
		return "/index?faces-redirect=true";
	}

	public Boolean estaLogado() {
		return usuarioLogado != null;
	}

}
