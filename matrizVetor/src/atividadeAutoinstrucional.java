import java.util.Scanner;

public class atividadeAutoinstrucional {
    public static void main(String[] args) {
        int sintoma = 0;
        Scanner ler = new Scanner(System.in);
        int total = 0;
        // int nPacientes = 0;
        int contf = 0, contt = 0, contc = 0, contd = 0, contdc = 0, contdg = 0, contdi = 0, contco = 0, contdoc = 0, contpp = 0, conte = 0;

        // System.out.println("Digite a quantidade de pacientes a serem colocados");
        //  nPacientes = ler.nextInt();
        System.out.println("Digite valores respectivo ao sintoma que você esta sentindo:");
        System.out.println("""
                             
                1- Febre
                2- Tosse seca
                3- Cansaço
                4- Dificuldade de respirar ou falta de ar
                5- Dores pelo corpo
                6- Dor de garganta
                7- Diarréia
                8- Conjuntivite
                9- Dor de cabeça
                10- Perda de paladar ou olfato
                11- Erupção cutânea na pele ou descoloração dos dedos das mãos ou dos pés""");

        for (int i = 0; i < 100; i++) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Digite um valor relativo ao sintoma, ao final digite 100 para finalizar o programa:");
            sintoma = ler.nextInt();
            if (sintoma == 1) {
                System.out.println("Febre");
                total += 10;
                contf++;
            }
            if (sintoma == 2) {
                System.out.println("Tosse seca");
                total += 10;
            }
            if (sintoma == 3) {
                System.out.println("Cansaço");
                total += 8;
            }
            if (sintoma == 4) {
                System.out.println("Dificuldade de respirar ou falta de ar");
                total += 10;
            }
            if (sintoma == 5) {
                System.out.println("Dores pelo corpo");
                total += 5;
            }
            if (sintoma == 6) {
                System.out.println("Dor de garganta");
                total += 5;
            }
            if (sintoma == 7) {
                System.out.println("Diarréia");
                total += 3;
            }
            if (sintoma == 8) {
                System.out.println("Conjuntivite");
                total += 2;
            }
            if (sintoma == 9) {
                System.out.println("Dor de cabeeça");
                total += 5;
            }
            if (sintoma == 10) {
                System.out.println("Perda de paladar ou olfato");
                total += 5;
            }
            if (sintoma == 11) {
                System.out.println("Erupção cutânea na pele ou descoloração dos dedos das mãos ou dos pés");
                total += 2;
            }
            if (sintoma > 11) {
                System.out.println("Valor não encontrado, digite um novo valor ou insira \"100\" para fazer a estimativa");
                if (sintoma == 100) {
                    System.out.println("Sua pontuação é de: " + total);
                    if (total > 40) {
                        System.out.println("Você possui alta probabilidade!");
                    } else if (total >= 20 && total <= 39) {
                        System.out.println("Média probabilidade");
                    } else if (total >= 6 && total <= 19) {
                        System.out.println("Baixa probabilidade");
                    } else {
                        System.out.println("Insignificante");
                    }
                }

            }


        }
    }

}






























                /*switch (sintoma) {

                    case 1 -> {
                        System.out.println("Febre");
                        int febre = 10;
                    }
                    case 2 ->{
                        System.out.println("Tosse seca");
                    int tosse = 10;
                    }
                    case 3 ->{
                        System.out.println("Cansaço");
                        int cansaco = 8;
                    }

                    case 4 ->{
                        System.out.println("Dificuldade de respirar ou falta de ar");
                        int faltaAr = 10;
                    }

                    case 5 ->{
                        System.out.println(" Dores pelo corpo");
                        int dores = 5;
                    }

                    case 6 ->{
                        System.out.println("Dor de garganta");
                        int dorGarganta = 5;
                    }

                    case 7 -> {
                        System.out.println("Diarréia");
                        int diarreia = 3;
                    }

                    case 8 -> {
                        System.out.println("Conjuntivite");
                        int conjuntivite = 2;
                    }

                    case 9 -> {
                        System.out.println("Dor de cabeça");
                        int dorCabeca = 5;
                    }

                    case 10 -> {
                        System.out.println("Perda de paladar ou olfato");
                        int perdaPaladar = 5;
                    }

                    case 11 -> {
                        System.out.println(" Erupção cutânea na pele ou descoloração dos dedos das mãos ou dos pés");
                        int erupcao = 2;



                    }

                }

            }


        }
        System.out.println(sintoma);*/