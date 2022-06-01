package Implementacao;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private static int contador = 0;
	private Integer idPedido;
	private List<Item> itens = new ArrayList<>();
	private Double valorTotal;
	private String status;
	
	public Pedido() {
		contador++;
		this.idPedido = contador;
		this.valorTotal = 0.0;
		this.status = "NÃO PAGO!";
	}

	public int getIdPedido() {
		return idPedido;
	}

	public List<Item> getItens() {
		return itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void adicionarItem(Item item) {
		this.itens.add(item);
		this.valorTotal += /*item.getQuantidade() * */ item.getJogo().getPreco();
	}
	
	public void removerItem(Item item) {
		this.itens.remove(item);
		this.valorTotal -= /* item.getQuantidade() * */ item.getJogo().getPreco();
	}
	
	public void visualizarPedido() {
		System.out.println("+-----------------------------------+");
		System.out.println("|               PEDIDO              |");
		System.out.println("+-----------------------------------+");
		
		System.out.print("|Número do pedido: #" + this.idPedido);
		Organiza.espaco(this.idPedido.toString().length() + 13);
		
		System.out.println("+-----------------------------------+");
		
		System.out.print("|Status: " + this.status);
		Organiza.espaco(this.status.length() + 2);
		
		System.out.println("+-----------------------------------+");
		System.out.println("|               ITENS               |");
		
		for(Item item: itens) {
			System.out.println("+-----------------------------------+");
			System.out.print("|Jogo: " + item.getJogo().getTitulo());
			Organiza.espaco(item.getJogo().getTitulo().length());		
		}
		System.out.println("+-----------------------------------+");
		System.out.println("|               TOTAL               |");
		System.out.println("+-----------------------------------+");
		System.out.printf("|Valor total: R$%.2f", this.valorTotal);
		Organiza.espaco(this.valorTotal.toString().length() + 10);
		
		System.out.println("+-----------------------------------+");
	}
	
	
}
