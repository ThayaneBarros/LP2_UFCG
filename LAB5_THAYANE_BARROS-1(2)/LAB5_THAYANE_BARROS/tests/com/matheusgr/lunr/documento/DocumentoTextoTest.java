package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe DocumentoTexto.
 * 
 * @author Thayane Barros - 121110604
 *
 */
class DocumentoTextoTest extends BaseDocumentoTest {

	@Test
	void testGetId() {
		assertEquals(this.documentotxt1.getId(), TEXTO1_ID);
	}
	
	@Test
	void testGetIdComIdVazio() {
		DocumentoTexto doc = new DocumentoTexto("", "Teste");
		assertEquals(doc.getId(), "");
	}
	
	@Test
	void testGetTexto() {
		String[] resul = this.documentotxt1.getTexto();
		assertEquals(8, resul.length);
	}
	
	@Test
	void testGetTextoComConteudoVazio() {
		String[] resul = this.documentotxt3.getTexto();
		assertEquals(1, resul.length);
	}
	
	@Test
	void testEqualsFalse() {
		assertFalse(this.documentotxt1.equals(this.documentotxt2));
	}
	
	@Test
	void testEqualsComObjetoNulo() {
		assertFalse(this.documentotxt1.equals(null));
	}
	
	@Test
	void testEqualsComMesmoDocumento() {
		assertTrue(this.documentotxt1.equals(this.documentotxt1));
	}
	
	@Test
	void testEqualsTrue() {
		DocumentoTexto doc = new DocumentoTexto("789", "Teste");
		assertTrue(this.documentotxt1.equals(doc));
	}
	
	@Test
	void testToString() {
		String resul = this.documentotxt5.toString();
		String saida = "===JKL\nNão sonhe sua vida  viva seu sonho";
		assertEquals(resul, saida);
	}
	
	@Test
	void testToStringComConteudoVazio() {
		String resul = this.documentotxt3.toString();
		String saida = "===DEF\n";
		assertEquals(resul, saida);
	}

	@Test
	void testGetMetadados() {
		Map<String, String> resul = this.documentotxt1.getMetadados();
		assertEquals(4, resul.size());
	}
	
	@Test
	void testGetOriginal() {
		String resul = this.documentotxt1.getOriginal();
		String saida = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		assertEquals(resul, saida);
	}
	
	@Test
	void testGetOriginalComDocumentoComConteudoVazio() {
		String resul = this.documentotxt3.getOriginal();
		String saida = "";
		assertEquals(resul, saida);
	}

}