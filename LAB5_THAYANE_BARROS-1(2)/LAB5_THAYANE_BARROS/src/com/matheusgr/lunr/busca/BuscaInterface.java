package com.matheusgr.lunr.busca;

import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Interface de busca.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public interface BuscaInterface {
	
	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * @param ds O DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados.
	 */
	Map<Documento, Integer> busca(DocumentoService ds);
	
	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca.
	 */
	String[][] descreveConsulta();

}
