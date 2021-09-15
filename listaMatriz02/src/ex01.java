import java.util.Scanner;

public class ex01 {
  
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        int matriz[][]= new int [4][4];
        int cont = 0;

        System.out.println("Digite os valores para matriz 4x4 ");
        for(int x=0; x<4; x++) {
            for(int i=0; i<4; i++) {
                matriz[x][i] = leia.nextInt();
                if(matriz[x][i]>=10) {
                    cont++;
                }
            }
        }
        System.out.println(cont);
    }

}


