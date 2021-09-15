import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        int valor;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um valor inteiro:");
        valor = ler.nextInt();
        if(valor%2==0){
            System.out.println("Par");
        }else{
            System.out.println("Ímpar");
        }


    }
}
