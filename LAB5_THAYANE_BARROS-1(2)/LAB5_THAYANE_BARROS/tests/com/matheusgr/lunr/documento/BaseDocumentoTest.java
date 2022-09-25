package com.matheusgr.lunr.documento;

import org.junit.jupiter.api.BeforeEach;

class BaseDocumentoTest {

	public static final String TEXTO1_ID = "789";
	public static final String TEXTO2_ID = "ABC";
	public static final String TEXTO3_ID = "DEF";
	public static final String TEXTO4_ID = "GHI";
	public static final String TEXTO5_ID = "JKL";
	public static final String HTML_ID = "123";
	public static final String JAVA_ID = "456";

	protected DocumentoTexto documentotxt1;
	protected DocumentoTexto documentotxt2;
	protected DocumentoTexto documentotxt3;
	protected DocumentoTexto documentotxt4;
	protected DocumentoTexto documentotxt5;
	protected DocumentoHtml documento6;
	protected DocumentoJava documento7;
	protected DocumentoService documentoService;
	protected DocumentoController documentoController;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.documentotxt1 = new DocumentoTexto(TEXTO1_ID, "um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
		this.documentotxt2 = new DocumentoTexto(TEXTO2_ID, "um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!");
		this.documentotxt3 = new DocumentoTexto(TEXTO3_ID, "");
		this.documentotxt4 = new DocumentoTexto(TEXTO4_ID, "Grandes palavras são necessárias para expressar grandes ideias");
		this.documentotxt5 = new DocumentoTexto(TEXTO5_ID, "Não sonhe sua vida, viva seu sonho");	
		this.documento6 = new DocumentoHtml(HTML_ID, "um arquivo de HTML simples\nuse DUAS linhas apenas");
		this.documento7 = new DocumentoJava(JAVA_ID, "um arquivo Java simples\nuse DUAS linhas apenas");
		this.documentoService = new DocumentoService();
		this.documentoController = new DocumentoController(this.documentoService);
	}
}