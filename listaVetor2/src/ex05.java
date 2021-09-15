import java.util.List;
import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int cont = 0;
        int vetor[] = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um valor no vetor para a posição " + i);
            vetor[i] = ler.nextInt();
            if (vetor[i] % 2 == 0 ){
                cont++;
            }
        }
        System.out.println("Existem " + cont +" valores pares");

    }
}
