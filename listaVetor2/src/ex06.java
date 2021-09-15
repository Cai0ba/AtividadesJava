import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[10];
        int maior = 0;
        int menor = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um número na posição " + i);
            vetor[i] = ler.nextInt();
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
            if (vetor[i] < menor) {
                menor = vetor[i];
            }


        }
        System.out.println("O maior número é: " + maior);
        System.out.println("O menor número é: " + menor);


    }
}
