package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe DocumentoHtml.
 * 
 * @author Thayane Barros - 121110604
 *
 */
class DocumentoHtmlTest extends BaseDocumentoTest {

	@Test
	void testGetId() {
		assertEquals(this.documento6.getId(), HTML_ID);
	}
	
	@Test
	void testGetIdComIdVazio() {
		DocumentoHtml doc = new DocumentoHtml("", "Teste");
		assertEquals(doc.getId(), "");
	}
	
	@Test
	void testGetIdComIdNulo() {
		DocumentoHtml doc = new DocumentoHtml(null, "Teste");
		assertEquals(doc.getId(), null);
	}
	
	@Test
	void testGetTexto() {
		String[] resul = this.documento6.getTexto();
		assertEquals(9, resul.length);
	}
	
	@Test
	void testGetTextoComConteudoVazio() {
		DocumentoHtml doc = new DocumentoHtml("123", "");
		String[] resul = doc.getTexto();
		assertEquals(1, resul.length);
	}
	
	@Test
	void testEqualsFalse() {
		DocumentoHtml doc = new DocumentoHtml("111", "Teste");
		assertFalse(this.documento6.equals(doc));
	}
	
	@Test
	void testEqualsComObjetoNulo() {
		assertFalse(this.documento6.equals(null));
	}
	
	@Test
	void testEqualsComMesmoDocumento() {
		assertTrue(this.documento6.equals(this.documento6));
	}
	
	@Test
	void testEqualsTrue() {
		DocumentoHtml doc = new DocumentoHtml("123", "Teste");
		assertTrue(this.documento6.equals(doc));
	}
	
	@Test
	void testToString() {
		String resul = this.documento6.toString();
		String saida = "===123\n\n===um arquivo de HTML simples"
				+ "\nuse DUAS linhas apenas";
		assertEquals(resul, saida);
	}
	
	@Test
	void testToStringComConteudoVazio() {
		DocumentoHtml doc = new DocumentoHtml("111", "");
		String resul = doc.toString();
		String saida = "===111\n\n===";
		assertEquals(resul, saida);
	}

	@Test
	void testGetMetadados() {
		Map<String, String> resul = this.documento6.getMetadados();
		assertEquals(6, resul.size());
	}
	
	@Test
	void testGetOriginal() {
		String resul = this.documento6.getOriginal();
		String saida = "um arquivo de HTML simples\nuse DUAS linhas apenas";
		assertEquals(resul, saida);
	}
	
	@Test
	void testGetOriginalComDocumentoComConteudoVazio() {
		DocumentoHtml doc = new DocumentoHtml("111", "");
		String resul = doc.getOriginal();
		String saida = "";
		assertEquals(resul, saida);
	}

}
