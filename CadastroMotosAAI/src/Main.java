import java.util.*;

public class Main {
    static String[] vetmarca = {"YAMAHA", "HONDA", "SUZUKI", "KAWASAKI", "DUCATI", "HARLEY-DAVIDSON", "BMW", "KTM", "TRIUMPH","BUELL" };
    static String[] vetorigem = {"JAPÃO", "JAPÃO", "JAPÃO", "JAPÃO", "ITALIA", "EUA", "ALEMANHA", "AUSTRIA", "INGLATERRA", "EUA" };

    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        Motos motos = new Motos();
        byte opcao;

        do {
            do {
                System.out.println("\n ***************  CADASTRO DE MOTOS  ***************** ");
                System.out.println(" [1] INCLUIR MOTOS ");
                System.out.println(" [2] ALTERAR MOTOS ");
                System.out.println(" [3] CONSULTAR MOTOS ");
                System.out.println(" [4] EXCLUIR MOTOS ");
                System.out.println(" [0] SAIR");
                System.out.print("\nDigite a opcao desejada: ");
                opcao = leia.nextByte();
                if (opcao < 0 || opcao > 4) {
                    System.out.println("opcao Invalida, digite novamente.\n");
                }
            }while (opcao < 0 || opcao > 4);

            switch (opcao) {
                case 0 -> System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
                case 1 -> motos.incluir();
                case 2 -> motos.alterar();
                case 3 -> motos.consultar();
                case 4 -> motos.excluir();
            }
        } while ( opcao != 0 );
        leia.close();
    }

}