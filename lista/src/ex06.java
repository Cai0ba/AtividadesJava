import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        char tipo;
        double litros;
        double resultado;
        Double resultadoFinal;
        System.out.println("Digite a quantidade de combustível: ");
        litros = ler.nextDouble();
        System.out.println("Digite o tipo de combustível:");
        tipo = ler.next().charAt(0);
        if (litros <= 20 && tipo == 'A') {
            resultado = (litros * 0.03);
            resultadoFinal = (litros - resultado) * 3.50;
            System.out.println(resultadoFinal);
        }
        if (litros > 20 && tipo == 'A'||tipo == 'a') {
            resultado = (litros * 0.05);
            resultadoFinal = (litros - resultado) * 3.50;
            System.out.println(resultadoFinal);
        }
       //GASOLINA//
        if (litros <= 20 && tipo == 'G'||tipo == 'g') {
            resultado = (litros * 0.04);
            resultadoFinal = (litros - resultado) * 4.60;
            System.out.println(resultadoFinal);
        }
        if (litros > 20 && tipo == 'G'||tipo == 'g') {
            resultado = (litros * 0.06);
            resultadoFinal = (litros - resultado) * 4.60;
            System.out.println(resultadoFinal);
        }
    }
}