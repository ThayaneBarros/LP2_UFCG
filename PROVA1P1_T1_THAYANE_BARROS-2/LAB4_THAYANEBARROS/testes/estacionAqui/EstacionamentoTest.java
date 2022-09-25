package estacionAqui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe responsavel por testar os metodos da funcionalidades de informar vaga livre do EstacionAqui
 * 
 * @author Thayane Barros - 121110604
 *
 */
class EstacionamentoTest {
	
	private Estacionamento vaga1;
	
	@BeforeEach
	void criaEstacionamento() {
		this.vaga1 = new Estacionamento();	
	}
	
	@Test
	void testVagaLivreSemVaga() {
		assertEquals(this.vaga1.vagaLivre(), -1);
	}
	
	@Test
	void testVagaLivreCom1VagaAdicionada() {
		this.vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75);
		assertEquals(this.vaga1.vagaLivre(), 0);
	}
	
	@Test
	void testVagaLivreCom1VagaAdicionadaEocupada() {
		this.vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75);
		this.vaga1.mudarStatus(0);
		assertEquals(this.vaga1.vagaLivre(), -1);
	}
	
	@Test
	void testVagaLivreComTodasAsVagasOcupadas() {
		for(int i = 0; i < 100; i ++) {
			this.vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75);
			this.vaga1.mudarStatus(i);
		}
		assertEquals(this.vaga1.vagaLivre(), -1);
	}
	
	@Test
	void testVagaLivreNaUltimaPosicao() {
		for(int i = 0; i < 99; i ++) {
			this.vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75);
			this.vaga1.mudarStatus(i);
		}
		this.vaga1.adicionarVagas("Rua dr Joao Moura, Sao Jose", 13.75);
		assertEquals(this.vaga1.vagaLivre(), 99);
	}

}
