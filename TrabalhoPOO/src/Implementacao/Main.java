package Implementacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Loja lj1 = new Loja();	
		
		try {
			FileReader arqCliente = new FileReader("C:\\Users\\Casa\\Desktop\\Dados_TP\\clientes.txt");
			BufferedReader lerArqCliente = new BufferedReader(arqCliente);
			String linhaCliente = lerArqCliente.readLine();
			String cliente[] = new String[4];
			
			while(linhaCliente != null) {
				cliente = linhaCliente.split(";");
				lj1.cadastrarCliente(cliente[0], cliente[1], cliente[2], cliente[3]);
				linhaCliente = lerArqCliente.readLine();
			}
			arqCliente.close();
					
			FileReader arqJogo = new FileReader("C:\\Users\\Casa\\Desktop\\Dados_TP\\jogos.txt");
			BufferedReader lerArqJogo = new BufferedReader(arqJogo);
			String linhaJogo = lerArqJogo.readLine();
			String jogo[] = new String[4];
			
			while(linhaJogo != null) {
				jogo = linhaJogo.split(";");
				if(jogo.length > 5) {
					lj1.adicionarJogo(jogo[0], jogo[1], Double.parseDouble(jogo[2]), jogo[3], Integer.parseInt(jogo[4]), Integer.parseInt(jogo[5]));
				} else {
					lj1.adicionarJogo(jogo[0], jogo[1], Double.parseDouble(jogo[2]), jogo[3], Integer.parseInt(jogo[4]));
				}
				linhaJogo = lerArqJogo.readLine();
			}
			arqJogo.close();
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} 
		
		lj1.getCatalogo().visualizarCatalogo();
		
		lj1.gerarListaCliente();

	}

}
