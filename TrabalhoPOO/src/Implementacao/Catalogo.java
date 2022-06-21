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
 *  Classe: Catalogo.java
 *  Sobre: Implementa��o da classe Catalogo, que pega os jogos e imprime para o usu�rio.
 */

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Jogo> jogos = new ArrayList<>();
	private Integer jogosDisponiveis;

	public List<Jogo> getJogos() {
		return jogos;
	}
	
	public void visualizarCatalogo() {
		jogosDisponiveis = this.jogos.size();
		
		System.out.println("+-----------------------------------+");
		System.out.println("|             CATALOGO              | ");
		System.out.println("+-----------------------------------+");
		System.out.print("|Jogos dispon�veis: #" + this.jogos.size());
		Organiza.espaco(this.jogosDisponiveis.toString().length() + 14);
		System.out.println("+-----------------------------------+");
		for (Jogo jg : jogos) {
			jg.visualizarJogo();
		}

	}

}

