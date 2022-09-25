package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe DocumentoJava.
 * 
 * @author Thayane Barros - 121110604
 *
 */
class DocumentoJavaTest extends BaseDocumentoTest {
	
	@Test
	void testGetId() {
		assertEquals(this.documento7.getId(), JAVA_ID);
	}
	
	@Test
	void testGetIdComIdVazio() {
		DocumentoJava doc = new DocumentoJava("", "Teste");
		assertEquals(doc.getId(), "");
	}
	
	@Test
	void testGetTexto() {
		String[] resul = this.documento7.getTexto();
		assertEquals(8, resul.length);
	}
	
	@Test
	void testGetTextoComConteudoVazio() {
		DocumentoJava doc = new DocumentoJava("789", "");
		String[] resul = doc.getTexto();
		assertEquals(1, resul.length);
	}
	
	@Test
	void testEqualsFalse() {
		DocumentoJava doc = new DocumentoJava("111", "Teste");
		assertFalse(this.documento7.equals(doc));
	}
	
	@Test
	void testEqualsComObjetoNulo() {
		assertFalse(this.documento7.equals(null));
	}
	
	@Test
	void testEqualsComMesmoDocumento() {
		assertTrue(this.documento7.equals(this.documento7));
	}
	
	@Test
	void testEqualsTrue() {
		DocumentoJava doc = new DocumentoJava("456", "Teste");
		assertTrue(this.documento7.equals(doc));
	}
	
	@Test
	void testToString() {
		String resul = this.documento7.toString();
		String saida = "===456\num arquivo Java simples"
				+ "\nuse DUAS linhas apenas";
		assertEquals(resul, saida);
	}
	
	@Test
	void testToStringComConteudoVazio() {
		DocumentoJava doc = new DocumentoJava("789", "");
		String resul = doc.toString();
		String saida = "===789\n";
		assertEquals(resul, saida);
	}

	@Test
	void testGetMetadados() {
		Map<String, String> resul = this.documento7.getMetadados();
		assertEquals(6, resul.size());
	}
	
	@Test
	void testGetOriginal() {
		String resul = this.documento7.getOriginal();
		String saida = "um arquivo Java simples\nuse DUAS linhas apenas";
		assertEquals(resul, saida);
	}
	
	@Test
	void testGetOriginalComDocumentoComConteudoVazio() {
		DocumentoJava doc = new DocumentoJava("111", "");
		String resul = doc.getOriginal();
		String saida = "";
		assertEquals(resul, saida);
	}
	
}
