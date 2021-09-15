import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class ex {
    public static void main(String[] args) {
        String nome;
        char sexo;
        float salario;
        byte idade;
        Scanner ler;
        ler = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        nome = ler.nextLine();
        System.out.println("Digite o salário:");
        salario = ler.nextFloat();
        System.out.println("Digite a idade:");
        idade = ler.nextByte();
        System.out.println("Digite o sexo:");
        sexo = ler.next().charAt(0);
        System.out.println("O nome digitado foi: " + nome);
        System.out.println("O salário digitado foi: " + idade);
        System.out.println("A idade digitada foi: " + idade);
        System.out.println("O sexo digitado foi" + sexo);

    }
}
