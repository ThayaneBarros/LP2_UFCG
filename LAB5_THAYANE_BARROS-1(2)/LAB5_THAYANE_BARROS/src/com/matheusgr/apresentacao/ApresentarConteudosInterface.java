package com.matheusgr.apresentacao;

/**
 * Interface para representar todos os tipos de documentos.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public interface ApresentarConteudosInterface {
	
	/**
	 * Retorna a apresentação do tipo de documento.
	 * 
	 * @param documento o documento a ser imprimido.
	 * @return o documento com o tipo de apresentação escolhido.
	 */
	String imprimir(String[] documento);

}