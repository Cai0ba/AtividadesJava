import java.util.Scanner;

public class ex09 {
    public static void main(String[] args) {
        int num = 1;
        Scanner ler = new Scanner(System.in);
        while (num != 0) {
            System.out.println("Digite um número: ");
            num = ler.nextInt();
num = num * 3;
            System.out.println("O triplo do valor é: " + num);
        }


    }
}
