

public class ex01 {
    public static void main(String[] args) {
        int[] vetorA = new int[6];
        vetorA[0] = 1;
        vetorA[1] = 0;
        vetorA[2] = 5;
        vetorA[3] = -2;
        vetorA[4] = -5;
        vetorA[5] = 7;
        int vet4 = 100;

        vetorA[3] = vet4;
        int soma = vetorA[0] + vetorA[1] + vetorA[5];
        System.out.println("A soma  dos vetores \"0,1 e 5\" é " + soma);
        for(int i = 0 ; i<6 ; i++){
            System.out.println(vetorA[i]);
        }
    }

}
