import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        int[][] mat = new int [3][3];
        int soma = 0;

        System.out.println("Digite os valores para matriz: ");
        for(int x = 0; x<3; x++) {
            for(int i = 0; i<3; i++) {
                mat[x][i] = leia.nextInt();
                if(i==x) {
                    soma+=mat[x][i];
                }
            }
        }
        System.out.println("A soma dos elementos é "+soma);
    }

}
