import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		
        int notas[] = new int [100];
        int comparacao;
        int x;
        int nAlunos;
        int cont=0;
        boolean encontrou=false;

        System.out.println("Digite o número de Alunos; ");
        nAlunos = leia.nextInt();

        for(x=0; x<nAlunos; x++ ){
            System.out.println("Digite a nota de 0 a 100 para posição " +x+ " do vetor");
            notas[x] = leia.nextInt();

        }
        do {
               System.out.println("Digite uma nota para contar ou 150 para encerrar a pesquisa: ");
               comparacao = leia.nextInt();
               
               if ( comparacao == 150 ) {
                   break;
                  }
                
               encontrou = false;
               
               for(x = 0; x<nAlunos; x++) {
                   if (comparacao == notas[x]) {
                       encontrou = true;
                       cont++;
                   }
               }
               
               System.out.println("A quantidade de " + comparacao + " que foi encontrada foi " + cont);
               cont=0;
               
               if (!encontrou) {
                   System.out.println("O número procurado NÃO foi encontrado");
               }
           }
           while(comparacao != 150);
           leia.close();
	}

}
