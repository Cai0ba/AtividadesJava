import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        double catetoAdjacente;
        double cateto;
        double hipotenusa;
        double resultado;

        System.out.println("Digite o cateto adjacente: ");
        catetoAdjacente = leia.nextDouble();
        System.out.println("Digite o cateto: ");
        cateto = leia.nextDouble();

        hipotenusa = (cateto) + (catetoAdjacente);
        resultado = Math. sqrt(hipotenusa);

        System.out.println(resultado);
    }
}
