package com.matheusgr.apresentacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar a funcionalidade de apresentação de documentos.
 * 
 * @author Thayane Barros - 121110604
 *
 */
class ApresentacaoServiceTest extends BaseApresentacaoTest {

	@Test
	void testApresentacaoPrimeirasLinhasComTodasAsLinhas() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(2);
		String resul = this.apresentacaoController.apresenta("789", this.primeirasLinhas);
		String saida = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		assertEquals(resul, saida);
	}
	
	@Test
	void testApresentacaoIdVazio() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(2);
		try {
			this.apresentacaoController.apresenta("", this.primeirasLinhas);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testApresentacaoIdNulo() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(2);
		try {
			this.apresentacaoController.apresenta(null, this.primeirasLinhas);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testApresentacaoPrimeirasLinhasSemLinha() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(0);
		String resul = this.apresentacaoController.apresenta("789", this.primeirasLinhas);
		String saida = "";
		assertEquals(resul, saida);
			
	}
	
	@Test
	void testApresentacaoPrimeirasLinhasComQtdLinhasMaiorQueArquivo() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(3);
		try {
			this.apresentacaoController.apresenta("789", this.primeirasLinhas);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException ie) {
			
		}	
	}
	
	@Test
	void testApresentacaoUltimasLinhasCom1Linha() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(1);
		String resul = this.apresentacaoController.apresenta("789", this.ultimasLinhas);
		String saida = "use DUAS linhas apenas.";
		assertEquals(resul, saida);
			
	}
	
	@Test
	void testApresentacaoUltimasLinhasComTodasAsLinhas() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(2);
		String resul = this.apresentacaoController.apresenta("789", this.ultimasLinhas);
		String saida = "use DUAS linhas apenas.\num arquivo! texto simples.";
		assertEquals(resul, saida);
			
	}
	
	@Test
	void testApresentacaoUltimasLinhasSemLinha() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(0);
		String resul = this.apresentacaoController.apresenta("789", this.ultimasLinhas);
		String saida = "";
		assertEquals(resul, saida);
			
	}
	
	@Test
	void testApresentacaoUltimasLinhasComQtdLinhasMaiorQueArquivo() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(3);
		try {
			this.apresentacaoController.apresenta("789", this.ultimasLinhas);
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException ie) {
			
		}	
	}
	
	@Test
	void testApresentacaoCaixaAlta() {
		this.caixaAlta = new ImprimirEmCaixaAlta();
		String resul = this.apresentacaoController.apresenta("789", this.caixaAlta);
		String saida = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		assertEquals(resul, saida);		
	}

}