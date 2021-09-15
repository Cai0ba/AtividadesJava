import java.util.*;
public class Ex5 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		
		float[][] matriz = new float[3][3];
		float calculo1;
		float calculo2;
		float calculo3;
		float result = 0;
		
		System.out.println("Informe 9 valores do tipo real para a matriz!");
		for(int x = 0; x<3; x++) {
			for(int i = 0; i<3; i++) {
				matriz[x][i] = leia.nextFloat();
				
				calculo1 = (matriz[0][1]*matriz[2][2]);
				calculo1 = calculo1-(matriz[2][1]*matriz[0][2]);
				calculo1 = calculo1*(-matriz[1][0]);

				calculo2 = (matriz[0][0]*matriz[2][2]);
				calculo2 = calculo2-(matriz[2][0]*matriz[0][2]);
				calculo2 = calculo2*matriz[1][1];

				calculo3 = (matriz[0][0]*matriz[2][1]);
				calculo3 = calculo3-(matriz[2][0]*matriz[0][1]);
				calculo3 = calculo3*(-matriz[1][2]);
				
				result = calculo1+calculo2+calculo3;
			}
		}
		System.out.println("O determinante é: "+result);
	}

}
