import java.util.*;
public class ex02 {
    public static void main (String[]arg) {
        Scanner ler = new Scanner (System.in);
        String nomeDevedor [] = new String [100];
        int mesEmpres = 0;
        int anoEmpres = 0;
        int mesAtual = 0;
        int anoAtual = 0;
        float vlrEmpres = 0;
        float taxaJurosMen = 0;
        int contNumDev = 0;
        int contDiv = 0;
        int mesDiv = 0;
        float divida [] = new float [100];

        for (contNumDev = 0; contNumDev < 100; contNumDev++) {
            System.out.println("Informe o nome do devedor ou (FIM) para encerrar: ");
            nomeDevedor[contNumDev] = ler.nextLine();
            if(nomeDevedor[contNumDev].equalsIgnoreCase("FIM")) {
                break;
            }

            do {
                System.out.println("Informe o mês de emprestimo: ");
                mesEmpres = ler.nextInt();
                System.out.println("Informe o mês atual: ");
                mesAtual = ler.nextInt();
                if(mesEmpres < 1 || mesEmpres > 12 ) {
                    System.out.println("Mes inválido, informe meses entre 1 e 12");
                }else if(mesAtual < 1 || mesAtual > 12) {
                    System.out.println("Mes inválido, informe meses entre 1 e 12");
                }
            }while(mesEmpres < 1 || mesEmpres > 12 || mesAtual < 1 || mesAtual > 12);

            do {
                System.out.println("Informe o ano de emprestimo: ");
                anoEmpres = ler.nextInt();
                System.out.println("Informe o ano atual: ");
                anoAtual = ler.nextInt();
                if(anoAtual < anoEmpres) {
                    System.out.println("Ano atual deve ser maior que o ano de emprestimo");
                }
            }while(anoAtual < anoEmpres);

            System.out.println("Informe o valor do emprestimo: ");
            vlrEmpres = ler.nextFloat();
            System.out.println("Informe a taxa de juros do banco: ");
            taxaJurosMen = ler.nextFloat();

            if((anoAtual - anoEmpres) * 12 + (mesAtual - mesEmpres) > 12) {
                contDiv++;
            }

            ler.nextLine();

            divida[contNumDev]= calcularDivida ( mesEmpres,  anoEmpres,  mesAtual,  anoAtual,  vlrEmpres,  taxaJurosMen);
        }
        System.out.println("Relatorio de pessoas com 1 ano de divida");
        System.out.println("NOME DEVEDOR                   VALOR DIVIDA");
        System.out.println("============================================");
        if ( contDiv > 12) {
            for (int i =0; i < contNumDev; i++) {
                System.out.println(nomeDevedor[i]+  "             "   +  divida[i]);
                System.out.println(contDiv);
                System.out.println(contNumDev);
            }
        }
    }
    public static float calcularDivida(int mesemprestimo, int anoemprestimo, int mes, int anoatual, float valoremprestimo, float taxajuros) {
        float divida;
        divida = ((anoatual - anoemprestimo)) * 12 + (mes - mesemprestimo) * taxajuros * valoremprestimo / 100 + valoremprestimo;
        return divida;
    }
}