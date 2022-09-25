package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.documento.DocumentoDTO;

/**
 * Classe responsavel por testar a funcionalidade de Busca Avancada
 * 
 * @author Thayane Barros - 121110604
 *
 */
class FuncionalidadeBuscaAvancadaTest extends BaseTest {
	
	@Test
	void testBuscaAvancadaSemDocumentosCadastrados() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("1", "txt");
		DocumentoDTO[] busca = this.buscaController.busca(metadadosBuscados);
		assertEquals(0, busca.length);
	}
	
	@Test
	void testBuscaAvancadaCom1Resultado() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("LINHAS", "1");
		DocumentoDTO[] busca = this.buscaController.busca(metadadosBuscados);
		assertEquals(1, busca.length);
	}
	
	@Test
	void testBuscaController() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("LINHAS", "1");
		DocumentoDTO[] resul = this.buscaController.busca(metadadosBuscados);
		assertEquals(1, resul.length);
	}
	
	@Test
	void testBuscaControllerChaveVazia() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put(" ", "1");
		try {
			this.buscaController.busca(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testBuscaControllerChaveNula() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put(null, "1");
		try {
			this.buscaController.busca(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaControllerValorVazia() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("Linhas", "");
		try {
			this.buscaController.busca(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testBuscaControllerValorNulo() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("Linhas", null);
		try {
			this.buscaController.busca(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaControllerValorEChaveVazia() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("", "");
		try {
			this.buscaController.busca(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testBuscaControllerValorEChaveNulos() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put(null, null);
		try {
			this.buscaController.busca(metadadosBuscados);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaAvancadaComDoisResultados() {
		this.documentoController.adicionaDocumentoTxt(TEXTO3_ID, "um arquivo! texto simples.\r\nuse DUAS linhas agora.");
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put("LINHAS", "1");
		DocumentoDTO[] busca = this.buscaController.busca(metadadosBuscados);
		assertEquals(2, busca.length);	
	}
	
	@Test
	void testBuscaAvancadaComMetadadoAusente() {
		this.documentoController.adicionaDocumentoTxt(TEXTO3_ID, "um arquivo! texto simples.\r\nuse DUAS linhas agora.");
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "teste");
		DocumentoDTO[] busca = this.buscaController.busca(metadadosBuscados);
		assertEquals(0, busca.length);	
	}
	
	@Test
	void testBuscaAvancadaCom1MetadadoAusente() {
		this.documentoController.adicionaDocumentoTxt(TEXTO3_ID, "um arquivo! texto simples.\r\nuse DUAS linhas agora.");
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("LINHAS", "1");
		metadadosBuscados.put("TIPO", "teste");
		DocumentoDTO[] busca = this.buscaController.busca(metadadosBuscados);
		assertEquals(0, busca.length);	
	}
	
}