package lab02;

/**
 * Classe responsável pela implementação do registro do tempo gasto online para se dedicar
 * a uma disciplina.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class RegistroTempoOnline {
	
	private String nomeDaDisciplina;
	private int tempoGastoOnline; 
	private int tempoOnlineEsperado;

	/**
	 * Constrói um registro de tempo online a partir do nome da disciplina.
	 * Cada registro de tempo online começa com o campo de tempo gasto online como nulo
	 * e por padrão o tempo online esperado se inicia com 120.
	 * 
	 * @param nomeDisciplina o nome da disciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.tempoGastoOnline = 0;
		this.tempoOnlineEsperado = 120;	
	}

	/**
	 * Constrói um registro de tempo online a partir do nome da disciplina e do tempo online esperado.
	 * Cada registro de tempo online começa com o campo de tempo gasto online como nulo.
	 * 
	 * @param nomeDisciplina o nome da disciplina
	 * @param tempoOnlineEsperado a quantidade de horas online esperada para a disciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.tempoGastoOnline = 0;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Adiciona a quantidade de tempo gasto online.
	 * 
	 * @param tempo a quantidade de tempo online gasto
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoGastoOnline += tempo;
	}

	/**
	 * Verifica se o aluno atingiu o tempo esperado para a disciplina.
	 * 
	 * @return um booleano indicando se atingiu a meta do tempo online esperado ou não
	 */
	public boolean atingiuMetaTempoOnline() {
		if(this.tempoGastoOnline >= this.tempoOnlineEsperado) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna a String que representa o registro de tempo online. A representação segue o
	 * formato NOME DA DISCIPLINA - TEMPO GASTO ONLINE - TEMPO ONLINE ESPERADO.
	 * 
	 * @return a representação em String do registro de tempo online
	 */
	public String toString() {
		return this.nomeDaDisciplina + " " + this.tempoGastoOnline + "/" + this.tempoOnlineEsperado;
	}
}