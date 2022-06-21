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
 *  Classe: Item.java
 *  Sobre: Implementa��o da classe Item, com informa��es dos itens da compra de um cliente.
 */

public class Item {
		private static int contador = 0;
		private int idItem;
		private Jogo jogo;
		
		public Item(Jogo jogo/*, int quantidade*/) {
			contador++;
			this.idItem = contador;
			this.jogo = jogo;
		}
	
		public int getIdItem() {
			return idItem;
		}

		public Jogo getJogo() {
			return jogo;
		}

		public void visualizarItem() {
			System.out.println("+-----------------------------------+");
			System.out.println("|                ITEM               |");
			System.out.println("+-----------------------------------+");
			System.out.print("|Jogo: " + this.jogo.getTitulo());
			Organiza.espaco(this.jogo.getTitulo().length());		
			System.out.println("+-----------------------------------+");
		}
 
}
