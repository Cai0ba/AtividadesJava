import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        int[][] matriz = new int [5][5];
        int xis;
        boolean verdadeiro = false;
        System.out.println("Digite os valores da matriz: ");
        for(int x=0; x<5; x++) {
            for(int i=0; i<5; i++) {
                matriz[x][i] = leia.nextInt();
            }
        }
        System.out.println("Digite o valor para pesquisa: ");
        xis = leia.nextInt();

        for(int x=0; x<5; x++) {
            for(int i=0; i<5; i++) {
                if(matriz[x][i]==xis) {
                    System.out.println("O valor foi encontrado na linha "+x+" e na coluna "+i);
                }
                else if(matriz[x][i]!=xis){
                    verdadeiro = false;
                }
            }
        }
        if(verdadeiro = false) {
            System.out.println("Valor não encontrado");
        }
    }

}

