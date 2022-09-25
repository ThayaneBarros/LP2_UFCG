package lab02;

import java.util.Arrays;

/**
 * Classe responsável pela representação de uma disciplina a ser cursada por um estudante.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class Disciplina {
	
	private String nomeDaDisciplina;
	private int horasDeEstudo;
	private double[] notas; 
	private int[] pesos;
	
	/**
	 * Constrói uma disciplina a partir do nome.
	 * Cada disciplina começa com o campo de horas de estudo como nulo e o 
	 * peso se inicia com o valor 1. 
	 * 
	 * @param nomeDisciplina o nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.horasDeEstudo = 0;
		this.notas = new double[4];
		this.pesos = new int[4];
		for (int i = 0; i < 4; i++) {
			this.pesos[i] = 1;
		}
	}

	/**
	 * Constrói uma disciplina a partir do nome e da quantidade de notas.
	 * Cada disciplina começa com o campo de horas de estudo como nulo e o
	 * peso se inicia com o valor 1.
	 * 
	 * @param nomeDisciplina o nome da disciplina
	 * @param numNotas a quantidade de notas da disciplina
	 */
	public Disciplina(String nomeDisciplina, int numNotas) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.horasDeEstudo = 0;
		this.notas = new double[numNotas];
		this.pesos = new int[numNotas];
		for (int i = 0; i < numNotas; i++) {
			this.pesos[i] = 1;
		}
	}
	
	/**
	 * Constroi uma disciplina a partir do nome, quantidade de notas e peso de cada nota.
	 * 
	 * @param nomeDisciplina o nome da disciplina
	 * @param numNotas a quantidade de notas da disciplina
	 * @param pesos o peso de cada nota da disciplina
	 */
	public Disciplina(String nomeDisciplina, int numNotas, int[] pesos) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.horasDeEstudo = 0;
		this.notas = new double[numNotas];
		this.pesos = pesos;
	}
	
	/**
	 * Cadastra a quantidade de horas cursadas na disciplina.
	 * 
	 * @param horas as horas cursadas na disciplina
	 */
	public void cadastraHoras(int horas) {
		this.horasDeEstudo += horas;
	}

	/**
	 * Cadastra a nota da disciplina através da nota a ser cadastrada e o valor dessa nota.
	 * 
	 * @param nota a nota a ser modificada
	 * @param valorNota o novo valor da nota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Calcula e retorna a média das notas da disciplina.
	 * 
	 * @return a media das notas
	 */
	public double calculaMedia() {
		int somaPesos = 0;
		for(int i = 0; i < this.pesos.length; i++) {
			somaPesos += this.pesos[i];
		}
		double media = 0;
		for(int i = 0; i < this.notas.length; i++) {
			media += (this.notas[i] * this.pesos[i]) / somaPesos;
		}
		return media;
	}
	
	/**
	 * Verifica se o aluno foi aprovado. O aluno só será aprovado se
	 * a media for maior ou igual a 7.
	 * 
	 * @return um booleano indicando se o aluno foi aprovado ou não
	 */
	public boolean aprovado( ) {
		if(this.calculaMedia() >= 7) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna a String que representa a disciplina. A representação segue o
	 * formato NOME DA DISCIPLINA - HORAS DE ESTUDO - MEDIA - [NOTAS].
	 * 
	 * @return a representação em String da disciplina
	 */
	public String toString( ) {
		return this.nomeDaDisciplina + " " + this.horasDeEstudo + " " + this.calculaMedia() + " " + Arrays.toString(this.notas);
	}
}
