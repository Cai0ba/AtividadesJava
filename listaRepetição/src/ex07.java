import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
int par = 0;

        for (int i=0 ; i<20 ; i++){
            System.out.println("Digite um número");
            int num = ler.nextInt();
   if(num % 2 == 0){
par = par + 1;

}

        }
       int impar = 20 - par;
        System.out.println("Existem " + par + " números pares!");
        System.out.println("Existem " + impar + " números ímpares!" );

  }


    }

