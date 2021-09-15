import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
       int valor;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um valor inteiro:");
        valor = ler.nextInt();
        if (valor <= 0) {
            valor = valor * -1;

        }
        System.out.println("O valor digitado foi: " + valor);


    }
}
