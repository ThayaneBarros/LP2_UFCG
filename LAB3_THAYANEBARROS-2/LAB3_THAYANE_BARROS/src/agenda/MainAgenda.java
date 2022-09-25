package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Classe que fornece a interface de interação com o usuario.
 * 
 * @author nazarenoandrade e Thayane Barros - 121110604
 *
 */
public class MainAgenda {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu (Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" +
						"(R)Remover Contato\n" +
						"(M)udar Telefone\n" +
						"(RE)mover Tags\n" +
						"(RF)Remover Favoritos\n" +
						"(EC)Exibir Contato pelo Nome/Sobrenome/Tag\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao Opção digitada.
	 * @param agenda A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "A":
			adicionarFavorito(agenda, scanner);
			break;
		case "F":
			listarFavoritos(agenda);
			break;
		case "T":
			adicionarTags(agenda, scanner);
			break;
		case "R":
			removerContato(agenda, scanner);
			break;
		case "M":
			mudarTelefone(agenda, scanner);
			break;
		case "RE":
			removerTags(agenda, scanner);
			break;
		case "RF":
			removerFavoritos(agenda, scanner);
			break;
		case "EC":
			exibeContatoPelosDados(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}	

	/**
	 * Cadastra um contato na agenda.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if(ehPosicaoValida(posicao)) {
			System.out.print("Nome> ");
			String nome = scanner.next().trim();
			System.out.print("Sobrenome> ");
			String sobrenome = scanner.next().trim();
			scanner.nextLine();
			System.out.print("Telefone> ");
			String telefone = scanner.nextLine().trim();
			
			try {
				boolean status = agenda.cadastraContato(posicao, nome, sobrenome, telefone);
				if(status) {
					System.out.println("CADASTRO REALIZADO");
				} else {
					System.out.println("CONTATO JA CADASTRADO");
				}	
			} catch (NullPointerException ae) {
				System.out.println("CONTATO INVALIDO");
			} catch (IllegalArgumentException ae) {
				System.out.println("CONTATO INVALIDO");
			}
			
		} else {
			System.out.print("POSIÇÃO INVÁLIDA");
		}	
	}
	
	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String contatos = agenda.getContatos();
		System.out.println(contatos);
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		if(ehPosicaoValida(posicao) && agenda.temContato(posicao)) {
			String contato = agenda.getContato(posicao);
			System.out.println("Dados do contato:\n" + contato);
		} else {
			System.out.println("POSIÇÃO INVÁLIDA");
		}
	}
	
	/**
	 * Adiciona um contato na lista de favoritos da agenda.
	 * 
	 * @param agenda a agenda a ser manipulada.
	 * @param scanner o scanner para pedir informações do contato.
	 */
	private static void adicionarFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosicao> ");
		int posicaoFavorito = scanner.nextInt();
		System.out.print("Contato> ");
		int contato = scanner.nextInt();
		if((posicaoFavorito > 0 && posicaoFavorito <= 10) && ehPosicaoValida(contato) && agenda.temContato(contato)) {
			System.out.println(agenda.adicionaFavorito(posicaoFavorito, contato));
		} else {
			System.out.print("POSIÇÃO INVÁLIDA");
		}
	}
	
	/**
	 * Imprime uma lista com os contatos favoritos da agenda.
	 * 
	 * @param agenda a agenda sendo manipulada.
	 */
	private static void listarFavoritos(Agenda agenda) {
		String contatos = agenda.getContatosFavoritos();
		System.out.println(contatos);	
	}
	
	/**
	 * Adiciona tags nos contatos.
	 * 
	 * @param agenda a agenda a ser manipulada.
	 * @param scanner o scanner para pedir informações do contato.
	 */
	private static void adicionarTags(Agenda agenda, Scanner scanner) {
		scanner.nextLine(); 
		System.out.print("\nContato(s)> ");
		String[] contato = scanner.nextLine().split(" ");
		System.out.print("Tag> ");
		String tag = scanner.next();
		System.out.print("Posicao tag> ");
		int posicaoTag = scanner.nextInt();
		
		for(int i = 0; i < contato.length; i++) {
			int posicaoContato = Integer.parseInt(contato[i]);
			if(ehPosicaoValida(posicaoContato) && (posicaoTag > 0 && posicaoTag <= 5)) {
				agenda.adicionaTag(posicaoContato, posicaoTag, tag);
			} else {
				System.out.print("POSIÇÃO INVÁLIDA");
			}
		}
	}
	
	/**
	 * Remove um contato da agenda.
	 * 
	 * @param agenda a agenda a ser manipulada.
	 * @param scanner o scanner para pedir informações do contato.
	 */
	private static void removerContato(Agenda agenda, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nContato(s)> ");
		String[] posicoes = scanner.nextLine().split(" ");
		
		for(int i = 0; i < posicoes.length; i++) {
			int posicao = Integer.parseInt(posicoes[i]);
			try {
				agenda.removerContato(posicao);
			} catch(NullPointerException ae) {
				System.out.println("POSIÇÃO INVÁLIDA!");
			} catch(ArrayIndexOutOfBoundsException ae) {
				System.out.println("CONTATO INVALIDO");
			}
		}	
	}
	
