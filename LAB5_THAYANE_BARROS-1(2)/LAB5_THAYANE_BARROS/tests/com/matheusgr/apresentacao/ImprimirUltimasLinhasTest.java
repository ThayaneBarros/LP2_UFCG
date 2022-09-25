package com.matheusgr.apresentacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe ImprimirUltimasLinhas.
 * 
 * @author  Thayane Barros - 121110604
 *
 */
class ImprimirUltimasLinhasTest extends BaseApresentacaoTest {

	@Test
	void testCriaImprimirUltimasLinhas() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(2);
	}
	
	@Test
	void testCriaImprimirUltimasLinhasComValorInvalido() {
		try {
			this.ultimasLinhas = new ImprimirUltimasLinhas(-1);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
		
	}
	
	@Test
	void testCriaImprimirUltimasLinhasComValorZero() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(0);
	}
	
	@Test
	void testImprimirUltimasLinhasSemLinha() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(0);
		String texto = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		String resul = this.ultimasLinhas.imprimir(texto.split("\n"));
		String saida = "";
		assertEquals(resul, saida);
			
	}
	
	@Test
	void testApresentacaoUltimasLinhasComQtdLinhasMaiorQueArquivo() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(3);
		String texto = "UM ARQUIVO! TEXTO SIMPLES.\r\nUSE DUAS LINHAS APENAS.";
		try {
			this.ultimasLinhas.imprimir(texto.split("\n"));
			fail("Era esperado uma excessão aqui");
		} catch(IndexOutOfBoundsException ie) {
			
		}	
	}
	
	@Test
	void testApresentacaoUltimasLinhasComDocumentoVazio() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(0);
		String texto = "";
		String resul = this.ultimasLinhas.imprimir(texto.split("\n"));
		String saida = "";
		assertEquals(resul, saida);		
			
	}
	
	@Test
	void testApresentacaoUltimasLinhasComDocumentoNulo() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(1);
		try {
			this.ultimasLinhas.imprimir(null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}	
	}
	
	@Test
	void testApresentacaoUltimasLinhasLimiteInferior() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(1);
		String texto = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		String resul = this.ultimasLinhas.imprimir(texto.split("\n"));
		String saida = "use DUAS linhas apenas.";
		assertEquals(resul, saida);		
			
	}
	
	@Test
	void testApresentacaoUltimasLinhasImprimindoTodasAsLinhas() {
		this.ultimasLinhas = new ImprimirUltimasLinhas(2);
		String texto = "um arquivo! texto simples.\r\nuse DUAS linhas apenas.";
		String resul = this.ultimasLinhas.imprimir(texto.split("\n"));
		String saida = "use DUAS linhas apenas.\num arquivo! texto simples.";
		assertEquals(resul, saida);		
			
	}

}
