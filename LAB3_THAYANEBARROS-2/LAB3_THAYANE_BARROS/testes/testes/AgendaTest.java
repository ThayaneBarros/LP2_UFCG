package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import agenda.Agenda;

/**
 * Classe responsavel por testar os metodos da classe Agenda
 * 
 * @author Thayane Barros - 121110604
 *
 */
class AgendaTest {
	
	/**
	 * @param agenda1 do tipo agenda 
	 */
	private Agenda agenda1;
	/**
	 * @param agenda2 do tipo agenda
	 */
	private Agenda agenda2;
	/**
	 * @param agenda3 do tipo agenda
	 */
	private Agenda agenda3;
	
	/**
	 * Metodo que irá criar todos objetos do tipo agenda.
	 */
	@BeforeEach
	void criaAgenda() {
		this.agenda1 = new Agenda();
		this.agenda2 = new Agenda();
		this.agenda3 = new Agenda();
		
		/**
		 * Cadastramento de alguns objetos do tipo Contato.
		 */
		this.agenda1.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda1.cadastraContato(22, "Fabio", "Moraes", "(94) 8641-0000");
		this.agenda3.cadastraContato(1, "Thiago", "Silva", "(83) 9869-0093");
		this.agenda3.cadastraContato(100, "Thierry", "Silva", "(83) 0000-0093");
		
	}

	@Test
	void testCadastraContatoLimiteInferior() {
		this.agenda1.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
	}
	
	@Test
	void testCadastraContatoLimiteSuperior() {
		this.agenda1.cadastraContato(100, "Matheus", "Gaudencio", "(83) 9999-0000");
	}
	
