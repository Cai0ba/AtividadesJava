import java.util.Scanner;

public class ex09 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao ;
        double valor1, valor2;
        System.out.println("Digite o primeiro valor: ");
        valor1 = ler.nextDouble();
        System.out.println("Digite o segundo valor: ");
        valor2 = ler.nextDouble();
        System.out.println("Digite 1 para somar: ");
        System.out.println("Digite 2 para subtrair: ");
        System.out.println("Digite 3 para multiplicar: ");
        System.out.println("Digite 4 para divir: ");
        System.out.println("Digite 5 para sair: ");
        opcao = ler.nextInt();
if(opcao == 1){
    System.out.println(valor1 + valor2);
}else if(opcao == 2){
    System.out.println(valor1 - valor2);

}else if(opcao == 3){
    System.out.println(valor1 * valor2);

}else if(opcao == 4){
    System.out.println(valor1 / valor2);

}else if(opcao == 5){
    System.exit(0);

}



    }
}
