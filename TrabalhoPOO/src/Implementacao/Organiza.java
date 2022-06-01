package Implementacao;

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
