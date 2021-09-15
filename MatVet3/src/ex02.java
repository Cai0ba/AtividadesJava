import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int [6];
        for(int i = 0; i < 6 ; i++){
            System.out.println("Digite um valor na posição: "+i);
      vetor[i] = ler.nextInt();

        }
        for (int i = 5 ; i>=0 ; i--){
    System.out.println(vetor[i]);
}





    }
}
