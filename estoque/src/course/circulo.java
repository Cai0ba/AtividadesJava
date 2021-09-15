package course;

import entities.circle;

import java.util.Scanner;

public class circulo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = ler.nextDouble();
        double c = circle.circumference(radius);

        double v = circle.volume(radius);
        System.out.printf("Circumference %.2f%n", c);
        System.out.printf("Volume: %.2f%n",v);
        System.out.printf("PI %.2f%n", circle.PI);
    }

}

