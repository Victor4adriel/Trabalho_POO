package Implementacao;

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
		System.out.print("|Jogos disponíveis: #" + this.jogos.size());
		Organiza.espaco(this.jogosDisponiveis.toString().length() + 14);
		System.out.println("+-----------------------------------+");
		for (Jogo jg : jogos) {
			jg.visualizarJogo();
		}

	}

}

