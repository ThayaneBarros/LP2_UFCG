package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Repositório de documentos. O repositório pode ter operações simples de busca,
 * mas a lógica de ranking, limitação e ordenação deve ficar em outra entidade.
 * 
 * O ID de um documento é único.
 *
 */
class DocumentoRepository {

	private Map<String, Documento> documentos;
	private ValidadorDocumentos validador;

	/**
	 * Construção padrão do repositório de documentos.
	 */
	DocumentoRepository() {
		this.documentos = new HashMap<>();
		this.validador = new ValidadorDocumentos();
	}

	/**
	 * Adiciona o documento. O documento é validado para garantir a consistência do
	 * documento (sem termos e id vazios).
	 * 
	 * @param d Documento a ser adicionado.
	 */
	void adiciona(Documento d) {
		this.validador.validacao(d.getId(), d.getTexto());
		this.documentos.put(d.getId(), d);
	}

	/**
	 * Recupera um documento do repositório.
	 * 
	 * @param id ID do documento.
	 * @return Documento, caso exista.
	 */
	Optional<Documento> recupera(String id) {
		Documento doc = null;
		this.validador.validacao(id);
		
		if(this.documentos.containsKey(id)) {
			doc = this.documentos.get(id);
		}
		
		return Optional.ofNullable(doc);
	}

	/**
	 * Retorna o total de documentos cadastrados.
	 * 
	 * @return O total de documentos cadastrados.
	 */
	int totalDocumentos() {
		return this.documentos.size();
	}

	/**
	 * Realiza uma busca pelos termos.
	 * 
	 * @param termo Termo a ser buscado.
	 * @return Conjunto de documentos com o termo.
	 */
	public Set<Documento> busca(String termo) {
		return this.documentos.values().stream()
				.filter((x) -> Arrays.binarySearch(x.getTexto(), termo) > 0)
				.collect(Collectors.toSet());
	}

	/**
	 * Realiza uma busca pelos metadados.
	 * 
	 * @param metadados O mapa de metadados a ser buscado.
	 * @return Conjunto de documentos que tenham todos os metadados.
	 */
	public Set<Documento> busca(Map<String, String> metadados) {
		Set<Documento> docEncontrados = new HashSet<>();
		for(Documento docValores: this.documentos.values()) {
			Map<String, String> meta = docValores.getMetadados();
			int conta = 0;
			for(String chaveMeta: metadados.keySet()) {
				if(meta.containsKey(chaveMeta) && meta.get(chaveMeta).equals(metadados.get(chaveMeta))) {
					conta++;
					if(conta == metadados.size()) {
						docEncontrados.add(docValores);
					}
				}
			}
		}
		return docEncontrados;
	}
}
