
public class ex03 {
    public static void main(String[] args) {

        int matriz[][]= new int [4][4];

        for(int x=0; x<4; x++) {
            for(int i=0; i<4; i++) {
                matriz[x][i] = x*i;
            }
        }
        for(int x=0; x<4; x++) {
            for(int i=0; i<4; i++) {
                System.out.println(matriz[x][i]);
            }
        }
        System.out.println("O maior elemento esta contido na coluna 3 da linha 3. Produto ="+matriz[3][3]);
    }

}