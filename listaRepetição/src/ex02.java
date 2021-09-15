import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o número inicial");
        double soma = 0 ;
        int num1 = ler.nextInt();
        System.out.println("Digite o número final");
        int num2 = ler.nextInt();
   for(int i = 0 ; i<=num2 ; i++){
    int divisao = i % 2;
    if(divisao == 0){
soma = soma + i;

    }

   }
        System.out.println(soma);






    }
}

