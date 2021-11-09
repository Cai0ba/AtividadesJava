import java.util.*;

public class Ex6_2 {
    public static void main(String[] args) {
        String[] nomes = new String[30];
        int i;
        char vetorNome[];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < 30; i++) {
            do {
                System.out.println("Digite o seu Nome Completo:");
                nomes[i] = ler.nextLine();
                if (nomes[i].length() < 15) {
                    System.out.println("É necessário ter mais de 15 caracteres no nome!");
                    break;
                }
                vetorNome = nomes[i].toCharArray();
                if (vetorNome[0] == ' ') {
                    System.out.println("Teste");
                }
            } while (nomes[i].length() > 15);


        }


    }

    static String gerarLogin(String nome) {

        return null;
    }
}
