package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

/**
 * Classe responsavel por testar os metodos da classe Contato
 * 
 * @author Thayane Barros - 121110604
 *
 */
class ContatoTest {

	private Contato contato1;
	private Contato contato2;
	private Contato contato3;

	@BeforeEach
	void criaContato() {
		this.contato1 = new Contato("Ouvidoria", "UFCG", "(83) 21011585");
		this.contato2 = new Contato("Coordenação", "Computacao", "(83) 99999-0000");
		this.contato3 = new Contato("Ouvidoria", "UFCG", "(81) 00009999");
	}
	
	@Test
	public void testContato() {
		contato1 = new Contato("Thayane", "Barros", "(83) 96154581");
	}
	
	@Test
	public void testContatoNomeVazio() {
		try {
			contato1 = new Contato("", "Barros", "(83) 96154581");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	public void testContatoNomeNulo() {
		try {
			contato1 = new Contato(null, "Barros", "(83) 96154581");
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	public void testContatoTelefoneVazio() {
		try {
			contato1 = new Contato("Thayane", "Barros", "");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	public void testContatoTelefoneNulo() {
		try {
			contato1 = new Contato("Thayane", "Barros", null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	public void testContatoNomeETelefoneVazio() {
		try {
			contato1 = new Contato("", "Barros", "");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	public void testContatoNomeETelefoneNulo() {
		try {
			contato1 = new Contato(null, "Barros", null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testEqualsFalse() {
		assertFalse(contato1.equals(contato2));
	}
	
	@Test
	void testEqualsTrue() {
		assertTrue(contato1.equals(contato3));
	}

	@Test
	void testGetNome() {
		assertEquals(contato1.getNome(), "Ouvidoria");
	}
	
	@Test
	void testGetSobrenome() {
		assertEquals(contato1.getSobrenome(), "UFCG");
	}
	
	@Test
	void testGetTags() {
		testAdicionaTagLimiteInferior();
		String saida = "UFCG";
		assertEquals(contato1.getTags(), saida);
	}
	
	@Test
	void testGetTagsSemTags() {
		assertEquals(contato1.getTags(), "");
	}
	
	@Test
	void testGetTagsCom2Tags() {
		testAdicionaTag2();
		String saida = "UFCG ccc";
		assertEquals(contato1.getTags(), saida);
	}
	
	@Test
	void testGetTagsComTagSobreescrita() {
		testAdicionaEmPosicaoOcupada();
		String saida = "ccc";
		assertEquals(contato1.getTags(), saida);
	}

	@Test
	void testToString() {
		String saida = "Ouvidoria UFCG";
		assertEquals(contato1.toString(), saida);
	}
	
	@Test
	void testToStringCompletaSemTags() {
		String saida = "Ouvidoria UFCG\n(83) 21011585";
		assertEquals(contato1.toStringCompleta(), saida);
	}
	
	@Test
	void testToStringCompletaComTags() {
		testAdicionaTag2();
		String saida = "Ouvidoria UFCG\n(83) 21011585\nUFCG ccc";
		assertEquals(contato1.toStringCompleta(), saida);
	}

	@Test
	void testAdicionaTagLimiteInferior() {
		this.contato1.adicionaTag(1, "UFCG");
	}
	
	@Test
	void testAdicionaTagLimiteSuperior() {
		this.contato1.adicionaTag(5, "Computação");
	}
	
	@Test
	void testAdicionaTagAcimaDeLimiteSuperior() {
		try {
			this.contato1.adicionaTag(6, "Computação");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testAdicionaTagAbaixoDeLimiteInferior() {
		try {
			this.contato1.adicionaTag(0, "Computação");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testAdicionaTag2() {
		this.contato1.adicionaTag(1, "UFCG");
		this.contato1.adicionaTag(4, "ccc");
	}
	
	@Test
	void testAdicionaEmPosicaoOcupada() {
		testAdicionaTagLimiteInferior();
		this.contato1.adicionaTag(1, "ccc");
	}
	
	@Test
	void testSetTelefone() {
		String telefone = "(83) 1111-9999";
		this.contato1.setTelefone(telefone );
	}
	
	@Test
	void testSetTelefoneComTelefoneVazio() {
		String telefone = "";
		try {
			this.contato1.setTelefone(telefone );
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testSetTelefoneComTelefoneNulo() {
		String telefone = null;
		try {
			this.contato1.setTelefone(telefone );
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testRemoveTagLimiteInferior() {
		testAdicionaTagLimiteInferior();
		this.contato1.removeTag(1);
	}
	
	@Test
	void testRemoveTagLimiteSuperior() {
		testAdicionaTagLimiteSuperior();
		this.contato1.removeTag(5);
	}
	
	@Test
	void testRemoveTagAbaixoLimiteInferior() {
		try {
			this.contato1.removeTag(0);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRemoveTagAcimaLimiteSuperior() {
		try {
			this.contato1.removeTag(6);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRemoveTagEmPosicaoSemTag() {
		this.contato1.removeTag(2);
	}
	
	@Test
	void testTemTagIdenticaTrue() {
		testAdicionaTagLimiteInferior();
		assertTrue(contato1.temTagIdentica("UFCG"));
	}
	
	@Test
	void testTemTagIdenticaFalse() {
		testAdicionaTagLimiteInferior();
		assertFalse(contato1.temTagIdentica("ccc"));
	}
}
