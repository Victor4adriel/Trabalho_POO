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
 *  Classe: Cliente.java
 *  Sobre: Implementação da classe Cliente, usada para pegar e gerar dados sobre possiveis clientes que irão usufruir do sistema.
 */

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private static int contador = 0;
	private Integer idCliente;
	private String nome;
	private String cpf;
	private Login login;
	private List<Pedido> pedidos = new ArrayList<>();
	private List<Jogo> jogosAdquiridos = new ArrayList<>();
	
	public Cliente() {
		this("N/A", "N/A", "N/A", "N/A");
	}

	public Cliente(String nome, String cpf, String usuario, String senha) {
		contador++;
		this.idCliente = contador;
		this.nome = nome;
		this.cpf = cpf;
		this.login = new Login(usuario, senha);
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Jogo> getJogosAdquiridos() {
		return jogosAdquiridos;
	}
	
	public Login getLogin() {
		return login;
	}

	public void setJogosAdquiridos(Jogo jogoAdquirido) {
		this.jogosAdquiridos.add(jogoAdquirido);
	}
	
	public int avaliarJogo(Jogo jogo, double nota) {
		
		boolean entrou = false;
		
		for(Jogo jg: jogosAdquiridos) {
			if(jg.getTitulo().equalsIgnoreCase(jogo.getTitulo())) {
				entrou = true;
			}
		}
		
		if(entrou && nota >= 0 && nota <= 10) {
			jogo.setAvaliacaoMedia(nota);
			return 1;
		} else {
			return -1;
		}
	}
	
	public void finalizarPedido(Pedido pedido) {
		for (Item item : pedido.getItens()) {
			Jogo jg = item.getJogo();
			setJogosAdquiridos(jg);
			jg.setQtdeEstoque(jg.getQtdeEstoque() - 1 /*item.getQuantidade()*/);
		}
		this.pedidos.add(pedido);
		pedido.setStatus("PAGO");
	}
	
	public void visualizarPedidos() {
		if(pedidos.size() == 0) {
			System.out.println("+-----------------------------------+");
			System.out.println("|           Nenhum Pedido           |");
			System.out.println("+-----------------------------------+");
		} else {
			for(Pedido pd: pedidos) {
				pd.visualizarPedido();
				System.out.println("\n");
			}
		}
	}
	
	public void visualizarCliente() {
		System.out.println("+-----------------------------------+");
		System.out.println("|               CLIENTE             |");
		System.out.println("+-----------------------------------+");
		System.out.print("|Id do cliente: " + this.idCliente);
		Organiza.espaco(this.idCliente.toString().length() + 9);

		System.out.print("|Nome do cliente: " + this.nome);
		Organiza.espaco(this.nome.length() + 11);

		System.out.print("|CPF do cliente: " + this.cpf);
		Organiza.espaco(this.cpf.length() + 10);

		visualizarJogosAdquiridos();
	}
	
	public void visualizarJogosAdquiridos() {
		System.out.println("+-----------------------------------+");
		System.out.println("|          JOGOS ADQUIRIDOS         |");
		System.out.println("+-----------------------------------+");

		if (jogosAdquiridos.size() == 0) {
			System.out.println("|       nenhum jogo adquirido!      |");
			System.out.println("+-----------------------------------+");
		} else {
			for (Jogo jg : jogosAdquiridos) {
				jg.visualizarJogo();
			}
		}
	}
}
