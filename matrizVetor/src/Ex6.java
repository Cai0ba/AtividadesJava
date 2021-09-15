import java.util.Scanner;
public class Ex6 {

	public static void main(String[] args) {
		 Scanner leia = new Scanner (System.in);
	        float matriz[][] = new float [3][3];
	        int lado=0;
	        int inverter=2;
	        int somaLinha=0;
	        int somaColuna=0;
	        int somaD=0;
	        int somaE=0;
	        int ladoMagico =0;

	        for(int x=0; x<3; x++) {
	        	for(int i=0; i<3; i++) {
	        		System.out.print("Digite os números na matriz: ");
	        		matriz[x][i] = leia.nextFloat();
	        	}
	        	ladoMagico += matriz[x][x];
	        }
	        
	        for(int x=0; x<3; x++) {
	        	somaLinha=0;
	        	somaColuna=0;
	        	somaD=0;
	        	somaE=0;
	        	
	        	for(int i=0; i<3; i++) {
	        		somaLinha += matriz[x][i];
	        		somaColuna += matriz[i][x];
	        		somaD += matriz[x][x];
	        		somaE += matriz[x][inverter];
	        	}
     		if(ladoMagico == somaColuna) {
     			lado += 1;
     		}
     		if(ladoMagico == somaLinha) {
     			lado += 1;
     		}
     		if(ladoMagico == somaD) {
     			lado += 1;
     		}
     		if(ladoMagico == somaE) {
     			lado += 1;
     		}
	        	inverter--;
	        }
	        if(lado == 8) {
	        	System.out.print("É uma quadrado mágico!");
	        }
	        else {
	        	System.out.print("Não é um quadrado mágico!");
	        }
	}
}
