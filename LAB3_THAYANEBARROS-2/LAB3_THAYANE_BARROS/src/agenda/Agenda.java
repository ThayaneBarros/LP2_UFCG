package agenda;

/**
 * Classe que representa uma agenda responsável por gerenciar todos os contatos.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class Agenda {
	
	/**
	 * Array contatos do tipo contato responsável por guardar os contatos
	 */
	private Contato[] contatos;
	/**
	 * Array contatosFavoritos do tipo contatosFavoritos responsável por guardar os contatos favoritados da agenda.
	 */
	private ContatosFavoritos[] contatosFavoritos;

	/**
	 * Cria uma agenda.
	 * Toda agenda se inicializa com o array de contatos de 100 posições e o array de contatos favoritos com 10 posições.
	 */
	public Agenda() {
		this.contatos = new Contato[100];;
		this.contatosFavoritos = new ContatosFavoritos[10];
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * Uma posição válida está entre 1 a 100, caso informado uma posição inválida ou algum dos parâmetros 
	 * invocados seja vazio ou nulo será lançada uma exceção.
	 * 
	 * @param posicao a posição do contato
	 * @param nome o nome do contato
	 * @param sobrenome o sobrenome do contato
	 * @param telefone o telefone do contato
	 * @return um booleano true indicando que o contato foi cadastrado ou false caso já exista um contato identico cadastrado.
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if(posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		} else if(nome == null || telefone == null) {
			throw new NullPointerException("Contato invalido");
		} else if(nome.trim().equals("")|| telefone.trim().equals("")) {
			throw new IllegalArgumentException("Contato invalido");
		}
		
		Contato contato = new Contato(nome, sobrenome, telefone);
		if(!(temContatoIdentico(contato))) {
			this.contatos[posicao - 1] = contato;
			return true;
		} else {
			return false;
		}	
	}
	
	/**
	 * Verifica se um contato já está cadastrado.
	 * 
	 * @param contato o contato a ser verificado
	 * @return um booleano indicando se o contato já esta cadastrado ou não
	 */
	private boolean temContatoIdentico(Contato contato) {
		for(int i = 0; i < this.contatos.length; i++) {
			if(this.contatos[i] != null && this.contatos[i].equals(contato)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Acessa os dados de um contato específico através de sua posição.
	 * Uma posição válida está entre 1 a 100, caso informado uma posição nula ou inválida será lançada uma exceção.
	 * 
	 * @param posicao a posição do contato na agenda
	 * @return Dados do contato
	 */
	public String getContato(int posicao) {
		if(posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		} else if(!(temContato(posicao))) {
			throw new NullPointerException("Não há contato nesta posição!");
		}
		
		if(temFavoritos(posicao)) {
			return "❤️ " + this.contatos[posicao - 1].toStringCompleta();
		} else {
			return this.contatos[posicao - 1].toStringCompleta();
		}
	}
	
	/**
	 * Verifica se um contato já existe na lista de favoritos.
	 * 
	 * @param posicao a posicao do contato na lista de contatos
	 * @return um booleano indicando se o contato já esta cadastrado em contatos favoritos ou não.
	 */
	private boolean temFavoritos(int posicao) {
		ContatosFavoritos favoritos = new ContatosFavoritos(this.contatos[posicao - 1].getNome(), this.contatos[posicao - 1].getSobrenome());
		for(int i = 0; i < this.contatosFavoritos.length; i++) {
			if(this.contatosFavoritos[i] != null && this.contatosFavoritos[i].equals(favoritos)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Acessa e retorna a lista de contatos mantida.
	 * 
	 * @return uma representação em string com a lista dos contatos cadastrados e suas posições.
	 */
	public String getContatos() {
		String listaDeContatos = "";
		for(int i = 0; i < this.contatos.length; i++) {
			if(this.contatos[i] != null) {
				listaDeContatos += (i + 1) + " - " + this.contatos[i].toString() + "\n";
			}
		}
		return listaDeContatos.trim();
	}
	
	/**
	 * Adiciona um contato na lista de favoritos através de uma determinada posição.
	 * Uma posição válida está entre 1 a 10, caso informado uma posição inválida ou um contato nulo será lançada uma exceção.
	 * 
	 * @param posicao a posição do contato na lista de favoritos
	 * @param contato a posição do contato na lista de contatos
	 * @return uma representação em string informando se o contato foi cadastrado ou se já existe um contato identico cadastrado na lista de favoritos.
	 */
	public String adicionaFavorito(int posicao, int contato) {
		if(posicao < 1 || posicao > 10 || contato < 1 || contato > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		} else if(!(temContato(contato))) {
			throw new NullPointerException("Não há contato nesta posição!");
		}
		
		if(!(temFavoritos(contato))) {
			this.contatosFavoritos[posicao - 1] = new ContatosFavoritos(this.contatos[contato - 1].getNome(), this.contatos[contato - 1].getSobrenome());
			return "CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!";
		}
		return "CONTATO JA CADASTRADO NA LISTA DE FAVORITOS";
	}
	
	/**
	 * Acessa e lista todos os contatos cadastrados na lista de contatos favoritos.
	 * 
	 * @return uma representação em string com a lista dos contatos favoritados e suas posições.
	 */
	public String getContatosFavoritos() {
		String listaDeContatosFavoritos = "";
		for(int i = 0; i < this.contatosFavoritos.length; i++) {
			if(this.contatosFavoritos[i] != null) {
				listaDeContatosFavoritos += (i + 1) + " - " + this.contatosFavoritos[i].toString() + "\n";
			}
		}
		return listaDeContatosFavoritos.trim();
	}

	/**
	 * Adiciona tags nos contatos em uma determinada posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * Uma posição válida está entre 1 a 5, caso informado uma posição inválida será lançada uma exceção.
	 * 
	 * @param posicaoContato a posição do contato
	 * @param posicaoTag a posição da tag
	 * @param tag a tag a ser adicionada
	 */
	public void adicionaTag(int posicaoContato, int posicaoTag, String tag) {
		if(posicaoTag < 1 || posicaoTag > 5 || posicaoContato < 1 || posicaoContato > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		}
		
		if(temContato(posicaoContato)) {
			this.contatos[posicaoContato - 1].adicionaTag(posicaoTag, tag);
		}
	}
	
	/**
	 * Remove um contato de uma determinada posição. Se este contato também estiver na lista de favoritos, ele também será removido desta lista.
	 * 
	 * @param posicao a posição do contato a ser removido
	 */
	public void removerContato(int posicao) {
		if(posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		} else if(!(temContato(posicao))) {
			throw new NullPointerException("Posição inválida");
		}
		
		if(temFavoritos(posicao)) {
			removerFavorito(posicao);
		} 
		this.contatos[posicao - 1] = null;	
	}
	
	/**
	 * Verifica se existe algum contato cadastrado em uma determinada posição do array.
	 * 
	 * @param posicao a posição do array a ser verificado.
	 * @return um booleano indicando se existe um contato cadastrado na posição informada ou não.
	 */
	public boolean temContato(int posicao) {
		if(this.contatos[posicao - 1] == null) {
			return false;
		} 
		return true;
	}

	/**
	 * Metodo para mudar o telefone do contato.
	 * 
	 * @param posicao a posicao do contato
	 * @param telefone o telefone a ser modificado
	 */
	public void mudarTelefone(int posicao, String telefone) {
		if(posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		} else if(telefone == null) {
			throw new NullPointerException("Numero de telefone invalido");
		} else if(telefone.trim().equals("")) {
			throw new IllegalArgumentException("Numero de telefone invalido");
		}
		
		if(temContato(posicao)) {
			this.contatos[posicao - 1].setTelefone(telefone);
		}
	}

	/**
	 * Remove uma tag do contato.
	 * 
	 * @param posicao a posição do contato
	 * @param posicaoTag a posição da tag no contato
	 */
	public void removerTag(int posicao, int posicaoTag) {
		if(posicao < 1 || posicao > 100 || posicaoTag < 1 || posicaoTag > 5) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		}
		
		if(temContato(posicao)) {
			this.contatos[posicao - 1].removeTag(posicaoTag);
		}
	}

	/**
	 * Remove um contato da lista de favoritos.
	 * 
	 * @param posicao a posicao do contato.
	 */
	public void removerFavorito(int posicao) {
		if(posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição inválida");
		}
		
		ContatosFavoritos favoritos = new ContatosFavoritos(this.contatos[posicao - 1].getNome(), this.contatos[posicao - 1].getSobrenome());
		for(int i = 0; i < this.contatosFavoritos.length; i++) {
			if(this.contatosFavoritos[i] != null && this.contatosFavoritos[i].equals(favoritos)) {
				this.contatosFavoritos[i] = null;
			}
		}	
	}

	/**
	 * Exibe uma lista de todos os contatos que apresentam o mesmo nome especificado pelo usuario.
	 * 
	 * @param nome o nome do contato.
	 * @return uma representacao textual contendo todos os contatos que apresentam o mesmo nome e suas posições.
	 */
	public String exibeContatoPeloNome(String nome) {
		if(nome == null) {
			throw new NullPointerException("Contato invalido");
		} else if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Contato invalido");
		}
		
		String listaContatos = "";
		for(int i = 0; i < this.contatos.length; i++) {
			if(this.contatos[i] != null && this.contatos[i].getNome().equals(nome)) {
				listaContatos += (i + 1) + " - " + this.contatos[i].toString() + "\n";
			} 
		}
		return listaContatos.trim();
	}
	
	/**
	 * Exibe uma lista de todos os contatos que apresentam o mesmo sobrenome especificado pelo usuario.
	 * 
	 * @param sobrenome o sobrenome do contato.
	 * @return uma representacao textual contendo todos os contatos que apresentam o mesmo sobrenome e suas posições.
	 */
	public String exibeContatoPeloSobrenome(String sobrenome) {	
		String listaContatos = "";
		for(int i = 0; i < this.contatos.length; i++) {
			if(this.contatos[i] != null && this.contatos[i].getSobrenome().equals(sobrenome)) {
				listaContatos += (i + 1) + " - " + this.contatos[i].toString() + "\n";
			} 
		}
		return listaContatos.trim();
	}

	/**
	 * Exibe uma lista de todos os contatos que apresentam a mesma tag especificado pelo usuario.
	 * 
	 * @param tag a tag do contato
	 * @return uma representacao textual contendo todos os contatos que apresentam a mesma tag e suas posições.
	 */
	public String exibeContatoPelaTag(String tag) {
		String listaContatos = "";
		for(int i = 0; i < this.contatos.length; i++) {
			if(this.contatos[i] != null && this.contatos[i].temTagIdentica(tag)) {
				listaContatos += (i + 1) + " - " + this.contatos[i].toString() + "\n";
			} 
		}
		return listaContatos.trim();
	}
}