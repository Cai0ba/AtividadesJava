package entities;

public class salary {


    public String name;
    public double GrossSalary;
    public double tax;

    public double NetSalary() {
        return GrossSalary - tax;
    }


    public void IncreaseSalary(double porc) {
        GrossSalary += GrossSalary * porc / 100;
    }

    public String toString() {
        return "Employee: " + name + ", $ " + NetSalary();
    }
}
