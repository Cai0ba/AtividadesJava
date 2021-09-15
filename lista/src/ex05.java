import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);

        boolean primeira;
        boolean segunda;
        boolean terceira;
        boolean quarta;
        boolean quinta;
        int cont = 0;

        System.out.print("Você telefonou para a vitima? ");
        primeira = leia.nextBoolean();
        System.out.print("Você esteve no local do crime? ");
        segunda = leia.nextBoolean();
        System.out.print("Você mora perto da vitima? ");
        terceira = leia.nextBoolean();
        System.out.print("Você devia para a vitima? ");
        quarta = leia.nextBoolean();
        System.out.print("Você ja trabalhou com a vitima? ");
        quinta = leia.nextBoolean();


        if(primeira) {
            cont++;
        }
        if(segunda) {
            cont++;
        }
        if(terceira) {
            cont++;
        }
        if(quarta) {
            cont++;
        }
        if(quinta) {
            cont++;
        }

        if(cont<2) {
            System.out.println("Você é inocente");
        }
        else if(cont==2) {
            System.out.println("Você é suspeito");
        }
        else if(cont==3 || cont==4) {
            System.out.println("Você é cumplice");
        }
        else {
            System.out.println("Você é assassino");
        }
    }

}


