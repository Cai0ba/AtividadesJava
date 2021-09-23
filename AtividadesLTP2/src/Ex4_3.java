import java.util.*;

public class Ex4_3 {
    static String[] vetCidade = {"BELO HORIZONTE", "SÃO PAULO", "RIO DE JANEIRO", "SALVADOR", "CURITIBA"};

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String[] nome = new String[100];
        float[] valorConta = new float[100];
        int numPessoas;
        String quarto;
        String cidade;
        int entrada;
        int saida;

        for (numPessoas = 0; numPessoas < 99; numPessoas++) {
            System.out.println("Digite o nome do Hospede ou FIM para encerrar o programa: ");
            nome[numPessoas] = leia.nextLine();
            if (nome[numPessoas].equalsIgnoreCase("FIM")) {
                break;
            }

            do {
                System.out.println("Digite o dia da entrada: ");
                entrada = leia.nextInt();
                System.out.println("Digite o dia de saida: ");
                saida = leia.nextInt();
                if (entrada > saida) {
                    System.out.println("Digite um valor correto");
                }
            } while (entrada > saida);
            leia.nextLine();

            //tipo quarto
            do {
                System.out.println("Digite o tipo de quarto que ira se hospedar STANDARD - LUXO - SUPER-LUXO: ");
                quarto = leia.nextLine();
                if (!quarto.equalsIgnoreCase("STANDARD") && !quarto.equalsIgnoreCase("LUXO") && !quarto.equalsIgnoreCase("SUPER-LUXO")) {
                    System.out.println("Invalido, os quartos disponiveis são STANDARD, LUXO e SUPER-LUXO");
                }
            } while (!quarto.equalsIgnoreCase("STANDARD") && !quarto.equalsIgnoreCase("LUXO") && !quarto.equalsIgnoreCase("SUPER-LUXO"));

            do {
                System.out.println("Digite a Cidade de hospedagem: ");
                cidade = leia.nextLine();
                if (!cidadeEhValida(cidade)) {
                    System.out.println("Cidade invalida");
                }
            } while (!cidadeEhValida(cidade));

            valorConta[numPessoas] = calcularPagamento(entrada, saida, quarto);

        }
        System.out.println("Relatório de contas acima da média");
        System.out.println("Nome do Hóspede            Valor Conta");
        System.out.println("----------------           -------------");
        for(int i = 0; i < numPessoas; i++){
            System.out.printf("%s                       %.2f\n",nome[i],valorConta[i]);
        }
    }

    public static boolean cidadeEhValida(String cidade) {
        boolean validaCidade = false;
        for (int i = 0; i < 5; i++) {
            if (cidade.equalsIgnoreCase(vetCidade[i])) {
                validaCidade = true;
            }
        }
        return validaCidade;
    }

    public static float calcularPagamento(int diaEntrada, int diaSaida, String quarto) {
        float valorConta;
        int valorDiaria;
        if (quarto.equalsIgnoreCase("STANDARD")) {
            valorDiaria = 120;
        } else if (quarto.equalsIgnoreCase("LUXO")) {
            {
                valorDiaria = 150;
            }
        } else {
            valorDiaria = 180;
        }
        valorConta = (diaSaida - diaEntrada) * valorDiaria;
        return valorConta;
    }
}
//te amo caiozinho (nao me mata)
