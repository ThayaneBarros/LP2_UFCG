package estacionAqui;

/**
 * Classe que representa os comentarios.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class Comentarios {
	
	private String texto;
	private String autor;
	
	public Comentarios(String texto) {
		this.texto = texto;
		this.autor = "";
	}
	
	public Comentarios(String texto, String autor) {
		this.texto = texto;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public String getAutor() {
		return autor;
	}
	
}
