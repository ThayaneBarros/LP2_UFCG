package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaAvancada realiza uma operação de busca a partir dos metadados.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class BuscaAvancada implements BuscaInterface {
	
	private Map<String, String> metadados;
	
	/**
	 * Construtor padrão com o mapa de metadados a serem procurados.
	 * 
	 * @param metadados O mapa de metadados a serem pesquisados.
	 */
	public BuscaAvancada(Map<String, String> metadados) {
		(new ValidadorBusca()).validaMetadados(metadados);
		this.metadados = metadados;
	}

	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados.
	 */
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		
		for (Documento d : ds.busca(this.metadados)) {
			respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
		}
		return respostaDocumento;
	}
	
	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		int i = 0;
		for(String valorMetadados: this.metadados.keySet()) {
			resultado[i++] = new String[] {"METADADO " + (i + 1), valorMetadados + " " + this.metadados.get(valorMetadados)};
		}
		return resultado;
	}
	
}
