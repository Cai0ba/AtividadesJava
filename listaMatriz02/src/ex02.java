public class ex02 {
    public static void main(String[] args) {
        int matriz[][]= new int [5][5];

        for(int x=0; x<5; x++) {
            for(int i=0; i<5; i++) {
                matriz[x][i] = 0;
            }
        }
        for(int i=0; i<5; i++) {
            matriz[i][i] = 1;  //principal
        }
        for(int x=0; x<5; x++) {
            for(int i=0; i<5; i++) {
                System.out.println(matriz[x][i]);
            }
        }
    }
}
