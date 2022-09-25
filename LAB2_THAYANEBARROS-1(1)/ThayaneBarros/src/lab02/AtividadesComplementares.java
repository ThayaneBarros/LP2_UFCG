package lab02;

/**
 * Classe responsável pela implementação de atividades complementares(projetos,cursos e estágios)
 * de um aluno.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class AtividadesComplementares {
	
	private int[] horasEstagio;
	private int[] mesesEstagio;
	private int[] mesesProjeto;
    private double horasCurso;
    private int estagioCadastrados;
    private int projetoCadastrados;
 
    /**
     * Constrói as atividades complementares.Todos os atributos começam nulos.
     */
    public AtividadesComplementares() {
    	this.horasEstagio = new int[9];
    	this.mesesEstagio = new int[9];
    	this.mesesProjeto = new int[16];
    	this.horasCurso = 0;
    	this.estagioCadastrados = 0;
    	this.projetoCadastrados = 0;
    }
	
    /**
     * Cadastra a quantidade de horas que durou um estágio. Por padrão os meses serão cadastrados com o valor 4.
     * 
     * @param horas a quantidade de horas a ser cadastrada
     */
	public void adicionarEstagio(int horas) {
		this.mesesEstagio[estagioCadastrados] = 4;
		this.horasEstagio[estagioCadastrados++] = horas;
	}
 
	/**
	 * Cadastra a quantidade de horas e meses que durou um estágio.
	 * 
	 * @param horas a quantidade de horas a ser cadastrada
	 * @param meses a quantidade de meses a ser cadastrada
	 */
	public void adicionarEstagio(int horas, int meses) {
		this.mesesEstagio[estagioCadastrados] = meses;
		this.horasEstagio[estagioCadastrados++] = horas;
	}
	
	/**
	 * Cadastra a quantidade de meses que durou um projeto.
	 * 
	 * @param meses a quantidade de meses a ser cadastrada
	 */
	public void adicionarProjeto(int meses) {
		this.mesesProjeto[projetoCadastrados++] = meses;
	}
	
	/**
	 * Adiciona a quantidade de horas cursadas em um curso.
	 * 
	 * @param horas a quantidade de horas de cada curso
	 */
	public void adicionarCurso(double horas) {
		this.horasCurso += horas;
	}

	/**
	 * Calcula a quantidade de créditos obtidos de todas as atividades complementares.
	 * 
	 * @return a quantidade total de créditos obtidos das atividades complementares
	 */
	public int contaCreditos() {
		return this.creditosEstagio() + this.creditosProjeto() + this.creditosCurso();
	}
	
	/**
	 * Calcula a quantidade de créditos de um estágio.
	 * 
	 * @return a quantidade de créditos de um estágio
	 */
	public int creditosEstagio() {
		int somaHoras = 0, somaMeses = 0, somaCredito = 0;
		for(int i = 0; i < this.estagioCadastrados; i++) {
			somaHoras = (int) this.horasEstagio[i] / 300;
			somaMeses = (int) this.mesesEstagio[i] / 4;
			
			if(somaHoras <= somaMeses) {
				somaCredito += somaHoras * 5;
			} else {
				somaCredito += somaMeses * 5;
			}
		}		
		return somaCredito;
	}
	
	/**
	 * Calcula a quantidade de créditos de um projeto.
	 * 
	 * @return a quantidade de créditos de um projeto
	 */
	public int creditosProjeto() {
		int somaCredito = 0;
		for(int i = 0; i < this.projetoCadastrados; i++) {
			somaCredito += ((int) this.mesesProjeto[i] / 3) * 2;
		}
		return somaCredito;
	}
	
	/**
	 * Calcula a quantidade de créditos dos cursos.
	 * 
	 * @return a quantidade de créditos dos cursos
	 */
	public int creditosCurso() {
			return (int) this.horasCurso / 30;
		}
	
	/**
	 * Retorna um array de Strings representando todas as atividades cadastradas. Cada linha 
	 * representa respectivamente os estágio cadastrado e o total de horas de cada um deles, seguida 
	 * por cada projeto com seu total de meses, e o curso com seu total de horas. As 3 linhas finais 
	 * são os totais de créditos obtidos dos estágios, dos projetos e dos cursos, respectivamente. 
	 * 
	 * @return um array de Strings de todas as atividades cadastradas
	 */
	public String[] pegaAtividades() {
		String[] atividades = new String[this.estagioCadastrados + this.projetoCadastrados + 4];
		int indice = 0;
		for(int i = 0; i < this.estagioCadastrados; i++) {
			atividades[indice++] = "Estagio " + this.horasEstagio[i] + " " + this.mesesEstagio[i];
		}
		for(int i = 0; i < this.projetoCadastrados; i++) {
			atividades[indice++] = "Projeto " + this.mesesProjeto[i];
		}
		atividades[indice++] = "Cursos " + this.horasCurso;
		atividades[indice++] = "Creditos_Estagio " + this.creditosEstagio();
		atividades[indice++] = "Creditos_Projeto " + this.creditosProjeto();
		atividades[indice++] = "Creditos_Cursos " + this.creditosCurso();
		
		return atividades;
	}
}
