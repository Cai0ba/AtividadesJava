import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        double valorFinal = 0;
        System.out.println("Digite o valor do produto");
        double valor = ler.nextDouble();


        System.out.println("Escolha uma das opções de pagamento abaixo:");
        System.out.println("(1) Pagamento com dinheiro ou cheque");
        System.out.println("(2) Pagamento à vista no cartão de crédito");
        System.out.println("(3)Em duas vezes");
        System.out.println("(4)Em três vezes");
        opcao = ler.nextInt();
        if (opcao == 1) {
            valorFinal = valor * 0.90;
            System.out.println("Recebe 10% de desconto R$ " +valorFinal);

        } else if (opcao == 2) {
            valorFinal = valor * 0.85;
            System.out.println("Recebe 15% de desconto R$ "+ valorFinal);
        } else if (opcao == 3) {
            System.out.println("Valor Normal R$ %.2f%n"+ valorFinal);
        } else if (opcao == 4) {
valorFinal = valor * 1.10;
            System.out.println("Preço normal de etiqueta mais juros de 10% R$ " + valorFinal);
        }


    }
}