package course;

import entities.salary;

import java.util.Locale;
import java.util.Scanner;

public class salario {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);
        salary salary = new salary();


        System.out.print("Name: ");
        salary.name = ler.nextLine();
        System.out.print("Gross salary: ");
        salary.GrossSalary = ler.nextDouble();
        System.out.print("Tax: ");
        salary.tax = ler.nextDouble();
        System.out.println();
        System.out.println("Employee"+salary);
        System.out.println();
        System.out.println("Which percentage to increase salary?");

        double porc = ler.nextDouble();
        salary.IncreaseSalary(porc);

        System.out.println();
        System.out.println("Updated data: " + salary);

    }
}
