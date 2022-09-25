package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe BuscaRepository
 * 
 * @author Thayane Barros - 121110604
 *
 */
class BuscaRepositoryTest extends BaseBuscaTest {

	private BuscaRepository buscaRepository;
	
	@BeforeEach
	void testCriaBuscaRepository() {
		this.buscaRepository = new BuscaRepository();
		
		// Realiza algumas buscas
		this.buscaService.busca(this.buscaAvancada);
		this.buscaService.busca(new BuscaSimples(new String[] {"use", "teste"}));
	}
	
	@Test
	void testRecuperaValorAbaixoLimiteInferior() {
		try{
			this.buscaRepository.recuperar(-1);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testRecuperaValorAcimaLimiteSuperior() {
		try{
			this.buscaRepository.recuperar(2);
			fail("Era esperado uma excessão aqui");
		} catch(IllegalArgumentException ae) {
			
		}
	}
}