import java.util.Scanner;

public class ex01 {


    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[10];
   for (int i = 0; i<10 ; i++ ){
       System.out.println("Digite um valor na posição: " + i);
     vetor[i] = ler.nextInt();
   }
int maior = vetor[0];
   int posicao = 1;

for (int i = 0 ; i<10 ; i++ ){
    System.out.println(vetor[i]);
    if(vetor[i] > maior){
        maior = vetor[i];
        posicao = i;
    }
}
        System.out.println("O maior elemento é " + maior +" na posição " + posicao);






    }
}
