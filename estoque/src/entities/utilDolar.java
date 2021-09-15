package entities;
public class utilDolar {

    public static final double TAX = 0.06;
 public static double CurencyConverter(double price, double quantity){
     double total = price * quantity;
 return TAX * total + total;
 }


    }