	/**
	 * Muda o numero de telefone de um contato
	 * 
	 * @param agenda a agenda a ser manipulada.
	 * @param scanner o scanner para pedir informações do contato.
	 */
	private static void mudarTelefone(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		if(ehPosicaoValida(posicao) && agenda.temContato(posicao)) {
			System.out.print("\nTelefone> ");
			String telefone = scanner.next();
			try {
				agenda.mudarTelefone(posicao, telefone);
			} catch(NullPointerException ae) {
				System.out.println("Numero de telefone invalido");
			} catch(IllegalArgumentException ae) {
				System.out.println("Numero de telefone invalido");
			}
		} else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Remove uma tag dos contatos da agenda
	 * 
	 * @param agenda a agenda a ser manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void removerTags(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicao = scanner.nextInt();
		if(ehPosicaoValida(posicao) && agenda.temContato(posicao)) {
			System.out.print("\nPosicao tag> ");
			int posicaoTag = scanner.nextInt();
			if(posicaoTag > 0 && posicaoTag <= 5) {
				agenda.removerTag(posicao, posicaoTag);
			} else {
				System.out.print("POSIÇÃO INVÁLIDA");
			}
		}
	}
	
	/**
	 * Remove um contato da lista de favoritos.
	 * 
	 * @param agenda a agenda a ser manipulada.
	 * @param scanner o scanner para pedir informações do contato.
	 */
	private static void removerFavoritos(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicao = scanner.nextInt();
		if(posicao > 0 && posicao <= 100) {
			agenda.removerFavorito(posicao);
		} else {
			System.out.print("POSIÇÃO INVÁLIDA");
		}
	}
	
	/**
	 * Apresenta a opção de exibir os contatos pelo nome, sobrenome ou tags.
	 * 
	 * @param agenda a agenda.
	 * @param scanner o scanner para pedir informações do contato.
	 */
	private static void exibeContatoPelosDados(Agenda agenda, Scanner scanner) {
		System.out.print(
				"\n---\nEXIBIR CONTATO PELO:\n" + 
						"(N)ome\n" + 
						"(S)obrenome\n" + 
						"(T)ag\n" +
						"Opção> ");
		
		String opcao = scanner.next().toUpperCase();
		while(true) {
			if(opcao.equals("N")) {
				System.out.print("\nNome> ");
				String nome = scanner.next().trim();
				exibeContatoPeloNome(agenda, nome);
				break;
			} else if(opcao.equals("S")) {
				System.out.print("\nSobrenome> ");
				String sobrenome = scanner.next().trim();
				exibeContatoPeloSobrenome(agenda, sobrenome);
				break;
			} else if(opcao.equals("T")){
				System.out.print("\nTag> ");
				String tag = scanner.next().trim();
				exibeContatoPelaTag(agenda, tag);
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA!");
			}
		}
	}
	
	/**
	 * Exibe uma lista com todos os contatos que apresentam o mesmo nome.
	 * 
	 * @param agenda a agenda.
	 * @param nome o nome a ser procurado.
	 */
	private static void exibeContatoPeloNome(Agenda agenda, String nome) {
		try {
			String contato = agenda.exibeContatoPeloNome(nome);
			System.out.println("Dados do contato:\n" + contato);
		} catch (NullPointerException ae) {
			System.out.println("CONTATO INVALIDO");
		} catch (IllegalArgumentException ae) {
			System.out.println("CONTATO INVALIDO");
		}
	}

	/**
	 * Exibe uma lista com todos os contatos que apresentam o mesmo sobrenome.
	 * 
	 * @param agenda a agenda.
	 * @param sobrenome o sobrenome a ser procurado.
	 */
	private static void exibeContatoPeloSobrenome(Agenda agenda, String sobrenome) {
		try {
			String contato = agenda.exibeContatoPeloSobrenome(sobrenome);
			System.out.println("Dados do contato:\n" + contato);
		} catch (NullPointerException ae) {
			System.out.println("CONTATO INVALIDO");
		} catch (IllegalArgumentException ae) {
			System.out.println("CONTATO INVALIDO");
		}	
	}
	
	/**
	 * Exibe uma lista com todos os contatos que apresentam a mesma tag.
	 * 
	 * @param agenda a agenda.
	 * @param tag a tag a ser procurada.
	 */
	private static void exibeContatoPelaTag(Agenda agenda, String tag) {
		try {
			String contato = agenda.exibeContatoPelaTag(tag);
			System.out.println("Dados do contato:\n" + contato);
		} catch (NullPointerException ae) {
			System.out.println("CONTATO INVALIDO");
		} catch (IllegalArgumentException ae) {
			System.out.println("CONTATO INVALIDO");
		}	
	}

	/**
	 * Verifica se a posição digitada pelo usuário para um contato é valida
	 * Para ser válida a posição necessita estar entre 1 e 100
	 * 
	 * @param posicao a posição informada pelo usuário.
	 * @return um booleano indicando se a posição  é válida ou não.
	 */
	private static boolean ehPosicaoValida(int posicao) {
		return posicao > 0 && posicao <= 100;
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}
	
	/**
	 * Lê uma agenda de um arquivo csv.
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}