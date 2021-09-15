
import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double altura;
        double peso;
        double imc;

        System.out.println("Digite seu peso: ");
        peso = ler.nextDouble();
        System.out.println("Digite sua altura em Metros: ");
        altura = ler.nextDouble();
        imc = peso / (altura * altura);
        System.out.println("Seu IMC é "+imc);
        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if ( imc <= 25) {
            System.out.println("Peso normal");
        } else if (imc <= 30) {
            System.out.println("Acima do peso");
        } else {
            System.out.println("Obeso");
        }

    }
}
