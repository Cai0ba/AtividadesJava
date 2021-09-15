import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int peso;
        double altura;

        System.out.println("Digite seu peso: ");
        peso = ler.nextInt();
        System.out.println("Digite sua altura em METROS: ");
        altura = ler.nextDouble();
        double imc = (peso / (Math.pow(altura, 2)));

        if (imc < 18.5) {
            System.out.printf("%.2f MAGREZA",imc);
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.printf("%.2f NORMAL",imc);
        } else if (imc >= 25.0 && imc <= 29.9) {
            System.out.printf("%.2f SOBREPESO",imc);
        } else if (imc >= 30.0 && imc < 39.9) {
            System.out.printf("%.2f OBESIDADE",imc);
        } else if (imc >= 40) {
            System.out.printf("%.2f OBESIDADE GRAVE",imc);




        }
    }
}