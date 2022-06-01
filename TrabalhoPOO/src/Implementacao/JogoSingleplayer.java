package Implementacao;

public class JogoSingleplayer extends Jogo{
	
	public JogoSingleplayer(String titulo, String dataLancamento, double preco, String genero, int qtdeEstoque) {
		super(titulo, dataLancamento, preco, genero, qtdeEstoque);	
	}

	@Override
	public void visualizarJogo() {

		System.out.println("+-----------------------------------+");
		System.out.print("|Nome: " + super.getTitulo());
		Organiza.espaco(super.getTitulo().length());
		
		System.out.print("|Gênero: " + super.getGenero());
		Organiza.espaco(super.getGenero().length() + 2);
		
		System.out.println("|Modo: Singleplayer                 |");

		System.out.print("|Ano de lançamento: " + super.getDataLancamento());
		Organiza.espaco(super.getDataLancamento().length() + 13);
		
		System.out.printf("|Preço: R$%.2f", super.getPreco());
		Organiza.espaco(super.getPreco().toString().length() + 4);
		
		System.out.printf("|Avaliação: %.2f", super.getAvaliacaoMedia());
		Organiza.espaco(super.getAvaliacaoMedia().toString().length() + 6);
		
		System.out.println("+-----------------------------------+");
		
	}
	
}
