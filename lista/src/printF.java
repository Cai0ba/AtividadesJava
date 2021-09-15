import java.util.Scanner;

public class printF {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double valor;
        int idade;
        System.out.println("Digite sua idade");
        idade = ler.nextInt();
        System.out.println("Digite o valor:");
        valor = ler.nextDouble();

        System.out.printf("Sua idade é: %d e seu valor é %.3f",idade,valor);
    }

}
