import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        double[] numerReal = new double[10];
        double[] result = new double[10];
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite os valores reais");
        for (int i = 0; i < 10; i++) {
            numerReal[i] = leia.nextDouble();
            result[i] = Math.pow(numerReal[i], 2);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(result[i]);
        }
    }
}