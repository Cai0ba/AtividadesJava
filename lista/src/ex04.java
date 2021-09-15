import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        double meses;
        double juros;
        double salarioIn;
        double salarioFn;

        System.out.print("Digite o número de mêses: ");
        meses = leia.nextDouble();
        System.out.print("Digite o juros em %: ");
        juros = leia.nextDouble();
        System.out.print("Digite o saldo inicial: ");
        salarioIn = leia.nextDouble();

        salarioFn = salarioIn + (salarioIn*(juros/100)*meses);

        System.out.print("O seu saldo final é: "+salarioFn);
    }

}

