package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe DocumentoRepository
 * 
 * @author Thayane Barros - 121110604
 *
 */
class DocumentoRepositoryTest extends BaseDocumentoTest {
	
	private DocumentoRepository documento1;
		 
	@BeforeEach
	void criaDocumentoRepository() {
		 this.documento1 = new DocumentoRepository();
	 }

	@Test
	void testAdicionaDocumento() {
		this.documento1.adiciona(this.documentotxt1);
	}
	
	@Test
	void testAdicionaDocumentoComIdVazio() {
		DocumentoTexto documento = new DocumentoTexto("", "Teste");
		try {
			this.documento1.adiciona(documento);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testAdicionaDocumentoComIdNulo() {
		DocumentoTexto documento = new DocumentoTexto(null, "Teste");
		try {
			this.documento1.adiciona(documento);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	void testAdicionaDocumentoComConteudoVazio() {
		DocumentoTexto documento = new DocumentoTexto("123", "");
		try {
			this.documento1.adiciona(documento);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testRecuperaDocumentos() {
		testAdicionaDocumento();
		Optional<Documento> recupera = this.documento1.recupera(TEXTO1_ID);
		assertFalse(recupera.isEmpty());
	}
	
	@Test
	void testRecuperaDocumentosSemDocumento() {
		Optional<Documento> recupera = this.documento1.recupera(TEXTO1_ID);
		assertTrue(recupera.isEmpty());
	}
	
	@Test
	void testRecuperaDocumentosComDocumentoComIdVazio() {
		try {
			this.documento1.recupera("");
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
		
		}	
	}
	
	@Test
	void testRecuperaDocumentosComDocumentoComIdNulo() {
		try {
			this.documento1.recupera(null);
			fail("Era esperado uma excessão aqui");
		} catch(NullPointerException npe) {
		
		}	
	}
	
	@Test
	void testTotalDocumentosCom0Documentos() {
		assertEquals(0, this.documento1.totalDocumentos());
	}
	
	@Test
	void testTotalDocumentosCom1Documentos() {
		testAdicionaDocumento();
		assertEquals(1, this.documento1.totalDocumentos());
	}
	
	@Test
	void testTotalDocumentosCom2Documentos() {
		testAdicionaDocumento();
		this.documento1.adiciona(this.documentotxt2);
		assertEquals(2, this.documento1.totalDocumentos());
	}
	
	@Test
	void testTotalDocumentosComDocumentosRepetidos() {
		testAdicionaDocumento();
		this.documento1.adiciona(this.documentotxt1);
		assertEquals(1, this.documento1.totalDocumentos());
	}
	
	@Test
	void testBuscaDocumentoComTermos() {
		testAdicionaDocumento();
		Set<Documento> busca = this.documento1.busca("use");
		assertEquals(1, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComTermosSemDocumento() {
		Set<Documento> busca = this.documento1.busca("use");
		assertEquals(0, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComTermosComVariosDocumentos() {
		this.documento1.adiciona(this.documentotxt1);
		this.documento1.adiciona(this.documentotxt2);
		this.documento1.adiciona(this.documento6);
		this.documento1.adiciona(this.documento7);
		Set<Documento> busca = this.documento1.busca("um");
		assertEquals(4, busca.size());
	}
	
	@Test
	void testBuscaDocumentoSemTermos() {
		testAdicionaDocumento();
		Set<Documento> busca = this.documento1.busca("teste");
		assertEquals(0, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComTermoVazio() {
		testAdicionaDocumento();
		Set<Documento> busca = this.documento1.busca("");
		assertEquals(0, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComMetadados() {
		testAdicionaDocumento();
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		Set<Documento> busca = this.documento1.busca(metadadosBuscados);
		assertEquals(1, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComDoisMetadados() {
		testAdicionaDocumento();
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put("Teste", "1");
		Set<Documento> busca = this.documento1.busca(metadadosBuscados);
		assertEquals(0, busca.size());
	}

	@Test
	void testBuscaDocumentoComMetadadoAusenteChaveInexistente() {
		testAdicionaDocumento();
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("Teste", "txt");
		Set<Documento> busca = this.documento1.busca(metadadosBuscados);
		assertEquals(0, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComMetadadoAusenteValorInexistente() {
		testAdicionaDocumento();
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "teste");
		Set<Documento> busca = this.documento1.busca(metadadosBuscados);
		assertEquals(0, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComMetadadoSemDocumentosCadastrados() {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		Set<Documento> busca = this.documento1.busca(metadadosBuscados);
		assertEquals(0, busca.size());
	}
	
	@Test
	void testBuscaDocumentoComMetadadoCom1MetadadoAusente() {
		testAdicionaDocumento();
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put("LINHAS", "5");
		Set<Documento> busca = this.documento1.busca(metadadosBuscados);
		assertEquals(0, busca.size());
	}
	
}
