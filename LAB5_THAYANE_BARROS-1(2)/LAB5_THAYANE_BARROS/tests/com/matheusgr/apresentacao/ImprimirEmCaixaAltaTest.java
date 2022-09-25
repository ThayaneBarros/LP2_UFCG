package com.matheusgr.apresentacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe ImprimirEmCaixaAlta.
 * 
 * @author Thayane Barros - 121110604
 *
 */
class ImprimirEmCaixaAltaTest extends BaseApresentacaoTest {
	
	@BeforeEach
	void criaCaixaAlta() {
		this.caixaAlta = new ImprimirEmCaixaAlta();
	}
	
	@Test
	void testApresentacaoCaixaAlta() {
		String texto = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		String resul = this.caixaAlta.imprimir(texto.split("\n"));
		String saida = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		assertEquals(resul, saida);		
	}
	
	@Test
	void testApresentacaoCaixaAltaComTextoJaEmCaixaAlta() {
		String texto = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		String resul = this.caixaAlta.imprimir(texto.split("\n"));
		String saida = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		assertEquals(resul, saida);		
	}
	
	@Test
	void testApresentacaoCaixaAltaComDocumentoVazio() {
		String texto = "";
		String resul = this.caixaAlta.imprimir(texto.split("\n"));
		String saida = "";
		assertEquals(resul, saida);		
	}
	
	@Test
	void testApresentacaoCaixaAltaComDocumentoNulo() {
		try {
			this.caixaAlta.imprimir(null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}

}
