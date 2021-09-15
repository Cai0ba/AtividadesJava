import java.util.Scanner;

public class triangulo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Enter the measures of triangle X: ");
        double a = ler.nextDouble();
        double b = ler.nextDouble();
        double c = ler.nextDouble();
        System.out.println("Enter the measures of triangle y: ");
        double ay = ler.nextDouble();
        double by = ler.nextDouble();
        double cy = ler.nextDouble();
        double perimetroX = (a + b + c) / 2;
        double perimetroY = (ay + by + cy) / 2;
        double areaX =  perimetroX * (perimetroY - ay) * (perimetroY - by) * (perimetroY - cy);
        double areaY = perimetroY * (perimetroY - ay) * (perimetroY - by) * (perimetroY - cy);
        double raizX = (Math.sqrt(areaX));
        double raizY = (Math.sqrt(areaY));
        System.out.println("Triangle X area: " + raizX);
        System.out.println("Triangle Y area: " + raizY);
        if (areaX > areaY) {
            System.out.println("Larger area X");
        } else {
            System.out.println("Larger area Y");
        }


    }
}
