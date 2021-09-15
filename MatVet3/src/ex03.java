import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner ler =  new Scanner (System.in);
        int vetor[] = new int [6];

        System.out.println("Digite valores pares: ");
        for(int i = 0; i<6; i++) {
            vetor[i] = ler.nextInt();
            if(vetor[i]%2==0) {

            }
            else {
                i--;
                System.out.println("Digite só valores pares: ");
            }
        }

        for(int x = 5; x>=0; x--) {
            System.out.println(vetor[x]);
        }

    }
    }

