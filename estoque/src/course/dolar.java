package course;

import entities.utilDolar;
import java.util.Locale;
import java.util.Scanner;


public class dolar {
    public static void main(String[] args) {
      Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);
        System.out.print("What is the dollar price?");
        double price = ler.nextDouble();
        System.out.print("How many dollars do you need: ");
        double quantidade = ler.nextDouble();
        System.out.printf("Amount to be payed in reais(R$): %.2f%n ", utilDolar.CurencyConverter(price,quantidade) );

    }


}
