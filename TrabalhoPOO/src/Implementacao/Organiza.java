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
 *  Classe: Organiza.java
 *  Sobre: Implementa��o da classe Organiza, classe apenas para organiza��o/formata��o do cat�logo.
 */

// Alinhar o '|' 
public class Organiza {
	
	public static void espaco(int tamanho) {
		int x =  30 - tamanho;
		for (int i = 0; i < x - 1; i++) {
			System.out.print(" ");
		}
		System.out.println("|");
	}
}
