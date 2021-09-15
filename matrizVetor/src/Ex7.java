import java.util.Scanner;
public class Ex7 {

	public static void main(String[] args) {
		Scanner ler = new Scanner (System.in);
		
		float[][] matriz = new float[3][3];
		float somar = 0;
		float mult = 1;
		float maior = 0;
		float menor = 0;
		float positivo = 9;
		
		System.out.println("Informe 9 valores do tipo real para a matriz!");
		for(int x = 0; x<3; x++) {	
			for(int i = 0; i<3; i++) {
				matriz[x][i] = ler.nextFloat();
				
				if(matriz[x][i] < 0) {
					positivo--;
				}
				
				if(x == 0) {
					 maior = matriz[0][0];
					 menor = matriz[0][0];
				}
				
				somar+=matriz[x][i];
				mult *= matriz[x][i];
				
				if(maior < matriz[x][i]) {
					maior = matriz[x][i];
				}
				
				if(menor > matriz[x][i]) {
					menor = matriz[x][i];
				} 
				
			}
		}
		
		System.out.println("A soma dos elementos "+somar);
		System.out.println("O produto da matriz "+mult);
		System.out.println("O maior número digitado "+maior);
		System.out.println("O menor número digitado "+menor);
		System.out.println(positivo);
		
		
	}

}