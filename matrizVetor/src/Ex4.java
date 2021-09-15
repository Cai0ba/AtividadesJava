import java.util.ArrayList;
import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        ArrayList<String> nome = new ArrayList();
        ArrayList<Double> idade = new ArrayList();
        ArrayList<Double> salario = new ArrayList();

        String nome2;
        double idade2;
        double salario2;

        int n;
        System.out.println("Digite a quantidade de pessoas: ");
        n = ler.nextInt();

        for (int x = 0; x < n; x++) {
            System.out.println("Digite o nome: ");
            nome2 = ler.next();
            System.out.println("Digite a  idade: ");
            idade2 = ler.nextInt();
            System.out.println("Digite o salario: ");
            salario2 = ler.nextDouble();

            nome.add(nome2);
            idade.add(idade2);
            salario.add(salario2);
        }

        for (int x = 0; x < n; x++) {
            System.out.println(nome.get(x));
            System.out.println(idade.get(x));
            System.out.println(salario.get(x));
        }

    }
}

