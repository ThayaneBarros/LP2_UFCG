package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Classe responsavel por testar os metodos da classe BuscaAvancada
 * 
 * @author Thayane Barros - 121110604
 *
 */
class BuscaAvancadaTest extends BaseBuscaTest {

	@Test
	void testCriaBuscaAvancada() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		new BuscaAvancada(metadadosBuscados);
	}

	@Test
	void testCriaBuscaAvancadaCom2elementos() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put("LINHAS", "1");
		new BuscaAvancada(metadadosBuscados);
	}
	
	@Test
	void testCriaBuscaAvancadaMapaVazio() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("", "");
		try {
			new BuscaAvancada(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testCriaBuscaAvancadaCom1elementoVazio() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put("", "1");
		try {
			new BuscaAvancada(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}

	@Test
	void testCriaBuscaAvancadaComMapaNulo() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put(null, null);
		try {
			new BuscaAvancada(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}

	@Test
	void testCriaBuscaAvancadaCom1ElementoNulo() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put(null, null);
		
		try {
			new BuscaAvancada(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}

	@Test
	void testBusca() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		BuscaAvancada buscando = new BuscaAvancada(metadadosBuscados);
		DocumentoService ds = new DocumentoService();
		Map<Documento, Integer> resul = buscando.busca(ds);
		assertEquals(0, resul.size());
	}
	
	@Test
	void testBuscaComDocumentoServiceInexistente() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		BuscaAvancada buscando = new BuscaAvancada(metadadosBuscados);
		try {
			buscando.busca(this.documentoService);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}

	@Test
	void testDescreveConsulta() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		BuscaAvancada buscando = new BuscaAvancada(metadadosBuscados);
		String[][] resul = buscando.descreveConsulta();
		assertEquals(1, resul.length);
	}
	
	@Test
	void testDescreveConsultaCom2Metadados() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put("LINHAS", "1");
		BuscaAvancada buscando = new BuscaAvancada(metadadosBuscados);
		String[][] resul = buscando.descreveConsulta();
		assertEquals(2, resul.length);
	}
}
