package Implementacao;

/*
 *  Trabalho de POO (Programação Orientada a Objetos)
 *  Entregas:
 *  1°: __/__/____
 *  2°: 02/06/2022
 *  3°: __/__/____
 *  
 *  Integrantes: João Marcos, Kelvyn, Leonardo Monteiro, Victor Adriel, Vinicius
 *  
 *  Classe: Login.java
 *  Sobre: Implementação da classe Login, para gerenciamento de usuários.
 */

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
