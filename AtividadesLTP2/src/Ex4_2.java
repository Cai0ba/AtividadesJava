import java.util.Scanner;

public class Ex4_2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[] nome = new String[100];
        int codigo;
        int qtdePecas;
        int i;
        double[] salario = new double[100];
        double somaSalario = 0;
        double media ;
        for (i = 0; i < 100; i++) {// I == CONTADOR DE EMPREGADOS
            System.out.println("Digite o nome do empregado OU FIM para finalizar o programa:");
            nome[i] = ler.nextLine();
            if (nome[i].equalsIgnoreCase("FIM")) {
                break;
            }
            do {

                System.out.println("Digite o código :");
                codigo = ler.nextInt();
                if (codigo < 1 || codigo > 999) {
                    System.out.println("Código inválido insira novamente:");
                }
            } while (codigo < 1 || codigo > 999);
            do {
                System.out.println("Digite a quantidade de peças produzidas:");
                qtdePecas = ler.nextInt();
                if (qtdePecas <= 0) {
                    System.out.println("Número de peças inválida");

                }
            } while (qtdePecas <= 0);
            salario[i] = calculoSalario(qtdePecas);
            somaSalario += salario[i];
            ler.nextLine();


        }
        System.out.println("Nome:       Salário:      Média Salários");
        System.out.println("-------    ----------    -----------------");
        media = somaSalario / i;
        //Lembrando que I é o contador de empregados
        for (int j = 0; j < i; j++) {
            System.out.printf("%s", nome[j]);
            System.out.printf("        %.2f R$", salario[j]);
            System.out.printf("        %.2f\n R$", media);
        }
        System.out.printf("Total pago com salários: %.2f R$", somaSalario);
    }

    public static double calculoSalario(int pecas) {
        double salarioFim;
        if (pecas >= 1 && pecas <= 200) {
            salarioFim = pecas * 2.00;
        } else if (pecas >= 201 && pecas <= 400) {
            salarioFim = pecas * 2.30;
        } else {
            salarioFim = pecas * 2.50;
        }
        return salarioFim;
    }

}



