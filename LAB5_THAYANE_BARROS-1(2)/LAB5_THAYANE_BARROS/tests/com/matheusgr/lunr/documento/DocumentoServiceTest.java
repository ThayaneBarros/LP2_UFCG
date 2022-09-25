package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe DocumentoService
 * 
 * @author Thayane Barros - 121110604
 *
 */
class DocumentoServiceTest extends BaseDocumentoTest {

	@Test
	void testAdicionaDocumentoValido() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
	}
	
	@Test
	void testAdicionaDocumentoInvalidoIdVazio() {
		DocumentoTexto documento = new DocumentoTexto("", "um arquivo! texto simples.\nuse DUAS linhas apenas.");
		try {
			this.documentoService.adicionaDocumento(documento);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testAdicionaDocumentoInvalidoIdNulo() {
		DocumentoTexto documento = new DocumentoTexto(null, "um arquivo! texto simples.\nuse DUAS linhas apenas.");
		try {
			this.documentoService.adicionaDocumento(documento);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testAdicionaDocumentoInvalidoConteudoVazio() {
		DocumentoTexto documento = new DocumentoTexto(TEXTO1_ID, "");
		try {
			this.documentoService.adicionaDocumento(documento);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testRecuperaDocumentoExistente() {
		testAdicionaDocumentoValido();
		Optional<Documento> resul = this.documentoService.recuperaDocumento(TEXTO1_ID);
		assertTrue(resul.isPresent());
	}
	
	@Test
	void testRecuperaDocumentoNaoExistente() {
		Optional<Documento> resul = this.documentoService.recuperaDocumento(TEXTO1_ID);
		assertFalse(resul.isPresent());
	}

	@Test
	void testTotalDocumentosCom1Documento() {
		testAdicionaDocumentoValido();
		assertEquals(1, this.documentoService.totalDocumentos());
	}
	
	@Test
	void testTotalDocumentosCom0documentos() {
		assertEquals(0, this.documentoService.totalDocumentos());
	}
	
	@Test
	void testTotalDocumentosCom2documentos() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		this.documentoService.adicionaDocumento(this.documentotxt2);
		assertEquals(2, this.documentoService.totalDocumentos());
	}
	
	@Test
	void testConcatenaCom2Documentos() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		this.documentoService.adicionaDocumento(this.documentotxt2);
		String resul = this.documentoService.concatena(TEXTO1_ID, TEXTO2_ID);
		String saida = "_MERGE789|ABC";
		assertEquals(resul, saida);
	}
	
	@Test
	void testConcatenaComMesmoDocumento() {
		this.documentoService.adicionaDocumento(this.documentotxt2);
		String resul = this.documentoService.concatena(TEXTO2_ID, TEXTO2_ID);
		String saida = "_MERGEABC|ABC";
		assertEquals(resul, saida);
	}
	
	@Test
	void testConcatenaComDocumentoInexistente() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		try {
			this.documentoService.concatena(TEXTO1_ID, TEXTO2_ID);
			fail("Era esperado uma excessão aqui");
		} catch(NoSuchElementException nse) {
			
		}
	}
	
	@Test
	void testConcatenaComDocumentoSemConteudo() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		try {
			this.documentoService.concatena(TEXTO1_ID, TEXTO3_ID);
			fail("Era esperado uma excessão aqui");
		} catch(NoSuchElementException nse) {
			
		}
	}
	
	@Test
	void testConcatenaComDocumentoComIdNulo() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		try {
			this.documentoService.concatena(TEXTO1_ID, null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testSumariza() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		String[] resul = this.documentoService.sumariza(TEXTO1_ID);
		assertEquals(4, resul.length);
	}
	
	@Test
	void testSumarizaComMaisDe5Palavras() {
		this.documentoService.adicionaDocumento(this.documentotxt4);
		String[] resul = this.documentoService.sumariza(TEXTO4_ID);
		assertEquals(5, resul.length);
	}

	@Test
	void testSumarizaComMaisDe0Palavras() {
		this.documentoService.adicionaDocumento(this.documentotxt5);
		String[] resul = this.documentoService.sumariza(TEXTO5_ID);
		assertEquals(0, resul.length);
	}
	
	@Test
	void testSumarizaComDocumentoInexistente() {
		try {
			 this.documentoService.sumariza(TEXTO1_ID);
			 fail("Era esperado uma excessão aqui");
		} catch(NoSuchElementException nse) {
			
		}
	}
	
	@Test
	void testSumarizaComDocumentoComIdNulo() {
		try {
			this.documentoService.sumariza(null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaTermoComUnicoTermo() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		Set<Documento> resul = this.documentoService.busca("use");
		assertEquals(1, resul.size());
	}
	
	@Test
	void testBuscaTermoSemResultado() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		Set<Documento> resul = this.documentoService.busca("teste");
		assertEquals(0, resul.size());
	}
	
	@Test
	void testBuscaTermoCom2resultados() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		this.documentoService.adicionaDocumento(this.documentotxt2);
		Set<Documento> resul = this.documentoService.busca("texto");
		assertEquals(2, resul.size());
	}
	
	@Test
	void testBuscaTermoSemDocumentosCadastrados() {
		Set<Documento> resul = this.documentoService.busca("texto");
		assertEquals(0, resul.size());
	}
	
	
	@Test
	void testBuscaTermoComTermoVazio() {
		Set<Documento> resul = this.documentoService.busca("");
		assertEquals(0, resul.size());
	}
	

	@Test
	void testBuscaMetadadosCom1Resultado() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		Set<Documento> resul = this.documentoService.busca(metadadosBuscados);
		assertEquals(1, resul.size());
	}
	
	@Test
	void testBuscaMetadadosCom2Resultado() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		this.documentoService.adicionaDocumento(this.documentotxt2);
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		Set<Documento> resul = this.documentoService.busca(metadadosBuscados);
		assertEquals(2, resul.size());
	}
	
	@Test
	void testBuscaMetadadosCom0Resultado() {
		this.documentoService.adicionaDocumento(this.documentotxt1);
		this.documentoService.adicionaDocumento(this.documentotxt2);
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "teste");
		Set<Documento> resul = this.documentoService.busca(metadadosBuscados);
		assertEquals(0, resul.size());
	}
	
	@Test
	void testBuscaMetadadosSemDocumentosCadastrados() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		Set<Documento> resul = this.documentoService.busca(metadadosBuscados);
		assertEquals(0, resul.size());
	}
	
}
