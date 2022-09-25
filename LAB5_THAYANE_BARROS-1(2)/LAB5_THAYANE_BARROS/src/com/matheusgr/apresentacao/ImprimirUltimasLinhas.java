package com.matheusgr.apresentacao;

import java.util.Objects;

/**
 * Classe responsável por apresentar o contéudo do arquivo imprimindo as últimas linhas.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class ImprimirUltimasLinhas implements ApresentarConteudosInterface {
	
	/**
	 * Atributo indicando a quantidade de linhas do tipo inteiro.
	 */
	private int numLinhas;	

	/**
	 * Construtor padrão do arquivo. Recebe como parâmentro a quantidade de linhas a ser apresentado.
	 * 
	 * @param numLinhas A quantidade de linhas que o arquivo irá apresentar.
	 */
	public ImprimirUltimasLinhas(int numLinhas) {
		if(!(numLinhas < 0)) {
			this.numLinhas = numLinhas;
		} else {
			throw new IllegalArgumentException("Quantidade de linhas invalidas");
		}
	}
	
	/**
	 * Método que irá apresenta o contéudo do arquivo imprimindo as últimas linhas.
	 * Se o documento passado como parametro é menor que o numero de linhas ou o numero de linhas é menor
	 * que 0 uma excessão será lançada.
	 * 
	 * @param documento O documento a ser apresentado.
	 * @return A apresentacao do documento.
	 */
	@Override
	public String imprimir(String[] documento) {
		Objects.requireNonNull(documento, "Documento não pode ser nulo");
		if(this.numLinhas <= documento.length && numLinhas >= 0) {
			String resul = "";
			int posFinal = documento.length - this.numLinhas;
			for(int i = documento.length - 1; i >= posFinal; i--) {
				resul += documento[i] + "\n";
			}
			return resul.trim();
		}
		throw new IndexOutOfBoundsException("Quantidade de linhas invalidas");
	}

}
