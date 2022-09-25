package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.ContatosFavoritos;

/**
 * Classe responsavel por testar os metodos da classe ContatosFavoritos
 * 
 * @author Thayane Barros - 121110604
 *
 */
class ContatosFavoritosTest {

	private ContatosFavoritos contato1;
	private ContatosFavoritos contato2;
	private ContatosFavoritos contato3;
	private ContatosFavoritos contato4;
	
	@BeforeEach
	void criaContato() {
		this.contato1 = new ContatosFavoritos("Ouvidoria", "UFCG");
		this.contato2 = new ContatosFavoritos("Ouvidoria", "UFCG");
		this.contato3 = new ContatosFavoritos("Thayane", "UFCG");
		this.contato4 = new ContatosFavoritos("Ouvidoria", "ccc");
	}
	
	@Test
	public void testContatosFavoritos() {
		contato1 = new ContatosFavoritos("Thayane", "Barros");
	}
	
	@Test
	public void testContatosFavoritosNomeVazio() {
		try {
			contato1 = new ContatosFavoritos("", "Barros");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	public void testContatosFavoritosNomeNulo() {
		try {
			contato1 = new ContatosFavoritos(null, "Barros");
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testEqualsFalse() {
		assertFalse(contato1.equals(contato3));
		assertFalse(contato1.equals(contato4));
	}

	@Test
	void testEqualsTrue() {
		assertTrue(contato1.equals(contato2));
	}
	
	@Test
	void testToString() {
		String saida = "Ouvidoria UFCG";
		assertEquals(contato1.toString(), saida);
	}

}
