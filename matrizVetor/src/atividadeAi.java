import java.util.Scanner;

public class atividadeAi {
    public static void main(String[] args) {
        boolean continuar = true;
        char responder;
        double contFebre = 0, contTosseSeca = 0, contCansaco = 0
                , contDificRespirar = 0
                , contDoresCorpo = 0, contDorGarganta = 0
                , contDiarreia = 0, contConjunt = 0
                , contDorCabeca = 0, contPerdaPaladar = 0
                , contErupcao = 0;
        Scanner ler = new Scanner(System.in);
        double x = 0;

        do {
            int total = 0;

            System.out.println("Defina com [S] ou [N] os sintomas que você está sentindo.");
            System.out.println("Você possui febre? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 10;
                contFebre++;
            }
            System.out.println("Você possui Tosse seca? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 10;
                contTosseSeca++;
            }
            System.out.println("Você possui cansaço? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 8;
                contCansaco++;
            }
            System.out.println("Você possui Dificuldade de respirar ou falta de ar? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 10;
                contDificRespirar++;
            }
            System.out.println("Você possuie Dores pelo corpo? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 5;
                contDoresCorpo++;
            }
            System.out.println("Você possui Dor de garganta? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 5;
                contDorGarganta++;
            }
            System.out.println("Você possui Diarréia? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 3;
                contDiarreia++;
            }
            System.out.println("Você possui Conjuntivite? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 2;
                contConjunt++;
            }
            System.out.println("Você possui Dor de cabeça? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 5;
                contDorCabeca++;
            }
            System.out.println("Você possui Perda de paladar ou olfato? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 5;
                contPerdaPaladar++;
            }
            System.out.println("Você possui Erupção cutânea na pele ou" +
                    " descoloração dos dedos das mãos ou dos pés? ('S') ('N')");
            responder = ler.next().charAt(0);
            if (responder == 'S' || responder == 's') {
                total += 2;
                contErupcao++;
            }

            if (total > 40) {
                System.out.println("Você possui alta probabilidade! ");
            } else if (total >= 20 && total <= 39) {
                System.out.println("Média probabilidade");
            } else if (total >= 6 && total <= 19) {
                System.out.println("Baixa probabilidade");
            } else {
                System.out.println("Insignificante");
            }
            System.out.println("Seu total foi de: " + total);

            x++;
            System.out.println("Deseja continuar? ('S') ('N') ");
            responder = ler.next().charAt(0);
            if (responder == 'N' || responder == 'n') {
                continuar = false;
            }

        } while (continuar);
        System.out.println("Voce deseja saber os dados estatísticos? ('S') ('N')");
        responder = ler.next().charAt(0);
        if (responder == 'S' || responder == 's') {
            System.out.println("Percentual de pacientes com febre: " + contFebre * 100 / x + "%");
            System.out.println("Percentual de pacientes com Tosse seca: " + contTosseSeca * 100 / x + "%");
            System.out.println("Percentual de pacientes com Cansaço: " + contCansaco * 100 / x + "%");
            System.out.println("Percentual de pacientes com Dificuldade de respirar ou falta de ar: " + contDificRespirar * 100 / x + "%");
            System.out.println("Percentual de pacientes com Dores pelo corpo: " + contDoresCorpo * 100 / x + "%");
            System.out.println("Percentual de pacientes com Dor de garganta: " + contDorGarganta * 100 / x + "%");
            System.out.println("Percentual de pacientes com Diarréia: " + contDiarreia * 100 / x + "%");
            System.out.println("Percentual de pacientes com Conjuntivite: " + contConjunt * 100 / x + "%");
            System.out.println("Percentual de pacientes com Dor de cabeça: " + contDorCabeca * 100 / x + "%");
            System.out.println("Percentual de pacientes com Perda de paladar ou olfato: " + contPerdaPaladar * 100 / x + "%");
            System.out.println("Percentual de pacientes com Erupção cutânea na pele ou descoloração dos dedos das mãos ou dos pés: " + contErupcao * 100 / x + "%");


        }
    }
}
