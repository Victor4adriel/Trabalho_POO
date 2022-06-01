package Implementacao;

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
