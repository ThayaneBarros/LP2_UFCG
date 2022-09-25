package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Classe responsavel por testar os metodos da classe BuscaSimples
 * 
 * @author Thayane Barros - 121110604
 *
 */
class BuscaSimplesTest extends BaseBuscaTest {
	
	private BuscaSimples buscaSimples1;

	@BeforeEach
	void testCriaBuscaSimples() {
		this.buscaSimples1 = new BuscaSimples(new String[] {"public"});
	}
	
	@Test
	void testCriaBuscaSimplesComTermosNulos() {
		String[] termos = null;
		try {
			this.buscaSimples1 = new BuscaSimples(termos);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testCriaBuscaSimplesComTermoVazio() {
		try {
			this.buscaSimples1 = new BuscaSimples(new String[] {""});
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testCriaBuscaSimplesCom1TermoVazio() {
		this.buscaSimples1 = new BuscaSimples(new String[] {"", "public"});
			
	}
	
	@Test
	void testCriaBuscaSimplesCom1TermoNulo() {
		try {
			this.buscaSimples1 = new BuscaSimples(new String[] {null, "public"});
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
			
	}
	
	@Test
	void testBuscaComDocumentoInexistente() {
		try {
			this.buscaSimples1.busca(this.documentoService);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}	
	}
	
	@Test
	void testDescreveConsulta() {
		String[][] resul = this.buscaSimples1.descreveConsulta();
		assertEquals(1, resul.length);		
	}
	
	@Test
	void testDescreveConsultaCom2termos() {
		this.buscaSimples = new BuscaSimples(new String[] {"use", "public"});
		String[][] resul = buscaSimples.descreveConsulta();
		assertEquals(2, resul.length);		
	}
	
	@Test
	void testDescreveConsultaCom1TermoVazio() {
		this.buscaSimples = new BuscaSimples(new String[] {"", "public"});
		String[][] resul = buscaSimples.descreveConsulta();
		assertEquals(2, resul.length);		
	}
	
	@Test
	void testDescreveConsultaComBuscaInexistente() {
		try {
			this.buscaSimples.descreveConsulta();
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBusca() {
		DocumentoService ds = new DocumentoService();
		Map<Documento, Integer> resul = this.buscaSimples1.busca(ds);	
		assertEquals(0, resul.size());
	}
	
	@Test
	void testBuscaCom1TermoVazio() {
		DocumentoService ds = new DocumentoService();
		this.buscaSimples = new BuscaSimples(new String[] {"", "public"});
		Map<Documento, Integer> resul = this.buscaSimples.busca(ds);	
		assertEquals(0, resul.size());
	}

}