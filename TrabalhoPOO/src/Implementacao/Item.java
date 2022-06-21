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
 *  Classe: Item.java
 *  Sobre: Implementação da classe Item, com informações dos itens da compra de um cliente.
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
