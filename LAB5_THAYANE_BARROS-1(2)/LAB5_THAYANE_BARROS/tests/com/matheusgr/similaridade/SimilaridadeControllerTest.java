package com.matheusgr.similaridade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar a funcionalidade de similaridade
 * 
 * @author Thayane Barros - 121110604
 *
 */
class SimilaridadeControllerTest extends BaseSimilaridadeTest {

	@Test
	void testSimilaridade() {
		double resul = this.similaridadeController.similaridade("789", "ABC");
		assertEquals(50, resul);
	}
	
	@Test
	void testSimilaridade2() {
		this.documentoController.adicionaDocumentoTxt("1", "Uma casa feliz é uma casa bonita");
		this.documentoController.adicionaDocumentoTxt("2", "Um dia feliz é um bom dia");
		double resul = this.similaridadeController.similaridade("1", "2");
		assertEquals(20, resul);
	}
	
	@Test
	void testSimilaridadeComDocumentoSemSemelhanca() {
		this.documentoController.adicionaDocumentoTxt("1", "Uma casa feliz é uma casa bonita");
		this.documentoController.adicionaDocumentoTxt("2", "Um dia alegre");
		double resul = this.similaridadeController.similaridade("1", "2");
		assertEquals(0, resul);
	}
	
	@Test
	void testSimilaridadeComDocumentosIguais() {
		this.documentoController.adicionaDocumentoTxt("1", "Uma casa feliz é uma casa bonita");
		this.documentoController.adicionaDocumentoTxt("2", "Uma casa feliz é uma casa bonita");
		double resul = this.similaridadeController.similaridade("1", "2");
		assertEquals(100, resul);
	}
	
	@Test
	void testSimilaridade1DocumentoVazioIdVazio() {
		try {
			this.similaridadeController.similaridade("", "ABC");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testSimilaridade2DocumentosVazioIdVazio() {
		try {
			this.similaridadeController.similaridade("", "");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testSimilaridade1DocumentoNulo() {
		try {
			this.similaridadeController.similaridade(null, "ABC");
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testSimilaridade2DocumentosNulo() {
		try {
			this.similaridadeController.similaridade(null, null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testSimilaridadeComDocumentoInexistente() {
		try {
			this.similaridadeController.similaridade("3", "ABC");
			fail("Era esperado uma excessão aqui");
		} catch(NoSuchElementException nse) {
			
		}
		
	}

}
