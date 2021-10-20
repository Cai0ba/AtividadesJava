import java.util.*;

public class Ex5_3 {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String horaIni;
        String horaFim;
        do {
            System.out.print("Digite a hora de início ou FIM para encerrar:");
            horaIni = ler.next();

        } while (!horaehValida(horaIni));

        do {
            System.out.print("Digite a hora de fim:");
            horaFim = ler.next();
        } while (!horaehValida(horaFim));
        int horaI = Integer.parseInt(horaIni.substring(0, 2));
        int minI = Integer.parseInt(horaIni.substring(3, 5));

        int horaF = Integer.parseInt(horaFim.substring(0, 2));
        int minF = Integer.parseInt(horaFim.substring(3, 5));

        float duracao = (horaF - horaI) * 60 + minF - minI;
        float valorChamada;
        if (horaI >= 0 && minI >= 0 && horaF < 5 && minF < 59) {
            valorChamada = (float) (duracao * 0.10);
            System.out.printf("O valor da chamada foi de %.2fR$",valorChamada);
        } else if (horaI >= 6 && minI >= 0 && horaF <= 7 && minF <= 59) {
            valorChamada = (float) (duracao * 0.15);
            System.out.printf("O valor da chamada foi de %.2fR$",valorChamada);
        } else if (horaI >= 8 && minI >= 0 && horaF <=17 && minF <= 59) {
            valorChamada = (float) (duracao * 0.20);
            System.out.printf("O valor da chamada foi de %.2fR$",valorChamada);
        } else if (horaI >= 18 && minI >= 0 && horaF <=23 && minF <=59) {
            valorChamada = (float) (duracao * 0.15);
            System.out.printf("O valor da chamada foi de %.2fR$",valorChamada);
        }

    }
//TODO Colocar uma flag pra encerrar a entrada de dados;
    public static boolean horaehValida(String Hora) {
        int hora;
        int min;
        try {
            hora = Integer.parseInt(Hora.substring(0, 2));
            min = Integer.parseInt(Hora.substring(3, 5));

        } catch (NumberFormatException ex) {
            System.out.println("Horário inválido, digitar no formato HH:mm");
            return false;
        }
        if (hora < 0 || hora > 23 || min < 0 || min > 59) {
            System.out.println("Horário inválido, digite um valor correto!");
            return false;
        }
        return true;

    }

}
