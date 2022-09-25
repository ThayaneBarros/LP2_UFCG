package agenda;

/**
 * Classe que representa um contato.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class Contato {
	
	/**
	 * Atributo responsavel pelo nome do contato do tipo string.
	 */
	private String nome;
	/**
	 * Atributo responsavel pelo sobrenome do contato do tipo string.
	 */
	private String sobrenome;
	/**
	 * Atributo responsavel pelo telefone do contato do tipo string.
	 */
	private String telefone;
	/**
	 * Array de tags do tipo string responsável por guardar as tags do contato.
	 */
	private String[] tags;
	
	/**
	 * Constroi um contato a partir do nome, sobrenome e telefone.
	 * Cada contato começa com o arrays de tags com 5 posições.
	 * Caso algum dos parâmetros invocados seja vazio ou nulo será lançada uma exceção.
	 * 
	 * @param nome o nome do contato.
	 * @param sobrenome o sobrenome do contato.
	 * @param telefone o telefone do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if(nome == null|| telefone == null ) {
			throw new NullPointerException("Contato invalido");
		} else if(nome.equals("") || telefone.equals("")) {
			throw new IllegalArgumentException("Contato invalido");
		}
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;	
		this.tags = new String[5]; 
	}

	/**
	 * Metodo que retorna um representação numérica que identifica o contato. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	/**
	 * Metodo que comparar se dois objetos do tipo contato são iguais. 
	 * Eles serão considerados iguais se possuirem o mesmo nome e sobrenome. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	/**
	 * Metodo que retorna o nome do contato.
	 * 
	 * @return o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo que retorna o sobrenome do contato.
	 * 
	 * @return o  sobrenome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Metodo que lista todas as tags cadastradas no contato.
	 * 
	 * @return uma representação em string com todas as tags cadastradas separadas por espaço.
	 */
	public String getTags() {
		String listaTags = "";
		for(int i = 0; i < tags.length; i++) {
			if(tags[i] != null) {
				listaTags += tags[i] + " ";
			}
		}
		return listaTags.trim();
	}

	/**
	 * Metodo que retorna uma representacao textual sobre o contato.
	 * 
	 * @return uma representacao textal contendo o nome e o sobrenome do contato.
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}
	
	/**
	 * Metodo que retorna uma representacao textual completa sobre o contato.
	 * 
	 * @return uma representacao textal contendo o nome, sobrenome, telefone e tags do contato(caso o contato possuir tags).
	 */
	public String toStringCompleta() {
		return (this.nome + " " + this.sobrenome + "\n" + this.telefone + "\n" + getTags()).trim();
	}

	/**
	 * Adiciona uma tag em uma determinada posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * Uma posição válida está entre 1 a 5, caso informado uma posição inválida será lançada uma exceção.
	 * 
	 * @param posicaoTag a posição da tag no array.
	 * @param tag a tag a ser adicionada.
	 */
	public void adicionaTag(int posicaoTag, String tag) {
		if(posicaoTag < 1 || posicaoTag > 5) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		}
		this.tags[posicaoTag - 1] = tag;
	}

	/**
	 * Metodo que modifica o numero de telefone do contato.
	 * Caso seja informado um telefone nulo ou vazio será lançada uma exceção.
	 * 
	 * @param telefone a nova representação em string do telefone.
	 */
	public void setTelefone(String telefone) {
		if(telefone == null) {
			throw new NullPointerException("Numero de telefone invalido");
		} else if(telefone.trim().equals("")) {
			throw new IllegalArgumentException("Numero de telefone invalido");
		}
		this.telefone = telefone;
	}
	
	/**
	 * Remove uma tag de uma determinada posição.
	 * 
	 * @param posicaoTag a posição da tag a ser removida.
	 */
	public void removeTag(int posicaoTag) {
		if(posicaoTag < 1 || posicaoTag > 5) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		}
		this.tags[posicaoTag - 1] = null;
	}

	/**
	 * Verifica se o contato possui uma determinada tag especificada pelo usuario.
	 * 
	 * @param tag a tag a ser procurada.
	 * @return um booleano indicando se contato possui a tag ou não.
	 */
	public boolean temTagIdentica(String tag) {
		for(int i = 0; i < this.tags.length; i++) {
			if(this.tags[i] != null && this.tags[i].equals(tag)) {
				return true;
			}
		}
		return false;
	}
	
}