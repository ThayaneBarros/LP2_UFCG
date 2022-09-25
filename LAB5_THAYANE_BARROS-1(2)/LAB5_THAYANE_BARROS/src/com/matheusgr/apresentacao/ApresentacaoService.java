package com.matheusgr.apresentacao;

import com.matheusgr.lunr.ValidadorPadrao;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa 
 * a apresentação de documentos.
 */
public class ApresentacaoService extends ValidadorPadrao{

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         ApresentacaoService.
	 */
	public ApresentacaoService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}
	
	/**
	 * Realiza a apresentação do documento indicado.
	 * 
	 * @param docId Documento a ser apresentado.
	 * @param tipoApresentacao modo de apresentacao a ser aplicado sobre o documento.
	 * @return A apresentacao do documento.
	 */
	public String apresenta(String docId, ApresentarConteudosInterface tipoApresentacao) {
		validacao(docId);
		String[] documentoConteudo = this.documentoService.recuperaDocumento(docId).get().getOriginal().split("\n");
		
		return tipoApresentacao.imprimir(documentoConteudo);
		
	}
}
