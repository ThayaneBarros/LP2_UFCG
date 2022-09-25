package com.matheusgr.similaridade;

import java.util.HashSet;
//import java.util.Optional;
//import java.util.Objects;

//import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa a similaridade.
 *
 */
public class SimilaridadeService {

	private DocumentoService documentoService;
	private ValidadorSimilaridade validadorSimilaridade;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
		this.validadorSimilaridade = new ValidadorSimilaridade();
	}

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o cálculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interseção entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a união entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade é o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhança entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		validadorSimilaridade.validacao(docId1, docId1);

		String[] doc1 = this.documentoService.recuperaDocumento(docId1).get().getTexto();
		String[] doc2 = this.documentoService.recuperaDocumento(docId2).get().getTexto();
		validadorSimilaridade.validacaoConteudo(doc1, doc2);
		
		HashSet<String> documento1 = new HashSet<>();
		HashSet<String> documento2 = new HashSet<>();
		for(String d: doc1) {
			documento1.add(d);
		}
		for(String d: doc2) {
			documento2.add(d);
		}
		
		HashSet<String> documentoIntersecao = new HashSet<>();
		for(String d: documento1) {
			for(String d1: documento2) {
				if(d.equals(d1)) {
					documentoIntersecao.add(d);
				} 
			}
		}
		
		HashSet<String> documentoUniao = new HashSet<>();
		for(String d: documento1) {
			documentoUniao.add(d);
		}
		for(String d: documento2) {
			documentoUniao.add(d);
		}
	
		double similaridade = (double)(documentoIntersecao.size()) / (double) documentoUniao.size();
		return similaridade * 100;
	}	

}
