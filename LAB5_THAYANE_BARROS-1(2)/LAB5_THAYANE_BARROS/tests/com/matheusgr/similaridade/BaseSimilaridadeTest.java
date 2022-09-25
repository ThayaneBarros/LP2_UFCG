package com.matheusgr.similaridade;

import org.junit.jupiter.api.BeforeEach;

import com.matheusgr.lunr.LunrApp;
import com.matheusgr.lunr.documento.DocumentoController;

class BaseSimilaridadeTest {

	public static final String TEXTO1_ID = "789";
	public static final String TEXTO2_ID = "ABC";
	
	protected DocumentoController documentoController;
	protected SimilaridadeController similaridadeController;

	@BeforeEach
	void setUp() throws Exception {
		LunrApp lunrApp = new LunrApp();
		this.documentoController = lunrApp.getDocumentoController();
		this.similaridadeController = lunrApp.getSimilaridadeController();
		this.documentoController.adicionaDocumentoTxt(TEXTO1_ID, "um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
		this.documentoController.adicionaDocumentoTxt(TEXTO2_ID, "um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!");
		
	}

}