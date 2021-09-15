import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        double media[] = new double[4];
        double result = 0;
        System.out.println("Digite 4 números: ");
        for(int i = 0; i<4; i++) {
            media[i] = leia.nextDouble();
            result = (media[0]+media[1]+media[2]+media[3])/4;
        }
        System.out.println("A media dos números é: "+result);
    }

}
