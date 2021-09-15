import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        double media = 0;
        int total = 0;
        int qtde;
        System.out.println("Digite a quantidade de números: ");
        qtde = ler.nextInt();

        for (int i = 0; i < qtde; i++) {
            System.out.println("Digite um número: ");
            int num = ler.nextInt();
            total = total + num;
        }
        System.out.println("A média é: ");

   media = total / qtde;
        System.out.println(media);




    }
}
