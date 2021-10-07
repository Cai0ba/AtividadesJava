import java.util.*;

public class Ex5_1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String dataHoje, dataNasc;
        System.out.println("Digite a data de hoje:");
        dataHoje = ler.nextLine();
        System.out.println("Digite sua data de nascimento:");
        dataNasc = ler.nextLine();
        returnData(dataHoje, dataNasc);
        System.out.println(returnData(dataHoje, dataNasc));
    }


    public static int returnData(String dataHoje, String dataNascimento) {
        
     
        int anoHj;
        int anoNascimento;
        int diaHJ;
        int diaNascimento;
        int mesHJ;
        int mesNascimento;
        anoHj = Integer.parseInt(dataHoje.substring(6));
        anoNascimento = Integer.parseInt(dataNascimento.substring(6));

        diaHJ = Integer.parseInt(dataHoje.substring(0,2));
        diaNascimento = Integer.parseInt(dataNascimento.substring(0,2));

        mesHJ = Integer.parseInt(dataHoje.substring(3,5));
        mesNascimento = Integer.parseInt(dataNascimento.substring(3,5));


        int idade = anoHj - anoNascimento;
        if (diaHJ > diaNascimento){
            idade --;
        }
        if(mesNascimento > mesHJ || mesNascimento == mesHJ && diaNascimento > diaHJ ){
            idade --;
        }

        return idade;

    }
}
