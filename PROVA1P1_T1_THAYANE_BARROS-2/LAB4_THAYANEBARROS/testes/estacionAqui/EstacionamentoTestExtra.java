package estacionAqui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da classe Estacionamento
 * 
 * @author Thayane Barros - 121110604
 *
 */
class EstacionamentoTestExtra {

	private Estacionamento vaga1;
	private Estacionamento vaga2;
	
	@BeforeEach
	void criaEstacionamento() {
		this.vaga1 = new Estacionamento();	
		this.vaga2 = new Estacionamento();	
		
		vaga2.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75);
	}
	
	@Test
	void testSimularPreco() {
		assertEquals(vaga2.simularPreco(0, 3), 10.37);
	}
	
	@Test
	void testSimularPrecoComPosicaoInvalida() {
		try {
			this.vaga2.simularPreco(-1, 0);
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testSimularPrecoComHoraInvalida() {
		try {
			this.vaga2.simularPreco(0, -1);
		} catch(IllegalArgumentException ae) {
			
		}
	}
	
	@Test
	void testAdicionarVagas() {
		assertEquals(vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75), 0);
	}
	
	@Test
	void testAdicionarVagasUltimaPosicao() {
		for(int i = 0; i < 99; i ++) {
			vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75);
		}
		assertEquals(vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75), 99);
	}
	
	@Test
	void testVagasAtivas() {
		vaga2.adicionarVagas("Rua dr Joao Moura, Sao Jose", "https://goo.gl/maps/raoKQyjFmS7kfKnu8", 9.87);
		assertEquals(vaga2.vagasAtivas(), 2);
	}
	
	@Test
	void testVagasAtivasSemVagas() {
		assertEquals(vaga1.vagasAtivas(), 0);
	}
	
	@Test
	void testVagaLivreSemVagasCadastradas() {
		assertEquals(vaga1.vagaLivre(), -1);
	}
	
	@Test
	void testVagaLivreCom1VagaCadastrada() {
		assertEquals(vaga2.vagaLivre(), 0);
	}
	
	@Test
	void testVagaLivreCom2VagaCadastrada() {
		vaga2.adicionarVagas("Rua dr Joao Moura, Sao Jose", "https://goo.gl/maps/raoKQyjFmS7kfKnu8", 9.87);
		assertEquals(vaga2.vagaLivre(), 0);
	}
	
	@Test
	void testVagaLivreCom2VagaCadastrada2() {
		this.vaga2.mudarStatus(0);
		vaga2.adicionarVagas("Rua dr Joao Moura, Sao Jose", "https://goo.gl/maps/raoKQyjFmS7kfKnu8", 9.87);
		assertEquals(vaga2.vagaLivre(), 1);
	}
	
	@Test
	void testBuscaVagaLivrePorEnderecoEarea() {
		assertEquals(vaga2.buscaVagaLivrePorEnderecoEarea("Rua dr Joao Moura, Sao Jose", 13.75), 0);
	}
	
	@Test
	void testBuscaVagaLivrePorEnderecoEareaSemVagas() {
		assertEquals(vaga1.buscaVagaLivrePorEnderecoEarea("Rua dr Joao Moura, Sao Jose", 13.75), -1);
	}
	
	@Test
	void testListaRelatorio() {
		vaga2.adicionarVagas("Rua dr Joao Moura, Sao Jose", "https://goo.gl/maps/raoKQyjFmS7kfKnu8", 9.87);
		vaga2.mudarStatus(0);
		
		String saida = "Vaga 0 - 1\n"
				+ "Vaga 1 - 0";
		
		assertEquals(this.vaga2.listaRelatorio(), saida);
	}
	
	@Test
	void testListarVagas() {
		vaga2.adicionarVagas("Rua dr Joao Moura, Sao Jose", "https://goo.gl/maps/raoKQyjFmS7kfKnu8", 9.87);
		vaga2.mudarStatus(0);
		
		String saida = "0 - Rua dr Joao Moura, Sao Jose - https:// - OCUPADA\n"
				+ "1 - Rua dr Joao Moura, Sao Jose - https://goo.gl/maps/raoKQyjFmS7kfKnu8 - LIVRE";
		
		assertEquals(this.vaga2.listarVagas(), saida);
	}
}
