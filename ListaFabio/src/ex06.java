import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
      int nota, nota2, nota3, media;
        System.out.println("Digite a primeira nota: ");
      nota = ler.nextInt();
        System.out.println("Digite a segunda nota: ");
        nota2 = ler.nextInt();
        System.out.println("Digite a terceira nota: ");
        nota3 = ler.nextInt();
        media = (nota+nota2+nota3)/3;
     if(media >= 6  ){
         System.out.println("Voce foi aprovado, sua média é: "+ media);
     }else{
         System.out.println("Voce foi reprovado, sua média é: "+ media);
     }











    }
}
