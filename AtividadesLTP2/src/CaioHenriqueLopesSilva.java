import java.util.Scanner;

public class CaioHenriqueLopesSilva {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        String[] nome = new String [100];
        int mesEmp;
        int anoEmp;
        int mesatual;
        int anoatual;
        float valorEmp;
        float taxajuros;
        int contDivida=0;
        int mesdivida=0;
        int cont;
        float[] divida = new float [100];

        for(cont = 0; cont < 100; cont++) {


            // do {


            System.out.println("digite o nome ou digite sair para encerrar o programa");
            nome[cont] = leia.nextLine();

            if(nome[cont].equalsIgnoreCase("SAIR")) {
                break;

            }

            do {

                System.out.println("digite o mes do emprestimo");
                mesEmp = leia.nextInt();

                System.out.println("digite o mes atual");
                mesatual = leia.nextInt();

                if ( mesEmp < 1 || mesEmp> 12) {

                    System.out.println("valor invalido, digite um mes até 12");

                } if (mesatual < 1 || mesatual > 12) {

                    System.out.println("valor invalido, digite um mes até 12");
                }

            }while (mesEmp < 1 || mesEmp> 12 || mesatual < 1 || mesatual > 12);

            do {

                System.out.println("digite o ano de hoje");
                anoatual = leia.nextInt();

                System.out.println("digite o ano do emprestimo");
                anoEmp = leia.nextInt();

                if (anoatual < anoEmp) {

                    System.out.println("valor invalido, ano atual precisa se maior que o de emprestimo");
                }

            }while(anoatual < anoEmp);

            System.out.println("digite o valor do emprestimo");
            valorEmp = leia.nextFloat();

            System.out.println("digite o valor da taxa de juros ");
            taxajuros = leia.nextFloat();


            mesdivida= (anoatual - anoEmp) * 12 + (mesatual - mesEmp);



            leia.nextLine();


            divida[cont]= calcularDivida ( mesEmp,  anoEmp,  mesatual,  anoatual,  valorEmp,  taxajuros);
        }





        System.out.println("Relatorio de pessoas com 1 ano de divida");
        System.out.println("Nome:                   Valor");
        if ( mesdivida > 12) {

            for (int i =0; i < cont; i++) {

                System.out.println(nome[i]+  "             "   +  divida[i]);
                System.out.println(contDivida);
                System.out.println(cont);
            }
            //System.out.println();
        }



    }
    public static float calcularDivida(int mesemprestimo, int anoemprestimo, int mes, int anoatual, float valoremprestimo, float taxajuros) {

        return  ((anoatual - anoemprestimo)) * 12 + (mes - mesemprestimo) * taxajuros * valoremprestimo / 100 + valoremprestimo;


    }


}