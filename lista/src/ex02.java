import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {


        Scanner leia = new Scanner(System.in);

        double altura, base, perimetro, area;

        System.out.println("Digite a base:");
        base = leia.nextDouble();
        System.out.println("Digite a altura:");
        altura = leia.nextDouble();

        area = base * altura;
        perimetro = 2 * (base + altura);

        System.out.println(" o perimetro é " + perimetro + " e a sua area e de " + area);

    }
}


