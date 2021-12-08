import java.io.*;
import java.util.*;

public class Passagem {

    char ativo;
    String codPassagem;
    String codVoo;
    String nomeCiaAerea;
    String nomePassageiro;
    String dataPartida;
    String horaPartida;
    String dataChegada;
    String horaChegada;
    float pesoBagagem;
    float vlrPassagem;
    float taxaEmbarque;
    float vlrTotal;


    public void incluir() {
        Scanner leia = new Scanner(System.in);
        char confirmacao;
        RandomAccessFile arqPassagem;
        String codPassagemChave;
        boolean encontrou;

        do {

            do {
                System.out.println(" ***************  INCLUSAO DE PASSAGENS AEREAS  ***************** ");
                System.out.print("Digite o Codigo da Passagem( FIM para encerrar): ");
                codPassagemChave = leia.nextLine();
                if (codPassagemChave.equals("FIM")) {
                    break;
                }

                encontrou = false;
                try {
                    arqPassagem = new RandomAccessFile("PASSAGEM.DAT", "rw");
                    while (true) {
                        ativo = arqPassagem.readChar();
                        codPassagem = arqPassagem.readUTF();
                        codVoo = arqPassagem.readUTF();
                        nomeCiaAerea = arqPassagem.readUTF();
                        nomePassageiro = arqPassagem.readUTF();
                        dataPartida = arqPassagem.readUTF();
                        horaPartida = arqPassagem.readUTF();
                        dataChegada = arqPassagem.readUTF();
                        horaChegada = arqPassagem.readUTF();
                        pesoBagagem = arqPassagem.readFloat();
                        vlrPassagem = arqPassagem.readFloat();
                        taxaEmbarque = arqPassagem.readFloat();
                        vlrTotal = arqPassagem.readFloat();

                        if (codPassagemChave.equals(codPassagem) && ativo == 'S') {
                            System.out.println("Passagem ja cadastrada, digite outro valor para o Codigo da Passagem\n");
                            encontrou = true;
                            break;
                        }
                    }
                    arqPassagem.close();

                } catch (EOFException e) {
                    encontrou = false;

                } catch (IOException e) {
                    System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                    System.exit(0);
                }

            } while (encontrou);

            if (codPassagemChave.equalsIgnoreCase("FIM")) {
                System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
                break;
            }

            ativo = 'S';
            codPassagem = codPassagemChave;


            do {
                System.out.print(" Digite o Codigo do Voo...............: ");
                codVoo = leia.nextLine();
                if(consistirCodVoo(codVoo).equals("CODVOO Inválido")) {
                    System.out.print(" CODVOO Inválido");
                }
            }while(consistirCodVoo(codVoo).equals("CODVOO Inválido"));
            System.out.print("Companhia Aerea.....: " + consistirCodVoo(codVoo));


            System.out.print("Digite o Nome do Passageiro..........: ");
            nomePassageiro = leia.nextLine();

            System.out.print("Digite a Data de Partida (DD/MM/AAAA): ");
            dataPartida = leia.nextLine();

            System.out.print("Digite a Hora da Partida (HH:MM).....: ");
            horaPartida = leia.nextLine();

            System.out.print("Digite a Data de Chegada (DD/MM/AAAA): ");
            dataChegada = leia.nextLine();

            System.out.print("Digite a Hora da Chegada (HH:MM).....: ");
            horaChegada = leia.nextLine();

            System.out.print("Digite o peso da bagagem (em kg).....: ");
            pesoBagagem = leia.nextFloat();

            System.out.print("Digite o Valor da Passagem...........: ");
            vlrPassagem = leia.nextFloat();

            System.out.print("Digite o Valor da Taxa de Embarque...: ");
            taxaEmbarque = leia.nextFloat();

            System.out.print("Valor total a pagar..................: ");
            vlrTotal = calcularValorAPagar(vlrPassagem, taxaEmbarque, horaPartida, pesoBagagem);
            System.out.println("R$" + vlrTotal);

            do {
                System.out.print("\nConfirma a gravacao dos dados (S/N) ? ");
                confirmacao = leia.next().charAt(0);
                confirmacao = Character.toUpperCase(confirmacao);
                if (confirmacao == 'S') {
                    try {
                        arqPassagem = new RandomAccessFile("PASSAGEM.DAT", "rw");

                        arqPassagem.seek(arqPassagem.length());
                        arqPassagem.writeChar(ativo);
                        arqPassagem.writeUTF(codPassagem);
                        arqPassagem.writeUTF(codVoo);
                        arqPassagem.writeUTF(nomeCiaAerea);
                        arqPassagem.writeUTF(nomePassageiro);
                        arqPassagem.writeUTF(dataPartida);
                        arqPassagem.writeUTF(horaPartida);
                        arqPassagem.writeUTF(dataChegada);
                        arqPassagem.writeUTF(horaChegada);
                        arqPassagem.writeFloat(pesoBagagem);
                        arqPassagem.writeFloat(vlrPassagem);
                        arqPassagem.writeFloat(taxaEmbarque);
                        arqPassagem.writeFloat(vlrTotal);
                        arqPassagem.close();
                        System.out.println("Dados gravados com sucesso !\n");

                    } catch (IOException e) {
                        System.out.println("Erro na gravacao do registro - programa sera finalizado");
                        System.exit(0);
                    }

                }

            } while (confirmacao != 'S' && confirmacao != 'N');

            leia.nextLine();

        } while (!codPassagemChave.equals("FIM"));

        leia.close();
    }


    public static Float calcularValorAPagar(float vlrPassagem, float taxaEmbarque, String horaPartida, float pesoBagagem) {
        int hora;
        int min;
        float vlrPartida = 0;
        float valorApagar = 0;
        hora = Integer.parseInt(horaPartida.substring(0, 2));
        min = Integer.parseInt(horaPartida.substring(3, 5));
        if (hora >= 07 && min >= 00 && hora <= 8 && min <= 59) {
            vlrPartida = (float) (vlrPassagem * 0.15);
        } else if (hora >= 9 && min >= 00 && hora <= 17 && min <= 59) {
            vlrPartida = (float) (vlrPassagem * 0.10);
        } else if (hora >= 18 && min >= 00 && hora <= 20 && min <= 00) {
            vlrPartida = (float) (vlrPassagem * 0.120);
        }

        if (pesoBagagem <= 23) {
            valorApagar = vlrPassagem + vlrPartida + 0 + taxaEmbarque;
        } else if (pesoBagagem > 23 && pesoBagagem < 30) {
            valorApagar = vlrPassagem + vlrPartida + 100 + taxaEmbarque;
        } else if (pesoBagagem > 30) {
            valorApagar = vlrPassagem + vlrPartida + 200 + taxaEmbarque;
        }
        return valorApagar;

    }

    public String consistirCodVoo (String codvoo) {

        for(int i=0; i<codvoo.length(); i++) {
            if(i>2) {
                if(codvoo.length() != 6 && codvoo.charAt(i)< '0' || codvoo.charAt(i) > '9') {
                    return "CODVOO Inválido";
                }
            }
            if(i<=2) {
                if(codvoo.substring(0,2).equals(Main.vetPrefixoVoo[i]) ) {
                    return Main.vetCiaAerea[i];
                }
            }
        }
        return "CODVOO Inválido";
    }
}

