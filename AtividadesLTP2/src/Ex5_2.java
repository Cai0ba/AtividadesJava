import java.util.Scanner;

public class Ex5_2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String codigo;
        int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11;
       do {
           System.out.println("Digite um código de 11 caracteres (APENAS NÚMEROS)");
           codigo = ler.nextLine();
           if (codigo.length() != 11) {
               System.out.println("Código Inválido");
               if(codigo.contains("^[a-Z]") || (codigo.isEmpty()) ){
                   System.out.println("Código Inválido");
               }
           } else {
               num1 = Integer.parseInt(codigo.substring(0, 1));
               num2 = Integer.parseInt(codigo.substring(1, 2));
               num3 = Integer.parseInt(codigo.substring(2, 3));
               num4 = Integer.parseInt(codigo.substring(3, 4));
               num5 = Integer.parseInt(codigo.substring(4, 5));
               num6 = Integer.parseInt(codigo.substring(5, 6));
               num7 = Integer.parseInt(codigo.substring(6, 7));
               num8 = Integer.parseInt(codigo.substring(7, 8));
               num9 = Integer.parseInt(codigo.substring(8, 9));
               num10 = Integer.parseInt(codigo.substring(9, 10));
               num11 = Integer.parseInt(codigo.substring(10, 11));
               verificaCodigo(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11);

           }

       }while(codigo.length() != 11);
    }

    public static int verificaCodigo(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8, int num9, int num10, int num11) {
        int resultadoSoma = (int) (num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9) / 10;
        int resultadoMulti = num1 * num2 * num3 * num4 * num5 * num6 * num7 * num8 * num9;

        String ultimoDigito = String.valueOf(resultadoMulti);
       int tamanho = ultimoDigito.length();
        char teste = ultimoDigito.charAt(tamanho-1);
       int testeInt = Character.digit(teste,10);

        if(testeInt != num11 || resultadoSoma != num10){
            System.out.println("Este Código é inválido");

        }else{
            System.out.println("Código Válido");
        }

        return 0;
    }
}
