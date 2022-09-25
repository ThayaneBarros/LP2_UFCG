package agenda;

/**
 * Classe que representa um contato favoritado.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class ContatosFavoritos {
	
	/**
	 * Atributo responsavel pelo nome do contato do tipo string.
	 */
	String nome;
	/**
	 * Atributo responsavel pelo sobrenome do contato do tipo string.
	 */
	String sobrenome;
	
	/**
	 * Constroi um contato favorito a partir do nome e do sobrenome.
	 * Caso o nome seja vazio ou nulo será lançada uma exceção.
	 * 
	 * @param nome o nome do contato.
	 * @param sobrenome o sobrenome do contato.
	 */
	public ContatosFavoritos(String nome, String sobrenome) {
		if(nome == null) {
			throw new NullPointerException("Contato invalido");
		} else if(nome.equals("")) {
			throw new IllegalArgumentException("Contato invalido");
		}
		
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	/**
	 * Metodo que retorna um representação numérica que identifica o contato favorito.
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
	 * Metodo que comparar se dois objetos do tipo contato  são iguais.
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
		ContatosFavoritos other = (ContatosFavoritos) obj;
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
	 * Metodo que retorna uma representacao textual sobre o contato.
	 * 
	 * @return uma representacao textal contendo o nome e o sobrenome do contato.
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}

}