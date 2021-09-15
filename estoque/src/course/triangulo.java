package course;
import entities.triangle;
import java.util.Locale;
import java.util.Scanner;

public class triangulo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);
        triangle triangle = new triangle();
        System.out.println("Enter rectangle width and height");
    triangle.widht = ler.nextDouble();
    triangle.height = ler.nextDouble();
        System.out.printf("AREA = %.2f%n ",triangle.area());
        System.out.printf("PERIMETER = %.2f%n",triangle.perimeter());
        System.out.printf("DIAGONAL = %.2f%n",triangle.diagonal());




    }
}
