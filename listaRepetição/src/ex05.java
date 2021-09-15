import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int num , maior= 0;
        for(int i = 0 ; i<10 ; i++){
            System.out.println("Digite um número: ");
            num = ler.nextInt();
    if(num > maior){
        maior = num;

    }


}
        System.out.println("O maior número é: " + maior);


    }
}