	@Test
	void testCadastraContatoAcimaLimiteSuperior() {
		try {
			this.agenda1.cadastraContato(101, "Matheus", "Gaudencio", "(83) 9999-0000");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testCadastraContatoAbaixoLimiteInferior() {
		try {
			this.agenda1.cadastraContato(0, "Matheus", "Gaudencio", "(83) 9999-0000");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testCadastraContatoEmPosicaoExistente() {
		this.agenda1.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111");
	}
	
	@Test
	void testCadastraContatoExistente() {
		assertEquals(this.agenda1.cadastraContato(3, "Matheus", "Gaudencio", "(83) 9999-1111"), false);
	}
	
	@Test
	void testCadastraContatoComNomeIdentico() {
		this.agenda1.cadastraContato(5, "Matheus", "UFCG", "(83) 9999-1111");
	}
	
	@Test
	void testCadastraContatoComSobrenomeIdentico() {
		this.agenda1.cadastraContato(5, "UFCG", "Gaudencio", "(83) 9999-1111");
	}
	
	@Test
	void testCadastraContatoIdenticoComLetrasMaiusculas() {
		this.agenda1.cadastraContato(5, "MATHEUS", "GAUDENCIO", "(83) 9999-1111");
	}
	
	@Test
	void testCadastraContatoComTelefoneVazio() {
		try {
			this.agenda1.cadastraContato(1, "Matheus", "Gaudencio", "");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testCadastraContatoTelefoneNulo() {
		try {
			this.agenda1.cadastraContato(1, "Matheus", "Gaudencio", null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testCadastraContatoNomeVazio() {
		try {
			this.agenda1.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testCadastraContatoNomeNulo() {
		try {
			this.agenda1.cadastraContato(1, null, "Gaudencio", "(83) 99999-0000");
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
		
	@Test
	void testGetContato() {
		String saida = "Matheus Gaudencio\n(83) 99999-0000";
		assertEquals(this.agenda1.getContato(1), saida);
	}
	
	@Test
	void testGetContatoComContatoInvalido() {
		try {
			this.agenda1.getContato(100);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}

	@Test
	void testGetContatoEmPosicaoInvalidaAcimaDoLimiteSuperior() {
		try {
			this.agenda1.getContato(101);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testGetContatoEmPosicaoInvalidaAbaixoDoLimiteInferior() {
		try {
			this.agenda1.getContato(0);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testGetContatoComFavorito() {
		testAdicionaFavoritoLimiteInferior();
		String saida = "❤️ Matheus Gaudencio\n(83) 99999-0000";
		assertEquals(this.agenda1.getContato(1), saida);
	}
	
	@Test
	void testGetContatoComTags() {
		testAdicionaTagLimiteInferior();
		String saida = "Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg";
		assertEquals(this.agenda1.getContato(1), saida);
		
	}
	
	@Test
	void testGetContatoCom2Tags() {
		testAdicionaSegundaTag();
		String saida = "Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg ccc";
		assertEquals(this.agenda1.getContato(1), saida);	
	}
	
	@Test
	void testGetContatoComTagsSobreescrita() {
		testAdicionaTagEmPosicaoOcupada();
		String saida = "Matheus Gaudencio\n(83) 99999-0000\nccc";
		assertEquals(this.agenda1.getContato(1), saida);	
	}
	
	@Test
	void testGetContatoComTagsEFavoritos() {
		testAdicionaFavoritoLimiteInferior();
		testAdicionaTagLimiteInferior();
		String saida = "❤️ Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg";
		assertEquals(this.agenda1.getContato(1), saida);
	}
	
	@Test
	void testGetContatoComMudancaDeTelefone() {
		testMudarTelefone();
		String saida = "Matheus Gaudencio\n(83) 1111-9999";
		assertEquals(this.agenda1.getContato(1), saida);	
	}
	
	@Test
	void testGetContatoAposRemocaoDeTag() {
		testRemoverTagComPosicaoTagLimiteInferior();
		String saida = "Matheus Gaudencio\n(83) 99999-0000";
		assertEquals(this.agenda1.getContato(1), saida);	
	}
	
	@Test
	void testGetContatos() {
		String saida = "1 - Matheus Gaudencio\n22 - Fabio Moraes";
		assertEquals(this.agenda1.getContatos(), saida);
	}
	
	@Test
	void testGetContatosAposRemocaoDeContato() {
		testRemoverContatoExistente();
		String saida = "22 - Fabio Moraes";
		assertEquals(this.agenda1.getContatos(), saida);
	}
	
	@Test
	void testGetContatosVazios() {
		String saida = "";
		assertEquals(this.agenda2.getContatos(), saida);
	}
	
	@Test
	void testGetContatos1Contato() {
		this.agenda2.cadastraContato(1, "Luzenira", "Silva", "(94) 8641-1166");
		String saida = "1 - Luzenira Silva";
		assertEquals(this.agenda2.getContatos(), saida);
	}
	
	@Test
	void testGetContatosAposRemocaoDeContatoFavorito() {
		testRemoverFavoritoLimiteInferior();
		String saida = "1 - Thiago Silva\n100 - Thierry Silva";
		assertEquals(this.agenda3.getContatos(), saida);	
	}

	@Test
	void testAdicionaFavoritoLimiteInferior() {
		this.agenda1.adicionaFavorito(1, 1);
	}
	
	@Test
	void testAdicionaFavoritoEmPosicaoOcupada() {
		testAdicionaFavoritoLimiteInferior();
		this.agenda1.adicionaFavorito(1, 22);
	}
	
	@Test
	void testAdicionaFavoritoLimiteSuperior() {
		this.agenda1.adicionaFavorito(10, 22);
	}
	
	@Test
	void testAdicionaFavoritoAcimaDeLimiteSuperior() {
		try {
			this.agenda1.adicionaFavorito(11, 1);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testAdicionaFavoritoAbaixoDeLimiteInferior() {
		try {
			this.agenda1.adicionaFavorito(0, 1);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testAdicionaFavoritoEmContatoInvalido() {
		try {
			this.agenda1.adicionaFavorito(1, 100);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}

	@Test
	void testAdicionaFavoritoComContatoJaCadastrado() {
		testAdicionaFavoritoLimiteInferior();
		String saida = "CONTATO JA CADASTRADO NA LISTA DE FAVORITOS";
		assertEquals(this.agenda1.adicionaFavorito(2, 1), saida);
	}
	
	@Test
	void testGetContatosFavoritos() {
		testAdicionaFavoritoLimiteInferior();
		testAdicionaFavoritoLimiteSuperior();
		String saida = "1 - Matheus Gaudencio\n"
				+ "10 - Fabio Moraes";
		assertEquals(this.agenda1.getContatosFavoritos(), saida);
	}
	
	@Test
	void testGetContatosFavoritosAposSubstituicaoEmPosicaoOcupada() {
		testAdicionaFavoritoEmPosicaoOcupada();
		String saida = "1 - Fabio Moraes";
		assertEquals(this.agenda1.getContatosFavoritos(), saida);
	}
	
	@Test
	void testGetContatosFavoritosVazio() {
		assertEquals(this.agenda1.getContatosFavoritos(), "");
	}
	
	@Test
	void testGetContatosFavoritosAposRemocaoDeContato() {
		testRemoverContatoComFavorito();
		assertEquals(this.agenda1.getContatosFavoritos(), "");
	}
	
	@Test
	void testGetContatosFavoritosAposRemocaoDeContatoFavorito() {
		testRemoverFavoritoLimiteInferior();
		assertEquals(this.agenda3.getContatosFavoritos(), "");
	}

	@Test
	void testAdicionaTagLimiteInferior() {
		this.agenda1.adicionaTag(1, 1, "professor-ufcg");
		
	}
	
	@Test
	void testAdicionaTagLimiteSuperior() {
		this.agenda1.adicionaTag(100, 5, "UFCG");
		
	}

	@Test
	void testAdicionaTagAcimaDeLimiteSuperior() {
		try {
			this.agenda1.adicionaTag(1, 6, "UFCG");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}	
	}
	
	@Test
	void testAdicionaTagAbaixoDeLimiteInferior() {
		try {
			this.agenda1.adicionaTag(1, 0, "UFCG");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}	
	}
	
	@Test
	void testAdicionaTagEmContatoInvalido() {
		try {
			this.agenda1.adicionaTag(0, 1, "UFCG");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}	
	}
	
	@Test
	void testAdicionaTagEmPosicaoOcupada() {
		testAdicionaTagLimiteInferior();
		this.agenda1.adicionaTag(1, 1, "ccc");
	}
	
	@Test
	void testAdicionaSegundaTag() {
		testAdicionaTagLimiteInferior();
		this.agenda1.adicionaTag(1, 2, "ccc");
		
	}
	
	@Test
	void testAdicionaTagVazia() {
		this.agenda1.adicionaTag(1, 1, "");
	}
	
	@Test
	void testRemoverContatoExistente() {
		this.agenda1.removerContato(1);
	}
	
	@Test
	void testRemoverContatoQueNaoExiste() {
		try {
			this.agenda1.removerContato(100);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testRemoverContatoComFavorito() {
		testAdicionaFavoritoLimiteInferior();
		this.agenda1.removerContato(1);
	}
	
	@Test
	void testRemoverContatoInvalidoAcimaDeLimiteSuperior() {
		try {
			this.agenda1.removerContato(101);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRemoverContatoInvalidoAbaixoDeLimiteInferior() {
		try {
			this.agenda1.removerContato(0);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}

	@Test
	void testTemContatoAposRemocaoFalse() {
		testRemoverContatoExistente();
		assertFalse(this.agenda1.temContato(1));
	}
	
	@Test
	void testTemContatoTrue() {
		assertTrue(this.agenda1.temContato(1));
	}
	
	@Test
	void testTemContatoFalse() {
		assertFalse(this.agenda1.temContato(100));
	}
	
	@Test
	void testMudarTelefone() {
		this.agenda1.mudarTelefone(1, "(83) 1111-9999");
	}
	
	@Test
	void testMudarTelefoneLimiteInferior() {
		this.agenda3.mudarTelefone(1, "(83) 1111-9999");
	}
	
	@Test
	void testMudarTelefoneLimiteSuperior() {
		this.agenda3.mudarTelefone(100, "(83) 1111-9999");
	}
	
	@Test
	void testMudarTelefoneAbaixoLimiteInferior() {
		try {
			this.agenda3.mudarTelefone(0, "(83) 1111-9999");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testMudarTelefoneAcimaLimiteSuperior() {
		try {
			this.agenda3.mudarTelefone(101, "(83) 1111-9999");
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testMudarTelefoneComTelefoneVazio() {
		try {
			this.agenda3.mudarTelefone(1, "");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testMudarTelefoneComTelefoneNulo() {
		try {
			this.agenda3.mudarTelefone(1, null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testRemoverTagComPosicaoTagLimiteInferior() {
		testAdicionaTagLimiteInferior();
		this.agenda1.removerTag(1, 1);
	}
	
	@Test
	void testRemoverTagComPosicaoTagLimiteSuperior() {
		testAdicionaTagLimiteSuperior();
		this.agenda1.removerTag(1, 5);
	}
	
	@Test
	void testRemoverTagComPosicaoTagAbaixoLimiteInferior() {
		try {
			testAdicionaTagLimiteInferior();
			this.agenda1.removerTag(1, 0);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRemoverTagComPosicaoTagAcimaLimiteSuperior() {
		try {
			testAdicionaTagLimiteSuperior();
			this.agenda1.removerTag(1, 6);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRemoverFavoritoLimiteInferior() {
		this.agenda3.adicionaFavorito(1, 1);
		this.agenda3.removerFavorito(1);
	}
	
	@Test
	void testRemoverFavoritoAbaixoLimiteInferior() {
		try {
			this.agenda3.removerFavorito(0);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRemoverFavoritoLimiteSuperior() {
		this.agenda3.adicionaFavorito(1, 100);
		this.agenda3.removerFavorito(100);
	}
	
	@Test
	void testRemoverFavoritoAcimaLimiteSuperior() {
		try {
			this.agenda3.removerFavorito(101);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testExibeContatoPeloNome() {
		String saida = "1 - Matheus Gaudencio";
		assertEquals(this.agenda1.exibeContatoPeloNome("Matheus"), saida);
	}
	
	@Test
	void testExibeContatoPeloNomeComNomeNulo() {
		try {
			this.agenda1.exibeContatoPeloNome(null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testExibeContatoPeloNomeComNomeVazio() {
		try {
			this.agenda1.exibeContatoPeloNome("");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testExibeContatoPeloNomeComNomeInexistente() {
		String saida = "";
		assertEquals(this.agenda1.exibeContatoPeloNome("Ana"), saida);
	}
	
	@Test
	void testExibeContatoPeloSobrenome() {
		String saida = "1 - Thiago Silva\n100 - Thierry Silva";
		assertEquals(this.agenda3.exibeContatoPeloSobrenome("Silva"), saida);
	}
	
	@Test
	void testExibeContatoPeloSobrenomeComSobrenomeInexistente() {
		String saida = "";
		assertEquals(this.agenda3.exibeContatoPeloSobrenome("Ana"), saida);
	}
	
	@Test
	void testExibeContatoPelaTag() {
		testAdicionaTagLimiteInferior();
		String saida = "1 - Matheus Gaudencio";
		assertEquals(this.agenda1.exibeContatoPelaTag("professor-ufcg"), saida);
	}
	
	@Test
	void testExibeContatoPelaTagComTagInexistente() {
		String saida = "";
		assertEquals(this.agenda1.exibeContatoPelaTag(""), saida);
	}
}
