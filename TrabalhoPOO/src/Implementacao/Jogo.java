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
 *  Classe: Jogo.java
 *  Sobre: Implementação da classe abstrata Jogo, para gerar informações dos jogos em geral.
 */

public abstract class Jogo {
	private static int contador = 0;
	private int idJogo;
	private String genero;
	private String dataLancamento;
	private String titulo;
	private Double preco;
	private Double avaliacaoMedia;
	private double somaAvaliacao;
	private int qtdeDeAvaliacoes;
	private int qtdeEstoque;
	
	public Jogo(String titulo, String dataLancamento, double preco
			, String genero, int qtdeEstoque) {
		contador++;
		this.idJogo = contador;
		this.genero = genero;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.titulo = titulo;
		this.avaliacaoMedia = 0.0;
		this.somaAvaliacao = 0;
		this.qtdeDeAvaliacoes = 0;
		this.qtdeEstoque = qtdeEstoque;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public String getGenero() {
		return genero;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public Double getPreco() {
		return preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public Double getAvaliacaoMedia() {
		return avaliacaoMedia;
	}

	public int getQtdeDeAvaliacoes() {
		return qtdeDeAvaliacoes;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public void setAvaliacaoMedia(double nota) {
		this.qtdeDeAvaliacoes++;
		this.somaAvaliacao += nota;
		this.avaliacaoMedia = this.somaAvaliacao / this.qtdeDeAvaliacoes;
	}
	
	public abstract void visualizarJogo();
				
}
