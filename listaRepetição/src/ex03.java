import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int num = ler.nextInt();
        for (int i = 1; i < num + 1; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }


    }
}
