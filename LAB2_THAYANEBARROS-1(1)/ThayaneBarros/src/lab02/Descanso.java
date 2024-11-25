package lab02;

/**
 * Classe responsável pela implementação das horas de descanso de um aluno.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class Descanso {

	private int horasDeDescanso;
	private int numerosDeSemana;
	private String emoji;
	private String humor;
	private int unusedField;
	
	/**
	 * Constrói o descanso.
	 * Todo aluno começa com o campo horas de descanso como nulo, os números da semana com o valor 1
	 * e por padrão começa com o humor cansado.
	 * 
	 */
	public Descanso() {
		this.horasDeDescanso = 0;
		this.numerosDeSemana = 1;
		this.emoji = "";
		this.humor = "cansado";
	}
	
	/**
	 * Define as horas de descanso do  aluno.
	 * 
	 * @param valor as horas de descanso do aluno
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDeDescanso = valor;
		verificaMudancaDeHumor();
	}
	
	/**
	 * Define a quantidade de semanas utilizadas pelo aluno.
	 * 
	 * @param valor a quantidade de semanas utilizadas pelo aluno
	 */
	public void defineNumeroSemanas(int valor) {
		this.numerosDeSemana = valor;
		verificaMudancaDeHumor();
	}
	
	/**
	 * Define o emoji que representa o sentimento do aluno.
	 * 
	 * @param valor um emoji representando o sentimento do aluno
	 */
	public void definirEmoji(String valor) {
		this.emoji = "-" + valor;
	}
	
	/**
	 * Retorna uma representação do status geral do aluno chamando um método que retorna se o aluno
	 * esta cansado ou descando e adicionando um emoji, caso este tenta sido definido pelo aluno.
	 * 
	 * @return uma String representando se o aluno está cansado ou descansado juntamente com um emoji
	 * que descreve o seu sentimento caso este tenha sido definido.
	 */
	public String getStatusGeral() {
		return estadoDeDescanso() + this.emoji;
	}
	
	/**
	 * Retorna uma representação do estado de descanso do aluno.
	 * 
	 * @return uma String representando se o aluno está cansado ou descansado
	 */
	private String estadoDeDescanso() {
		if(this.horasDeDescanso / this.numerosDeSemana >= 26) {
			return "descansado";
		} else {
			return "cansado";
		}
	}
	
	/**
	 * Verifica se houve uma mudança no estado de disposição do aluno. Se houver uma mudança
	 * o método atualiza o seu humor.
	 */
	private void verificaMudancaDeHumor() {
		String novoHumor = estadoDeDescanso();
		if(!this.humor.equals(novoHumor)) {
			this.humor = novoHumor;
			this.emoji = "";
		} 
	}
}