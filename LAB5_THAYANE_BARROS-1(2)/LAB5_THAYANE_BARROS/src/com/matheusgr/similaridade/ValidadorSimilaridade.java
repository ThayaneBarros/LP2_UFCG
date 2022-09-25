package com.matheusgr.similaridade;

import java.util.Objects;

import com.matheusgr.lunr.ValidadorPadrao;

/**
 * Classe de validação de similaridade. A validação recebe IDs de documentos que são considerados 
 * válidos se os seus contéudos não forem nulos ou vazios. Nem deve ser possível ter IDs nulos ou vazios.
 */
public class ValidadorSimilaridade extends ValidadorPadrao {

	/**
	 * Operação de validação dos IDs.
	 * As duas regras de validação é a de que o ID não pode ser nulo e não pode ser
	 * vazio.
	 * 
	 * @param id O primeiro ID a ser validado.
	 * @param id2 O segundo ID a ser validado.
	 */
	public void validacao(String id, String id2) {
		validacao(id);
		validacao(id2);
	}
	
	/**
	 * Valida o conteudo de um documento. Nenhum termo pode ser vazio/nulo.
	 * 
	 * @param doc1 Os termos do primeiro documento a ser validado.
	 * @param doc2 Os termos do segundo documento a ser validado.
	 */
	public void validacaoConteudo(String[] doc1, String[] doc2) {
		Objects.requireNonNull(doc1, "Conteúdo não pode ser nulo");
		Objects.requireNonNull(doc2, "Conteúdo não pode ser nulo");
		if (doc1.length < 1 || doc2.length < 1) {
			throw new IllegalArgumentException("Conteúdo não pode ser vazio");
		}
	}
}