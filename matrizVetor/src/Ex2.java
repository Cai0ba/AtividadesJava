import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		
		String letras[] = new String [50];
		String letras2[] = new String [50];
		int letrasDigitadas;
	    
		System.out.println("Digite quantas letras você vai digitar: ");
		letrasDigitadas = leia.nextInt();
		
		System.out.print("Digite as letras: ");
		
		for(int i = 0; i<=letrasDigitadas; i++) {
			letras[i] = leia.nextLine();
			letras2[i] = letras[i];
		}
		
		for(int i = 1; i<=letrasDigitadas; i++) {
			System.out.println("Palavra alterada " + letras2[i].toLowerCase());
		}
	}
 
}
