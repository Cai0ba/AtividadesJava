import java.util.Scanner;

public class ex03 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome;
        double nota;
        double desconto;
        double valor;
        System.out.println("Digite o nome do aluno: ");
        nome = ler.nextLine();
        System.out.println("Digite sua média: ");
        nota = ler.nextDouble();
        System.out.println("Digite o valor da mensalidade: ");
        valor = ler.nextDouble();
        if (9.0 < nota && nota <= 10.0) {
            System.out.println(nome);
            System.out.println("Conceito: A");
            desconto = valor * 0.15 - valor;
            System.out.println("Sua nova mensalidade é de: " + desconto);

        } else if (7.5 < nota && nota <= 9.0) {
            System.out.println(nome);
            System.out.println("Conceito: B");
            desconto = valor * 0.10 - valor;
            System.out.println("Sua nova mensalidade é de: " + desconto);

        } else if (6.0 < nota && nota <= 7.5) {
            System.out.println(nome);
            System.out.println("Conceito: C");
            desconto = valor * 0.05 - valor;
            System.out.println("Sua nova mensalidade é de: " + desconto);

        } else if (4.0 < nota && nota <= 6.0) {
            System.out.println(nome);
            System.out.println("Conceito: D");
            desconto = valor;
            System.out.println("Sua nova mensalidade é de: " + desconto);
        } else if (nota <= 4.0) {
            System.out.println(nome);
            System.out.println("Conceito: E");
            desconto = valor;
            System.out.println("Sua nova mensalidade é de: " + desconto);
        }


    }

}
