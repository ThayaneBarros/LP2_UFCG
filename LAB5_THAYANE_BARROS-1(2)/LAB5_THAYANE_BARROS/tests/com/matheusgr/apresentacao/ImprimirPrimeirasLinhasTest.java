package com.matheusgr.apresentacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe ImprimirPrimeirasLinhas.
 * 
 * @author Thayane Barros - 121110604
 *
 */
class ImprimirPrimeirasLinhasTest extends BaseApresentacaoTest {
	
	@Test
	void testCriaImprimirPrimeirasLinhas() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(2);
	}
	
	@Test
	void testCriaImprimirPrimeirasLinhasComValorInvalido() {
		try {
			this.primeirasLinhas = new ImprimirPrimeirasLinhas(-1);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
		
	}
	
	@Test
	void testCriaImprimirPrimeirasLinhasComValorZero() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(0);
	}
	
	@Test
	void testImprimirPrimeirasLinhasSemLinha() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(0);
		String texto = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		String resul = this.primeirasLinhas.imprimir(texto.split("\n"));
		String saida = "";
		assertEquals(resul, saida);
			
	}
	
	@Test
	void testApresentacaoPrimeirasLinhasComQtdLinhasMaiorQueArquivo() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(3);
		String texto = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		try {
			this.primeirasLinhas.imprimir(texto.split("\n"));
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException ie) {
			
		}	
	}
	
	@Test
	void testApresentacaoPrimeirasLinhasComDocumentoVazio() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(0);
		String texto = "";
		String resul = this.primeirasLinhas.imprimir(texto.split("\n"));
		String saida = "";
		assertEquals(resul, saida);		
			
	}
	
	@Test
	void testApresentacaoPrimeirasLinhasComDocumentoNulo() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(1);
		try {
			this.primeirasLinhas.imprimir(null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}	
	}
	
	@Test
	void testApresentacaoPrimeirasLinhasLimiteInferior() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(1);
		String texto = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		String resul = this.primeirasLinhas.imprimir(texto.split("\n"));
		String saida = "um arquivo! texto simples.";
		assertEquals(resul, saida);		
			
	}
	
	@Test
	void testApresentacaoPrimeirasLinhasImprimindoTodasAsLinhas() {
		this.primeirasLinhas = new ImprimirPrimeirasLinhas(2);
		String texto = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		String resul = this.primeirasLinhas.imprimir(texto.split("\n"));
		String saida = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		assertEquals(resul, saida);		
			
	}

}
