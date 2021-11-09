import java.util.*;

public class Ex5_4 {
    public static void main(String[] args) {
        String placa;
        String data;
        float valorMulta;
        Scanner ler = new Scanner(System.in);
        do {
            System.out.print("Digite a placa do veículo com 7 dígitos:");
            placa = ler.next();
            if(placa.length() != 7){
                System.out.println("Qauntidade de caracteres inválido para uma placa");
            }
        } while (placa.length() != 7);

        do {
            System.out.println("Digite a data da multa");
            data = ler.next();

        } while (!dataEhValida(data));

    }

    static boolean dataEhValida(String data) {
        int dia, mes, ano;
        dia = Integer.parseInt(data.substring(0, 2));
        mes = Integer.parseInt(data.substring(3, 5));
        ano = Integer.parseInt(data.substring(6, 10));


        if (data.length() != 10) {
            System.out.println("Data inválida, gentileza inserir no formato dd/MM/yyyy");
            return false;
        }
      if(mes < 1 || mes > 12){
          System.out.println("Mês inexistente, favor inserir um mês correto");
          return false;

      }
        if(data.substring(2,2) == "/" || data.substring(5,5) == "/"){
            System.out.println("Formato de data inválido, gentileza inserir no formato dd/MM/yyyy");

            return false;
        }
        if(dia < 1 || dia > 31 && mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12  ){
            System.out.println("Dia inexistente nesse mês, favor inserir um dia correto");
            return false;

        }
            if(mes == 4 || mes == 6 || mes == 9 || mes == 11 && dia < 1 || dia > 30){
            System.out.println("Dia inexistente nesse mês, favor inserir um dia correto");
            return false;

        }
//todo Ajustar o metodo de validação e finaliza a somatoria de multas com a flag de fim

        return true;
        //            if(mes == 2 && ano % 4 == 0 && ano % 100 != 0  || ano % 400 == 0){
//
//            }
    }
}
