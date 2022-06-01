package Implementacao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loja {
	private String nome;
	private List<Cliente> clientes;
	private Catalogo catalogo;
	
	public Loja() {
		this.nome = "Dynamic Game";
		this.clientes = new ArrayList<>();
		this.catalogo = new Catalogo();
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void visualizarLoja() {
		System.out.println("+-----------------------------------+");
		System.out.println("|               LOJA                |");
		System.out.println("+-----------------------------------+");
		System.out.print("|Nome: " + this.nome);
		Organiza.espaco(this.nome.length());
		System.out.println("+-----------------------------------+");
		System.out.printf("|Número de clientes: #%d             |\n", this.clientes.size());
		System.out.println("+-----------------------------------+");
		System.out.printf("|Jogos no catalogo: #%d              |\n", this.catalogo.getJogos().size());
		System.out.println("+-----------------------------------+");
	}

	public void adicionarJogo(String nome, String ano, Double preco, String genero, int quantidade) {

		boolean entrou = false;

		if (catalogo.getJogos().size() != 0) {
			for (Jogo jg : this.catalogo.getJogos()) {
				if (jg.getTitulo().equalsIgnoreCase(nome)) {
					jg.setQtdeEstoque(jg.getQtdeEstoque() + quantidade);
					entrou = true;
				}
			}

			if (!entrou) {
				this.catalogo.getJogos().add(new JogoSingleplayer(nome, ano, preco, genero, quantidade));
			}
		}

		else {
			this.catalogo.getJogos().add(new JogoSingleplayer(nome, ano, preco, genero, quantidade));
		}
	}
	
	public void adicionarJogo(String nome, String ano, Double preco, String genero, int quantidade, int numJogadores) {

		boolean entrou = false;

		if (catalogo.getJogos().size() != 0) {
			for (Jogo jg : this.catalogo.getJogos()) {
				if (jg.getTitulo().equalsIgnoreCase(nome)) {
					jg.setQtdeEstoque(jg.getQtdeEstoque() + quantidade);
					entrou = true;
				}
			}

			if (!entrou) {
				this.catalogo.getJogos().add(new JogoMultiplayer(nome, ano, preco, genero, quantidade, numJogadores));
			}
		}

		else {
			this.catalogo.getJogos().add(new JogoMultiplayer(nome, ano, preco, genero, quantidade, numJogadores));
		}
	}

	public void removerJogo(Jogo jogo) {
		this.catalogo.getJogos().remove(jogo);
	}
	
	public int cadastrarCliente(String nome, String cpf, String usuario, String senha) {
		boolean entrou = false;
		
		for(Cliente cliente: this.clientes) {
			if(cliente.getLogin().getUsuario().equalsIgnoreCase(usuario)) {
				entrou = true;	
			}		
		}
		
		if(!entrou) {
			this.clientes.add(new Cliente(nome, cpf, usuario, senha));
			return 1;
		} else {
			return -1;
		}	
	}
	
	public void gerarListaCliente() {
		
		System.out.println("+-----------------------------------+");
		System.out.println("|         LISTA DE CLIENTES         |");
		System.out.println("+-----------------------------------+");
		System.out.printf("|Número de clientes: #%d             |\n", this.clientes.size());
		
		for(Cliente c: clientes) {
			System.out.println("+-----------------------------------+");
			System.out.print("|Id do cliente: " + c.getIdCliente());
			Organiza.espaco(c.getIdCliente().toString().length() + 9);

			System.out.print("|Nome do cliente: " + c.getNome());
			Organiza.espaco(c.getNome().length() + 11);

			System.out.print("|CPF do cliente: " + c.getCpf());
			Organiza.espaco(c.getCpf().length() + 10);

		}
		
		System.out.println("+-----------------------------------+");
		
		try {
			FileWriter escreve = new FileWriter("dados.txt");
			escreve.write("-----------------------------------------------");
			escreve.write("\n            LISTA DE CLIENTES           ");
			escreve.write("\n-----------------------------------------------");
			escreve.write("  \nNúmero de clientes: #" + this.clientes.size());
			for(Cliente c: clientes) {
				escreve.write("\n-----------------------------------------------");
				escreve.write("  \nId do cliente: " + c.getIdCliente());
				escreve.write("  \nNome do cliente: " + c.getNome());
				escreve.write("  \nCPF do cliente: " + c.getCpf());
			}
			escreve.write("\n-----------------------------------------------");
			escreve.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ok
	public void gerarRelCliente(int index) {
		System.out.println("+-----------------------------------+");
		System.out.println("|              RELATÓRIO            |");
		
		this.clientes.get(index).visualizarCliente();
	}

	// ok
	public void gerarRelDataLancamento(String ano) {

		boolean entrou = false;

		System.out.println("+-----------------------------------+");
		System.out.printf("|       JOGOS LANÇADOS EM %s      |\n", ano);
		System.out.println("+-----------------------------------+");
		for (Jogo jg : this.catalogo.getJogos()) {
			if (jg.getDataLancamento().equals(ano)) {
				jg.visualizarJogo();
				entrou = true;
			}

		}
		if (!entrou) {
			System.out.println("|       NENHUM JOGO ENCONTRADO      |");
			System.out.println("+-----------------------------------+");
		}
	}

	public void gerarRelPrecoAbaixo(Double preco) {
		
		boolean entrou = false;
		
		System.out.println("+-----------------------------------+");
		System.out.printf("|     JOGOS ABAIXO DE R$%.2f", preco);
		Organiza.espaco(preco.toString().length() + 18);
		
		System.out.println("+-----------------------------------+");
		for (Jogo jg : this.catalogo.getJogos()) {
			if(jg.getPreco() < preco) {
				jg.visualizarJogo();
				entrou = true;
			}
		}
		
		if(!entrou) {
			System.out.println("|       NENHUM JOGO ENCONTRADO      |");
			System.out.println("+-----------------------------------+");
		}
	}
	
	public void gerarRelGeneroJogo(String genero) {
		
		boolean entrou = false;
		
		System.out.println("+-----------------------------------+");
		System.out.printf("|         JOGOS DE %s", genero.toUpperCase());
		Organiza.espaco(genero.length() + 12);
		System.out.println("+-----------------------------------+");
		for (Jogo jg : this.catalogo.getJogos()) {
			if(jg.getGenero().equalsIgnoreCase(genero)) {
				jg.visualizarJogo();
				entrou = true;
			}
		}
		
		if(!entrou) {
			System.out.println("|       NENHUM JOGO ENCONTRADO      |");
			System.out.println("+-----------------------------------+");
		}
	}

	public void gerarRelJogosAVenda() {
		System.out.println("+-----------------------------------+");
		System.out.println("|           JOGOS À VENDA           | ");
		System.out.println("+-----------------------------------+");
		for (Jogo jg : catalogo.getJogos()) {
			jg.visualizarJogo();
		}
	}
}
