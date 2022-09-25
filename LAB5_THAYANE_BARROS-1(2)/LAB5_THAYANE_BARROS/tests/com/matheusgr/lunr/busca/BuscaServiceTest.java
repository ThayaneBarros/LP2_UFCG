package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.documento.DocumentoDTO;

/**
 * Classe responsavel por testar os metodos da classe BuscaService
 * 
 * @author Thayane Barros - 121110604
 *
 */
class BuscaServiceTest extends BaseBuscaTest{

	@Test
	void testBuscaAvancadaMetadadoUnico() {
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaAvancada);
		assertEquals(1, resul.length);
	}
	
	@Test
	void testBuscaAvancadaComMetadadosVazio() {
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaAvancada2);
		assertEquals(0, resul.length);
	}
	
	@Test
	void testBuscaAvancadaMetadadoAusente() {
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaAvancada3);
		assertEquals(0, resul.length);
	}
	
	@Test
	void testBuscaAvancadaComBuscaInvalida() {
		try {
			this.buscaService.busca(this.buscaAvancadaInvalida);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaSimplesComBuscaInvalidaTermoVazio() {
		try {
			this.buscaService.busca(new BuscaSimples(new String[] {}));
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testBuscaSimplesComBuscaInvalidaTermoNulo() {
		try {
			this.buscaService.busca(new BuscaSimples(new String[] {null}));
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaSimplesTermoInexistente() {
		this.buscaSimples = new BuscaSimples(new String[] {"public"});
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaSimples);
		assertEquals(0, resul.length);
	}
	
	@Test
	void testBuscaSimplesCom1TermoVazio() {
		this.buscaSimples = new BuscaSimples(new String[] {"", "use"});
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaSimples);
		assertEquals(2, resul.length);
	}

	@Test
	void testBuscaSimplesTermoUnico() {
		this.buscaSimples = new BuscaSimples(new String[] {"MAIS"});
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaSimples);
		assertEquals(1, resul.length);
	}

	@Test
	void testBuscaSimplesTermoComum() {
		this.buscaSimples = new BuscaSimples(new String[] {"use"});
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaSimples);
		assertEquals(2, resul.length);
	}
	
	@Test
	void testBuscaSimplesCom2TermosComum() {
		this.buscaSimples = new BuscaSimples(new String[] {"use", "um"});
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaSimples);
		assertEquals(2, resul.length);
	}
	
	@Test
	void testBuscaSimplesCom2TermosMasSoUmEmComum() {
		this.buscaSimples = new BuscaSimples(new String[] {"use", "teste"});
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaSimples);
		assertEquals(2, resul.length);
	}
	
	@Test
	void testBuscaSimplesCom2Termos() {
		this.buscaSimples = new BuscaSimples(new String[] {"apenas", "MAIS"});
		DocumentoDTO[] resul = this.buscaService.busca(this.buscaSimples);
		assertEquals(2, resul.length);
	}
	
	@Test
	void testRecuperaHistoricoCom1Ocorrencia() {
		testBuscaAvancadaMetadadoUnico();
		String[] resul = this.buscaService.recuperaHistorico(0).ids();
		assertEquals(1, resul.length);
	}
	
	@Test
	void testRecuperaHistoricoSemBuscaOcorrida() {
		try {
			this.buscaService.recuperaHistorico(0);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRecuperaHistoricoCom2Ocorrencia() {
		testBuscaAvancadaMetadadoUnico();
		testBuscaSimplesTermoComum();
		String[] resul = this.buscaService.recuperaHistorico(0).ids();
		assertEquals(1, resul.length);
	}
	
	@Test
	void testRecuperaHistoricoComValorLimiteSuperior() {
		testBuscaAvancadaMetadadoUnico();
		testBuscaSimplesTermoComum();
		String[] resul = this.buscaService.recuperaHistorico(1).ids();
		assertEquals(2, resul.length);
	}
	
	@Test
	void testRecuperaHistoricoComValorAcimaDeLimiteSuperior() {
		testBuscaAvancadaMetadadoUnico();
		testBuscaSimplesTermoComum();
		try {
			this.buscaService.recuperaHistorico(2);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException re) {
			
		}
	}
	
	@Test
	void testRecuperaHistoricoComValorAbaixoDeLimiteInferior() {
		testBuscaAvancadaMetadadoUnico();
		testBuscaSimplesTermoComum();
		try {
			this.buscaService.recuperaHistorico(-1);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
}
