package com.matheusgr.apresentacao;

import org.junit.jupiter.api.BeforeEach;

import com.matheusgr.lunr.LunrApp;
import com.matheusgr.lunr.documento.DocumentoController;

class BaseApresentacaoTest {

	public static final String TEXTO1_ID = "789";
	public static final String TEXTO2_ID = "ABC";
	
	protected DocumentoController documentoController;
	protected ApresentacaoController apresentacaoController;
	protected ImprimirPrimeirasLinhas primeirasLinhas;
	protected ImprimirUltimasLinhas ultimasLinhas;
	protected ImprimirEmCaixaAlta caixaAlta;
	
	@BeforeEach
	void setUp() throws Exception {
		LunrApp lunrApp = new LunrApp();
		this.documentoController = lunrApp.getDocumentoController();
		this.apresentacaoController = lunrApp.getApresentacaoController();
		
		this.documentoController.adicionaDocumentoTxt(TEXTO1_ID, "um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
		this.documentoController.adicionaDocumentoTxt(TEXTO2_ID, "um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!");
	}

}