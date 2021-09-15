import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int sexo;
       int mulher = 0, homem = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("Digite o sexo [0] Masculino [1] Feminino: ");
            sexo = ler.nextInt();
            if(sexo == 0 ){
     homem = homem + 1;
            }else {
                mulher = mulher +1;
            }

        }
        System.out.println(homem +"Homens");
        System.out.println(mulher + " Mulheres" );
    }
    }
