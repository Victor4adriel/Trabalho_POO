package Implementacao;

/*
 *  Trabalho de POO (Programação Orientada a Objetos)
 *  Entregas
 *  1°: __/__/____
 *  2°: 02/06/2022
 *  3°: __/__/____
 *  
 *  Integrantes: João Marcos, Kelvyn, Leonardo Monteiro, Victor Adriel, Vinicius
 *  
 *  Classe: Main.java
 *  Sobre: Implementação da classe principal onde o código irá ser executado.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void comprar(Loja lj, Cliente c, Scanner entrada) {
		int id;
		boolean repete = true;
		char resposta;
		Pedido p = new Pedido();
		do {
			System.out.println("Informe o ID do jogo a ser comprado: ");
			id = entrada.nextInt();
			System.out.println("+-----------------------------------+");

			for (Jogo jg : lj.getCatalogo().getJogos()) {
				if (jg.getIdJogo() == id) {
					p.adicionarItem(new Item(jg));
				}
			}

			System.out.print("Continuar comprando? (S/N): ");
			resposta = entrada.next().charAt(0);
			System.out.println("+-----------------------------------+");

			switch (resposta) {
			case 'n':
			case 'N':
				repete = false;
				break;
			case 's':
			case 'S':
				break;
			default:
				System.out.println("Resposta Inválida!");
				System.out.println("+-----------------------------------+");
			}

		} while (repete);

		System.out.print("Finalizar Pedido? (S/N): ");
		resposta = entrada.next().charAt(0);
		System.out.println("+-----------------------------------+");

		switch (resposta) {
		case 'n':
		case 'N':
			break;
		case 's':
		case 'S':
			c.finalizarPedido(p);
			break;
		default:
			System.out.println("Resposta Inválida!");
		}

		try {
			String dados = Integer.toString(c.getIdCliente());

			FileWriter arq = new FileWriter("C:\\Users\\Casa\\Desktop\\Dados_TP\\pedidos.txt", true);
			for (Item item : p.getItens()) {
				dados = dados.concat(";" + item.getJogo().getIdJogo());
			}
			arq.write("\n" + dados);
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Pedido Finalizado!");
		System.out.println("+-----------------------------------+\n");

	}

	public static void adicionarJogo(Loja lj, Scanner entrada) {

		String nome, ano, genero;
		char resposta;
		double preco;
		int quantidade, numMax;

		System.out.println("+-----------------------------------+");
		System.out.print("Digite o nome do jogo: ");
		nome = entrada.nextLine();
		System.out.println("+-----------------------------------+");
		System.out.print("Digite o ano de lançamento: ");
		ano = entrada.next();
		System.out.println("+-----------------------------------+");
		System.out.print("Digite o preço do jogo: ");
		preco = entrada.nextDouble();
		System.out.println("+-----------------------------------+");
		System.out.print("Digite o gênero do jogo: ");
		genero = entrada.next();
		System.out.println("+-----------------------------------+");
		System.out.print("Informe quantas unidades está adicionando: ");
		quantidade = entrada.nextInt();
		System.out.println("+-----------------------------------+");

		System.out.print("É multiplayer? (S/N): ");
		resposta = entrada.next().charAt(0);
		System.out.println("+-----------------------------------+");

		switch (resposta) {
		case 'S':
		case 's':
			System.out.println("Informe o número máximo de jogadores: ");
			numMax = entrada.nextInt();
			System.out.println("+-----------------------------------+");
			lj.adicionarJogo(nome, ano, preco, genero, quantidade, numMax);
			try {
				FileWriter arq = new FileWriter("C:\\Users\\Casa\\Desktop\\Dados_TP\\jogos.txt", true);
				arq.write("\n" + nome + ";" + ano + ";" + preco + ";" + genero + ";" + quantidade + ";" + numMax);
				arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'N':
		case 'n':
			lj.adicionarJogo(nome, ano, preco, genero, quantidade);
			try {
				FileWriter arq = new FileWriter("C:\\Users\\Casa\\Desktop\\Dados_TP\\jogos.txt", true);
				arq.write("\n" + nome + ";" + ano + ";" + preco + ";" + genero + ";" + quantidade);
				arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Resposta inválida!!");
			System.out.println("+-----------------------------------+");
		}

		System.out.println("Jogo Adicionado!");
		System.out.println("+-----------------------------------+");

	}

	public static void cadastrarCliente(Loja lj, Scanner entrada) {
		String nome, cpf, user, password;
		System.out.println("+-----------------------------------+");
		System.out.println("|             CADASTRO              |");
		System.out.println("+-----------------------------------+");
		System.out.print("Digite um nome: ");
		nome = entrada.nextLine();
		System.out.println("+-----------------------------------+");
		System.out.print("Digite um CPF: ");
		cpf = entrada.next();
		limpaBuffer(entrada);
		System.out.println("+-----------------------------------+");
		System.out.print("Digite nome de usuário: ");
		user = entrada.next();
		limpaBuffer(entrada);
		System.out.println("+-----------------------------------+");
		System.out.print("Digite a senha do usuário: ");
		password = entrada.next();
		limpaBuffer(entrada);
		System.out.println("+-----------------------------------+");

		try {
			FileWriter arq = new FileWriter("C:\\Users\\Casa\\Desktop\\Dados_TP\\clientes.txt", true);
			arq.write("\n" + nome + ";" + cpf + ";" + user + ";" + password);
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lj.cadastrarCliente(nome, cpf, user, password);

		System.out.println("Cadastro Realizado!");
		System.out.println("+-----------------------------------+\n");

	}

	public static void verPerfil(Cliente c) {
		c.visualizarCliente();
	}

	public static void inicializar(Loja lj) {

		try {
			FileReader arq = new FileReader("C:\\Users\\Casa\\Desktop\\Dados_TP\\clientes.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			String cliente[] = new String[4];

			while (linha != null) {
				cliente = linha.split(";");
				lj.cadastrarCliente(cliente[0], cliente[1], cliente[2], cliente[3]);
				linha = lerArq.readLine();
			}
			arq.close();

			arq = new FileReader("C:\\Users\\Casa\\Desktop\\Dados_TP\\jogos.txt");
			lerArq = new BufferedReader(arq);
			linha = lerArq.readLine();
			String jogo[] = new String[4];

			while (linha != null) {

				jogo = linha.split(";");
				if (jogo.length > 5) {
					lj.adicionarJogo(jogo[0], jogo[1], Double.parseDouble(jogo[2]), jogo[3], Integer.parseInt(jogo[4]),
							Integer.parseInt(jogo[5]));
				} else {
					lj.adicionarJogo(jogo[0], jogo[1], Double.parseDouble(jogo[2]), jogo[3], Integer.parseInt(jogo[4]));
				}
				linha = lerArq.readLine();
			}
			arq.close();

			arq = new FileReader("C:\\Users\\Casa\\Desktop\\Dados_TP\\Pedidos.txt");
			lerArq = new BufferedReader(arq);
			linha = lerArq.readLine();
			String pedidos[] = new String[4];

			while (linha != null) {
				pedidos = linha.split(";");
				for (Cliente c : lj.getClientes()) {

					if (c.getIdCliente() == Integer.parseInt(pedidos[0])) {

						Pedido pedido = new Pedido();

						for (int i = 1; i < pedidos.length; i++) {
							for (Jogo jg : lj.getCatalogo().getJogos()) {
								if (jg.getIdJogo() == Integer.parseInt(pedidos[i])) {
									pedido.adicionarItem(new Item(jg));
								}
							}
						}

						c.finalizarPedido(pedido);

						linha = lerArq.readLine();
					}
				}
			}
			arq.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void avaliarJogo(Loja lj, Scanner entrada, Cliente cliente) {
		int id;
		double nota;
		
		cliente.visualizarJogosAdquiridos();
		
		if(cliente.getJogosAdquiridos().size() > 0) {
			System.out.print("Informe o ID do jogo a ser avaliado: ");
			id = entrada.nextInt();
		
			for(Jogo jg: cliente.getJogosAdquiridos()) {
				if(jg.getIdJogo() == id) {
					System.out.print("Informe uma nota (0 - 10): ");
					nota = entrada.nextDouble();
					
					cliente.avaliarJogo(jg, nota);	
				}
			}	
		} 
	}

	public static void menuUser() {
		System.out.println("+-----------------------------------+");
		System.out.println("|               MENU                |");
		System.out.println("+-----------------------------------+");
		System.out.println("|1 - Comprar jogos                  |");
		System.out.println("|2 - Meus pedidos                   |");
		System.out.println("|3 - Ver perfil                     |");
		System.out.println("|4 - Avaliar jogo                   |");
		System.out.println("|5 - Sair da Conta                  |");
		System.out.println("+-----------------------------------+");
	}

	public static void menuAdmin() {
		System.out.println("+-----------------------------------+");
		System.out.println("|               MENU                |");
		System.out.println("+-----------------------------------+");
		System.out.println("|1 - Visualizar catalogo            |");
		System.out.println("|2 - Adicionar jogo                 |");
		System.out.println("|3 - Relatórios                     |");
		System.out.println("|4 - Sair da Conta                  |");
		System.out.println("+-----------------------------------+");
	}

	public static void menuRelatorio() {
		System.out.println("+-----------------------------------+");
		System.out.println("|          GERAR RELATÓRIO          |");
		System.out.println("+-----------------------------------+");
		System.out.println("|1 - Dados do Cliente               |");
		System.out.println("|2 - Jogos de Determinado Ano       |");
		System.out.println("|3 - Jogos Com Preço Abaixo de X    |");
		System.out.println("|4 - Jogos de Um Determinado Gênero |");
		System.out.println("|5 - Dados de Jogos à Venda         |");
		System.out.println("+-----------------------------------+");
	}

	public static void limpaBuffer(Scanner entrada) {
		if (entrada.hasNextLine()) {
			entrada.nextLine();
		}
	}

	public static void main(String[] args) {

		Loja lj = new Loja();

		inicializar(lj);

		boolean existeLogin, existeSenha;
		String login, senha;
		Scanner entrada = new Scanner(System.in);
		int adminOuCliente = 0;
		char resp;
		int opcao = 0;

		Cliente c = new Cliente();

		while (true) {

			boolean repete = true;
			System.out.println("+------------------------+");
			System.out.print("Possui Cadastro (S/N)? ");
			resp = entrada.next().charAt(0);
			System.out.println("+------------------------+");
			switch (resp) {
			case 'S':
			case 's':
				do {
					existeLogin = false;
					existeSenha = false;

					System.out.print("Login: ");
					login = entrada.next();
					System.out.println("+------------------------+");
					System.out.print("Senha: ");
					senha = entrada.next();
					System.out.println("+------------------------+");

					if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
						adminOuCliente = 2;
						existeLogin = true;
						existeSenha = true;
					} else {

						for (Cliente cliente : lj.getClientes()) {

							if (cliente.getLogin().getUsuario().equalsIgnoreCase(login)) {
								existeLogin = true;

								if (cliente.getLogin().getSenha().equals(senha)) {
									existeSenha = true;
									c = cliente;
									adminOuCliente = 1;
								}
							}
						}

						if (!existeLogin) {
							System.out.println("Login Incorreto!!");
							System.out.println("+------------------------+");
						} else if (existeLogin && !existeSenha) {
							System.out.println("Senha Incorreta!!");
							System.out.println("+------------------------+");
						} else {
							System.out.println("Logado!!");
							System.out.println("+------------------------+");
						}
					}

				} while (existeLogin != true || existeSenha != true);

				switch (adminOuCliente) {

				case 1:
					do {
						menuUser();
						System.out.print("Selecione uma opção: ");
						opcao = entrada.nextInt();
						limpaBuffer(entrada);

						switch (opcao) {
						case 1:
							lj.getCatalogo().visualizarCatalogo();

							comprar(lj, c, entrada);

							limpaBuffer(entrada);

							System.out.println("Pressione 'Enter' para retornar ao menu.");

							entrada.nextLine();

							break;

						case 2:
							c.visualizarPedidos();

							System.out.println("Pressione 'Enter' para retornar ao menu.");

							entrada.nextLine();
							break;
						case 3:
							verPerfil(c);

							System.out.println("\nPressione 'Enter' para retornar ao menu.");

							entrada.nextLine();
							break;
						case 4:
							avaliarJogo(lj, entrada, c);
							
							System.out.println("\nPressione 'Enter' para retornar ao menu.");

							entrada.nextLine();
							break;
						case 5:
							repete = false;
							break;
						}

					} while (repete);

					break;
				case 2:
					do {
						menuAdmin();
						System.out.print("Selecione uma opção: ");
						opcao = entrada.nextInt();

						limpaBuffer(entrada);

						switch (opcao) {
						case 1:
							lj.getCatalogo().visualizarCatalogo();
							System.out.println("\nPressione 'Enter' para retornar ao menu.");

							entrada.nextLine();
							break;
						case 2:
							adicionarJogo(lj, entrada);
							System.out.println("\nPressione 'Enter' para retornar ao menu.");

							// Limpar buffer do scanner
							limpaBuffer(entrada);

							entrada.nextLine();
							break;
						case 3:
							menuRelatorio();
							System.out.print("Selecione uma opção: ");
							opcao = entrada.nextInt();
							limpaBuffer(entrada);
							switch (opcao) {
							case 1:
								lj.gerarListaCliente();
								break;
							case 2:
								System.out.println("+-----------------------------------+");
								System.out.println("Informe o ano de lançamento: ");
								String ano = entrada.next();
								System.out.println("+-----------------------------------+");
								lj.gerarRelDataLancamento(ano);
								limpaBuffer(entrada);
								break;
							case 3:
								System.out.println("+-----------------------------------+");
								System.out.println("informe um preço (R$): ");
								double preco = entrada.nextDouble();
								System.out.println("+-----------------------------------+");
								lj.gerarRelPrecoAbaixo(preco);
								limpaBuffer(entrada);
								break;
							case 4:
								System.out.println("+-----------------------------------+");
								System.out.print("Informe o gênero: ");
								String genero = entrada.next();
								System.out.println("+-----------------------------------+");
								lj.gerarRelGeneroJogo(genero);

								limpaBuffer(entrada);
								break;
							case 5:
								lj.gerarRelJogosAVenda();
								break;
							}
							System.out.println("\nPressione 'Enter' para retornar ao menu.");
							entrada.nextLine();
							break;
						case 4:
							repete = false;
							break;
						default:
							System.out.println("+-----------------------------------+");
							System.out.println("Opção inválida!");
							System.out.println("+-----------------------------------+");
						}
					} while (repete);

				}

				break;
			case 'N':
			case 'n':

				entrada.nextLine();
				cadastrarCliente(lj, entrada);
				break;
			}
		}
	}
}