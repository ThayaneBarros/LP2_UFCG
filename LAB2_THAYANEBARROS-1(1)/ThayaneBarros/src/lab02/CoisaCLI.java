package lab02;

import java.util.Scanner;

/**
 * Classe que oferece uma interface com interação com o usuário.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class CoisaCLI {
	
	/**
	 * Classe principal do programa.
	 * 
	 * @param args os argumentos passados ao invocar o programa
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String[] comando;
			Descanso descanso = new Descanso();
			RegistroTempoOnline tempo = new RegistroTempoOnline("");
			Disciplina disciplina = new Disciplina("");
			AtividadesComplementares minhasAtividades = new AtividadesComplementares();
			
			int sair = 0;
			while(sair == 0) {
				comando = sc.nextLine().split(" ");
				if (comando[0].equals("SAIR")) {
					sair = 1;
				} else {
					executaAcoes(comando, descanso, tempo, disciplina, minhasAtividades);
					System.out.println("-----");
				}	
			}
		}	
	}
	
	/**
	 * Executa os comandos passados pelo usuário da classe principal.
	 * 
	 * @param comando o camando e os argumentos passados
	 * @param descanso o objeto descanso que será manipulado caso invocado pelo usuário
	 * @param tempo o objeto de registro de tempo online que será manipulado caso invocado pelo usuário
	 * @param disciplina o objeto disciplina que será manipulado caso invocado pelo usuário
	 * @param minhasAtividades o objeto de atividades complementares que será manipulado caso invocado pelo usuário
	 */
	public static void executaAcoes(String[] comando, Descanso descanso, RegistroTempoOnline tempo, Disciplina disciplina, AtividadesComplementares minhasAtividades) {
		if(comando[0].equals("DESCANSO")) {
			executaAcoesDescanso(comando, descanso);
		} else if (comando[0].equals("TEMPOONLINE")) {
			executaAcoesTempo(comando, tempo);	
		} else if(comando[0].equals("CADASTRADISCIPLINA")) {
			executaAcoesDisciplina(comando, disciplina);		
		} else if (comando[0].equals("PROJETO")) {
			if(comando.length == 2) {
				minhasAtividades.adicionarProjeto(Integer.parseInt(comando[1]));
			} else {
				System.out.println("Número de argumentos invalidos");
			}
		} else if (comando[0].equals("ESTAGIO")) {
			if(comando.length == 2) {
				minhasAtividades.adicionarEstagio(Integer.parseInt(comando[1]));
			} else {
				System.out.println("Número de argumentos invalidos");
			}
		} else if (comando[0].equals("CURSO")) {
			if(comando.length == 2) {
				minhasAtividades.adicionarCurso(Double.parseDouble(comando[1]));
			} else {
				System.out.println("Número de argumentos invalidos");
			}
		} else {
			System.out.println("Comando não encontrado");
		}
	}
	
	/**
	 * Executa os comando passados pelo usuário referentes ao objeto descanso.
	 * 
	 * @param comando o camando e os argumentos passados
	 * @param descanso o objeto descanso que será manipulado
	 */
	public static void executaAcoesDescanso(String[] comando, Descanso descanso) {
		if(comando.length == 3) {
			if(comando[1].equals("HORAS")) {
				descanso.defineHorasDescanso(Integer.parseInt(comando[2]));
			} else if (comando[1].equals("SEMANAS")) {
				descanso.defineNumeroSemanas(Integer.parseInt(comando[2]));
			} else {
				System.out.println("Comando não encontrado");
			}
		} else if(comando.length == 2) {
			if (comando[1].equals("VERIFICARDESCANSO")) {
				System.out.println(descanso.getStatusGeral());
			} else {
				System.out.println("Comando não encontrado");
			}
		} else {
			System.out.println("Número de argumentos invalidos");
		}
	}
	
	/**
	 * Executa os comando passados pelo usuário referentes ao objeto tempo.
	 * 
	 * @param comando o camando e os argumentos passados
	 * @param tempo o objeto tempo que será manipulado
	 */
	public static void executaAcoesTempo(String[] comando, RegistroTempoOnline tempo) {
		if(comando.length == 3) {
			if(comando[1].equals("HORAS")) {
				tempo.adicionaTempoOnline(Integer.parseInt(comando[2]));
			} else {
				System.out.println("Comando não encontrado");
			}
		} else if(comando.length == 2) {
			if(comando[1].equals("VERIFICARTEMPO")) {
				System.out.println(tempo.atingiuMetaTempoOnline());
			} else if(comando[1].equals("ESTADO")) {
				System.out.println(tempo.toString());
			} else {
				System.out.println("Comando não encontrado");
			}
		} else {
			System.out.println("Número de argumentos invalidos");
		}
	}
	
	/**
	 * Executa os comando passados pelo usuário referentes ao objeto disciplina.
	 * 
	 * @param comando o camando e os argumentos passados
	 * @param disciplina o objeto disciplina que será manipulado
	 */
	public static void executaAcoesDisciplina(String[] comando, Disciplina disciplina) {
		if(comando.length == 3) {
			if(comando[1].equals("HORAS")) {
				disciplina.cadastraHoras(Integer.parseInt(comando[2]));
			} else {
				System.out.println("Comando não encontrado");
			}
		} else if (comando.length == 4) {
			if(comando[1].equals("NOTA")) {
				disciplina.cadastraNota(Integer.parseInt(comando[2]), Double.parseDouble(comando[3]));
			} else {
				System.out.println("Comando não encontrado");
			}
		} else if (comando.length == 1) {
			if(comando[1].equals("VERIFICARAPROVAÇÃO")) {
				System.out.println(disciplina.aprovado());
			} else {
				System.out.println("Comando não encontrado");
			}
		} else {
			System.out.println("Número de argumentos invalidos");
		}
	}
}
