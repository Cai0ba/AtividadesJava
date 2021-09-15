import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {

        int valor1, valor2, valor3, maior = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o primeiro valor");
        valor1 = ler.nextInt();
        System.out.println("Digite o segundo valor");
        valor2 = ler.nextInt();
        System.out.println("Digite o terceiro valor");
        valor3 = ler.nextInt();
        maior = valor1;

        if (valor2 > maior) {
            maior = valor2;
        }
        if (valor2 > valor1) {
        }
        if (valor3 > maior) {
            maior = valor3;
        }
        System.out.println("O maior valor é: "+maior);


    }
}
