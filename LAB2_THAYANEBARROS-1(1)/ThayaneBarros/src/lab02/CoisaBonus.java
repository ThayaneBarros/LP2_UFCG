package lab02;
/**
 * Classe que exercita as funcionalidades implementadas no lab2.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class CoisaBonus {
	
	/**
	 * Classe principal do programa.
	 * 
	 * @param args os argumentos passados ao invocar o programa
	 */
   public static void main(String[] args) {
       descanso();
       System.out.println("-----");
       registroOnline();
       System.out.println("-----");
       disciplina();
       System.out.println("-----");
       atividadesComplementares();
   }
   public static void descanso() {
       Descanso descanso = new Descanso();
       System.out.println(descanso.getStatusGeral());
       descanso.defineHorasDescanso(30);
       descanso.defineNumeroSemanas(1);
       descanso.definirEmoji("*_*"); 
       System.out.println(descanso.getStatusGeral());
       descanso.defineHorasDescanso(60);
       descanso.defineNumeroSemanas(2);
       System.out.println(descanso.getStatusGeral());
       descanso.defineHorasDescanso(26);
       descanso.defineNumeroSemanas(2);
       System.out.println(descanso.getStatusGeral());
       descanso.defineHorasDescanso(26);
       descanso.defineNumeroSemanas(1);
       descanso.definirEmoji("<(^_^<)"); 
       System.out.println(descanso.getStatusGeral());
   }
   private static void registroOnline() {
       RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
       tempoLP2.adicionaTempoOnline(10);
       System.out.println(tempoLP2.atingiuMetaTempoOnline());
       tempoLP2.adicionaTempoOnline(10);
       tempoLP2.adicionaTempoOnline(10);
       System.out.println(tempoLP2.atingiuMetaTempoOnline());
       tempoLP2.adicionaTempoOnline(2);
       System.out.println(tempoLP2.atingiuMetaTempoOnline());
       System.out.println(tempoLP2.toString());
       RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2");
       System.out.println(tempoP2.toString());
   }
   private static void disciplina() {
       Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
       prog2.cadastraHoras(4);
       prog2.cadastraNota(1, 5.0);
       prog2.cadastraNota(2, 6.0);
       prog2.cadastraNota(3, 7.0);
       System.out.println(prog2.aprovado());
       prog2.cadastraNota(4, 10.0);
       System.out.println(prog2.aprovado());
       System.out.println(prog2.toString());
       
       Disciplina lab2 = new Disciplina("LABORATÓRIO 2", 2);
       lab2.cadastraHoras(8);
       lab2.cadastraNota(1, 6.0);
       lab2.cadastraNota(2, 5.5);
       System.out.println(lab2.aprovado());
       lab2.cadastraNota(2, 8.2);
       System.out.println(lab2.aprovado());
       System.out.println(lab2.toString());
       
       Disciplina calculo2 = new Disciplina("CALCULO 2", 2, new int[]{6, 4});
       calculo2.cadastraHoras(2);
       calculo2.cadastraNota(2, 7.0);
       calculo2.cadastraNota(1, 6.2);
       System.out.println(calculo2.aprovado());
       calculo2.cadastraNota(2, 9.0);
       System.out.println(calculo2.aprovado());
       System.out.println(calculo2.toString());
       
   }
   private static void atividadesComplementares() {
       AtividadesComplementares minhasAtividades = new AtividadesComplementares();
       minhasAtividades.adicionarEstagio(600, 4);
       minhasAtividades.adicionarProjeto(7);
       minhasAtividades.adicionarCurso(50);
       String[] atividades = minhasAtividades.pegaAtividades();
       for (int i = 0; i < atividades.length; i++) {
           System.out.println(minhasAtividades.pegaAtividades()[i]);
       }
       System.out.println(minhasAtividades.contaCreditos());
 
       minhasAtividades.adicionarEstagio(400, 8);
       minhasAtividades.adicionarProjeto(6);
       minhasAtividades.adicionarCurso(40.5);
      
       atividades = minhasAtividades.pegaAtividades();
       for (int i = 0; i < atividades.length; i++) {
           System.out.println(minhasAtividades.pegaAtividades()[i]);
       }
       System.out.println(minhasAtividades.contaCreditos());
   }
}