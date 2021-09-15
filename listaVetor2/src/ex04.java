import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[8];
        int x, y;
        int soma;
        for (int i = 0; i < 8; i++) {
            System.out.println("Digite 8 valores na posição: " + i);
            vetor[i] = ler.nextInt();
        }
        System.out.println("Digite uma posição no vetor: ");
        x = ler.nextInt();
        System.out.println("Digite outra posição no vetor: ");
        y = ler.nextInt();


        soma = vetor[x]+ vetor[y];

        System.out.println(soma);

    }
}
