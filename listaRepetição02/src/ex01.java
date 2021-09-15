import java.util.Scanner;

public class ex01 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double valorX = 0;

        while (valorX < 1) {
            valorX = ler.nextInt();
            if (valorX < 1) {
                double valor1 = 4 - Math.pow(valorX, 2);
                System.out.println(valor1);
            }else if(valorX == 1){
                System.out.println("2");
            }else {
               double valor2 = 2 + Math.pow(valorX, 2) ;
                System.out.println(valor2);
            }


            // valorX = ler.nextInt();
            // double valor1 = 4 - Math.pow(valorX, 2);
            // System.out.println(valor1);
            // if (valorX == 1) {
            //  System.out.println(2);
            // } else if (valorX > 1) {
            //  double valor2 = 2 + Math.pow(valorX, 2);
            //  System.out.println(valor2);
            //  }


        }


    }
}
