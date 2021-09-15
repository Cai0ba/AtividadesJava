import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double salarioB, prest;
        System.out.println("Digite o salário bruto: ");
        salarioB = ler.nextDouble();
        System.out.println("Insira o valor da prestação: ");
        prest = ler.nextDouble();
if (prest < (salarioB * 0.3)){
    System.out.println("Empréstimo concedido");
}else{
    System.out.println("Empréstimo negado");
}





    }
}
