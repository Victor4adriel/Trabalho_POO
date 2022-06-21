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
 *  Classe: Organiza.java
 *  Sobre: Implementação da classe Organiza, classe apenas para organização/formatação do catálogo.
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
