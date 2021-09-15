import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int x;
        int n;
        System.out.println("Digite o X: ");
        x = ler.nextInt();
        System.out.println("Digite o N: ");
        n = ler.nextInt();
        for (int i = 1; i <= x; i++) {
            double resultado = i % n;
            if(resultado == 0){
                System.out.println(i);
            }
        }








    }


}
