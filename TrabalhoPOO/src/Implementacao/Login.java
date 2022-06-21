package Implementacao;

/*
 *  Trabalho de POO (Programa��o Orientada a Objetos)
 *  Entregas:
 *  1�: __/__/____
 *  2�: 02/06/2022
 *  3�: __/__/____
 *  
 *  Integrantes: Jo�o Marcos, Kelvyn, Leonardo Monteiro, Victor Adriel, Vinicius
 *  
 *  Classe: Login.java
 *  Sobre: Implementa��o da classe Login, para gerenciamento de usu�rios.
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
