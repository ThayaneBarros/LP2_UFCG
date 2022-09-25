package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por realizar testes funcionais e de alto nivels das funcionalidades
 * totalDocumentos, concatena e sumariza da classe DocumentoController.
 * 
 * @author Thayane Barros - 121110604
 *
 */
class DocumentoControllerTest extends BaseDocumentoTest {

	@Test
	void testTotalDocumentosComNenhumDocumentoCadatrado() {
		assertEquals(0, this.documentoController.totalDocumentos());
	}
	
	@Test
	void testTotalDocumentosCom1DocumentoCadatrado() {
		this.documentoService.adicionaDocumento(documentotxt1);
		assertEquals(1, this.documentoController.totalDocumentos());
	}
	
	@Test
	void testConcatena() {
		this.documentoService.adicionaDocumento(documentotxt1);
		this.documentoService.adicionaDocumento(documentotxt2);
		String resul = this.documentoController.concatenaDocumentos(TEXTO1_ID, TEXTO2_ID);
		String saida = "_MERGE789|ABC";
		assertEquals(resul, saida);
	}
	
	@Test
	void testConcatenaComMesmoDocumento() {
		this.documentoService.adicionaDocumento(documentotxt1);
		String resul = this.documentoController.concatenaDocumentos(TEXTO1_ID, TEXTO1_ID);
		String saida = "_MERGE789|789";
		assertEquals(resul, saida);
	}
	
	@Test
	void testConcatenaDocumentoInexistente() {
		try {
			this.documentoController.concatenaDocumentos(TEXTO1_ID, TEXTO2_ID);
			fail("Era esperado uma excessão aqui");
		} catch (NoSuchElementException nse) {
			
		}
	}
	
	@Test
	void testConcatenaIdVazio() {
		try {
			this.documentoController.concatenaDocumentos("", TEXTO2_ID);
			fail("Era esperado uma excessão aqui");
		} catch (IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testConcatenaIdNulo() {
		try {
			this.documentoController.concatenaDocumentos(TEXTO1_ID, null);
			fail("Era esperado uma excessão aqui");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testSumariza() {
		this.documentoService.adicionaDocumento(documentotxt1);
		String[] resul = this.documentoController.sumariza(TEXTO1_ID);
		assertEquals(4, resul.length);
	}
	
	@Test
	void testSumarizaComDocumentoComMaisDe5Palavas() {
		this.documentoService.adicionaDocumento(documentotxt4);
		String[] resul = this.documentoController.sumariza(TEXTO4_ID);
		assertEquals(5, resul.length);
	}
	
	@Test
	void testSumarizaComDocumentoComPalavasComMenosDe5Letras() {
		this.documentoService.adicionaDocumento(documentotxt5);
		String[] resul = this.documentoController.sumariza(TEXTO5_ID);
		assertEquals(0, resul.length);
	}
	
	@Test
	void testSumarizaComDocumentoComPalavasIguais() {
		this.documentoController.adicionaDocumentoTxt("000", "arquivo arquivo arquivo");
		String[] resul = this.documentoController.sumariza("000");
		assertEquals(1, resul.length);
	}
	
	@Test
	void testSumarizaComDocumentoInexistente() {
		try {
			this.documentoController.sumariza("000");
			fail("Era esperado uma excessão aqui");
		} catch(NoSuchElementException nse) {
			
		}
	}
	
	@Test
	void testSumarizaComIdNulo() {
		try {
			this.documentoController.sumariza(null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}


}
