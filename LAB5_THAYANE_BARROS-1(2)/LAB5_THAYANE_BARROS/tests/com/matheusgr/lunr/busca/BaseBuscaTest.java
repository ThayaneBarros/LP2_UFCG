package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoService;

class BaseBuscaTest {
	
	public static final String TEXTO1_ID = "789";
	public static final String TEXTO2_ID = "ABC";
	public static final String TEXTO3_ID = "DEF";
	
	protected BuscaService buscaService;
	protected DocumentoService documentoService;
	protected DocumentoController documentoController;
	protected BuscaAvancada buscaAvancada;
	protected BuscaAvancada buscaAvancada2;
	protected BuscaAvancada buscaAvancada3;
	protected BuscaAvancada buscaAvancadaInvalida;
	protected BuscaSimples buscaSimples;
	
	@BeforeEach
	void setUp() throws Exception {
		Map<String, String> metadadosBuscados = new HashMap<>();
		metadadosBuscados.put("TIPO", "txt");
		metadadosBuscados.put("LINHAS", "1");
		
		Map<String, String> metadadosBuscadosTeste3 = new HashMap<>();
		metadadosBuscadosTeste3.put("Teste", "3");
		
		var documentoService = new DocumentoService();
		this.documentoController = new DocumentoController(documentoService);
		this.buscaService = new BuscaService(documentoService);
		this.buscaAvancada = new BuscaAvancada(metadadosBuscados);
		this.buscaAvancada2 = new BuscaAvancada(new HashMap<String, String>());
		this.buscaAvancada3 = new BuscaAvancada(metadadosBuscadosTeste3);
		
		this.documentoController.adicionaDocumentoTxt(TEXTO1_ID, "um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
		this.documentoController.adicionaDocumentoTxt(TEXTO2_ID, "um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!");
	}

}