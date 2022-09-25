package estacionAqui;

/**
 * Classe que representa o estacionamento.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class Estacionamento {
	
	private Vagas[] vagas;
	private int vagasCadastradas;
	private Comentarios[] comentario;
	private int comentariosCadastrados;
	
	public Estacionamento() {
		this.vagas = new Vagas[100];
		this.vagasCadastradas = 0;
		this.comentario = new Comentarios[5];
		this.comentariosCadastrados = 0;
	}
	
	public int adicionarVagas(String endereco, double valorDaArea) {
		if(this.vagasCadastradas > 99) {
			throw new ArrayIndexOutOfBoundsException("Estacionamento Cheio");
		}
		
		this.vagas[vagasCadastradas] = new Vagas(endereco, valorDaArea, this.vagasCadastradas);
		return vagasCadastradas++;
	}
	
	public int adicionarVagas(String endereco, String link, double valorDaArea) {
		this.vagas[vagasCadastradas] = new Vagas(endereco, link, valorDaArea, this.vagasCadastradas);
		return vagasCadastradas++;
	}
	
	public void mudarStatus(int identificacao) {
		if(identificacao < 0 || identificacao > 99) {
			throw new IllegalArgumentException("ID Invalido");
		}
		
		this.vagas[identificacao].mudarStatus();
	}
	
	public double simularPreco(int identificacao, int horas) {
		if(identificacao < 0 || identificacao > 99) {
			throw new IllegalArgumentException("ID Invalido");
		} else if(horas < 0) {
			throw new IllegalArgumentException("Quantidade de horas invalida");
		}
		
		return this.vagas[identificacao].preco(horas);
	}
	
	public int vagaLivre() {
		for(int i = 0; i < this.vagas.length; i++) {
			if(this.vagas[i] != null && this.vagas[i].getStatus().equals("LIVRE")) {
				return i;
			}
		}
		return -1;
	}
	
	public String listarVagas() {
		String listaDeVagas = "";
		for(int i = 0; i < this.vagasCadastradas; i++) {
			listaDeVagas += this.vagas[i].toString() + "\n";
		}
		
		return listaDeVagas.trim();
	}
	
	public int vagasAtivas() {
		return this.vagasCadastradas;
	}
	
	public int buscaVagaLivrePorEnderecoEarea(String endereco, double area) {
		Vagas vagaProcurada = new Vagas(endereco, area, 0);
		for(int i = 0; i < this.vagas.length; i++) {
			if(this.vagas[i] != null && this.vagas[i].equals(vagaProcurada) && this.vagas[i].getStatus() == "LIVRE") {
				return i;
			}
		}
		return -1;
	}
	
	public String listaRelatorio() {
		String relatorio = "";
		
		for(int i = 0; i < this.vagasCadastradas; i++) {
			relatorio += "Vaga " + i + " - " + this.vagas[i].getStatusOcupada() + "\n";
		}
		return relatorio.trim();
	}
	
	public void adicionarComentario(String comentario) {
		if(this.comentariosCadastrados >= 5) {
			atualizaComentarios();
			this.comentariosCadastrados = 4;
		}
		this.comentario[comentariosCadastrados++] = new Comentarios(comentario);
	}
	
	public void adicionarComentario(String comentario, String autor) {
		if(this.comentariosCadastrados >= 5) {
			atualizaComentarios();
			this.comentariosCadastrados = 4;
		}
		this.comentario[comentariosCadastrados++] = new Comentarios(comentario, autor);
	}
	
	private void atualizaComentarios() {
		for(int i = 0; i < 4; i++) {
			this.comentario[i] = comentario[i + 1];
		}
	}
	
	public String listarComentarios() {
		String listaDeComentarios = "";
		
		for(int i = 0; i < this.comentario.length; i++) {
			if(this.comentario[i] != null) {
				listaDeComentarios += this.comentario[i].getTexto() + " (" + this.comentario[i].getAutor() + ")\n";
			}
		}
		
		return listaDeComentarios.trim();
	}
}
