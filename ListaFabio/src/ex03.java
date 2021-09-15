import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        int valor;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um número");
        valor = ler.nextInt();
if (valor >= 0 && valor <=10){
    System.out.println("O valor está entre 0 e 10");
}else{
    System.out.println("O valor não está entre 0 e 10");

}

    }
}
