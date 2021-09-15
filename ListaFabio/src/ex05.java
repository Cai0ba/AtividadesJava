import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        char letra;
        System.out.println("Digite apenas uma letra:");
        letra = ler.next().charAt(0);
        if(letra == 'A'|| letra == 'a'||letra == 'E'||letra == 'e'||letra == 'I'
                ||letra == 'i'||letra == 'O'||letra == 'o'||letra == 'U'||letra == 'u'){
            System.out.println("Vogal");
        }else {
            System.out.println("Consoante");
        }
    }
}
