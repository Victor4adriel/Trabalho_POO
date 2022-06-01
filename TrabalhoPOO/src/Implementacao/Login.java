package Implementacao;

public class Login {
	private String usuario;
	private String senha;
	
	public Login(String usuario, String senha) {
		this.senha = senha;
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}
	
}
