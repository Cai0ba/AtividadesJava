import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        int numero;
        int total=0, qtd=0;
       int media ;
        Scanner leia = new Scanner (System.in);
        do {
            System.out.println("Digite um número: ");
            numero = leia.nextInt();
            if (numero>0) {
                total = total + numero;
                qtd++;
            }
        }while (numero!=0);

        media = total / qtd;
        System.out.println("A média dos números digitados é: " + media);

        leia.close();




    }

}




