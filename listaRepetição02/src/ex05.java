import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        double maior = 0;
        double menor = 10000;
        Scanner ler = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite a altura: ");
            double altura = ler.nextDouble();
            if (altura < menor) {
                menor = altura;
            }
            if (altura > maior) {
    maior = altura;
            }


        }
        System.out.println("A maior altura é: " + maior);
        System.out.println("A menor altura é:" + menor);
    }
}