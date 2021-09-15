import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner ler = new Scanner (System.in);
        int[][] matriz1 = new int [4][4];
        int[][] matriz2 = new int [4][4];
        int[][] matriz3 = new int [4][4];

        System.out.println("Digite os números para a primeira matriz");
        for(int x=0; x<4; x++) {
            for(int i=0; i<4; i++) {
                matriz1[x][i] = ler.nextInt();
            }
        }

        System.out.println("Digite os números para a segunda matriz");
        for(int x=0; x<4; x++) {
            for(int i=0; i<4; i++) {
                matriz2[x][i] = ler.nextInt();
            }
        }

        for(int x=0; x<4; x++) {
            for(int i=0; i<4; i++) {
                if (matriz1[x][i]>matriz2[x][i]) {
                    matriz3[x][i] = matriz1[x][i];
                }
                else if (matriz2[x][i]>matriz1[x][i]) {
                    matriz3[x][i] = matriz2[x][i];
                }
                else if (matriz2[x][i]==matriz1[x][i]) {
                    matriz3[x][i] = matriz2[x][i];
                }
            }
        }
        for(int x=0; x<4; x++) {
            for(int i=0; i<4; i++) {
                System.out.println(matriz3[x][i]);
            }
        }
    }
}