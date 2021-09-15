package course;

import entities.product;

import java.util.Locale;
import java.util.Scanner;

public class estoque {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        product product = new product();
        System.out.println("Enter product data: ");
        System.out.println("Name: ");
        product.name = ler.nextLine();
        System.out.println("Price: ");
        product.price = ler.nextDouble();
        System.out.print("Quantity in stock: ");
        product.quantity = ler.nextInt();
        System.out.println();
        System.out.println("Product data: " + product);
        System.out.println();
        System.out.println("Enter the number of products to be added in stock:");
        int quantity = ler.nextInt();
        product.AddProducts(quantity);
        System.out.println("Updated data:" + product);
        System.out.println();
        System.out.println("Enter the number of products to be removed from stock: ");
        quantity = ler.nextInt();
        product.RemoveProducts(quantity);
        System.out.println("Updated data:" + product);

        ler.close();
    }

}
