import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        float salario;
        float valorAumento;
        float salarioAumento;

        Scanner ler = new Scanner(System.in);
        System.out.println("Digite seu salário atual: ");
        salario = ler.nextFloat();
        System.out.println("Digite o aumento em seu salário: ");
        valorAumento = ler.nextFloat();
        /*Inicializar a variável logo acima de onde será declarada!!*/
        salarioAumento = salario + valorAumento;
        /* Preferência em utilizar a formatação em printf e usar %.2f*/
        System.out.printf("Seu novo salário é de %.2f%n" , salarioAumento );


    }
}
