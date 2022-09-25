package com.matheusgr.apresentacao;

import java.util.Objects;

/**
 * Classe responsável por apresentar o contéudo do arquivo em caixa alta.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class ImprimirEmCaixaAlta implements ApresentarConteudosInterface {

	/**
	 * Construtor padrão do arquivo.
	 */
	public ImprimirEmCaixaAlta() {
	}

	/**
	 * Método que irá apresenta o contéudo do arquivo em caixa alta.
	 * 
	 * @param documento O documento a ser apresentado.
	 * @return A apresentacao do documento.
	 */
	@Override
	public String imprimir(String[] documento) {	
		Objects.requireNonNull(documento, "Documento não pode ser nulo");
		String resul = "";
		for(int i = 0; i < documento.length; i++) {
			resul += documento[i] + "\n";
		}
		return resul.trim().toUpperCase();		
	}

}