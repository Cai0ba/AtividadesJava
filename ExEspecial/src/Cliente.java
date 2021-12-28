
import java.util.*;
import java.io.*;

public class Cliente {
    char ativo;
    String codCliente;
    String nomeCliente;
    String numCarteira;
    String dataInicio;
    String dataNascimento;
    int numDependentes;
    float valorMensalidade;

    public void incluir() {
        Scanner leia = new Scanner(System.in);
        RandomAccessFile arquivo;
        String codClienteChave;
        char confirmacao;
        boolean encontrou;

        do {
            do {
                System.out.println(" ***************  INCLUSAO DE CLIENTES DE PLANO DE SA�DE  ***************** ");
                System.out.print("Digite o Codigo do CLIENTE( FIM para encerrar): ");
                codClienteChave = leia.nextLine();
                if (codClienteChave.equals("FIM")) {
                    break;
                }

                encontrou = false;
                try {
                    arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
                    while (true) {
                        ativo = arquivo.readChar();
                        codCliente = arquivo.readUTF();
                        nomeCliente = arquivo.readUTF();
                        numCarteira = arquivo.readUTF();
                        dataInicio = arquivo.readUTF();
                        dataNascimento = arquivo.readUTF();
                        numDependentes = arquivo.readInt();
                        valorMensalidade = arquivo.readFloat();

                        if (codClienteChave.equals(codCliente) && ativo == 'S') {
                            System.out.println("Cliente j� cadastrado, digite outro valor para o C�digo do Cliente\n");
                            encontrou = true;
                            break;
                        }
                    }
                    arquivo.close();
                } catch (EOFException e) {
                    encontrou = false;
                } catch (IOException e) {
                    System.out.println("Erro na abertura do arquivo - programa ser� finalizado");
                    System.exit(0);
                }
            } while (encontrou);

            if (codClienteChave.equals("FIM")) {
                System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
                break;
            }

            ativo = 'S';
            codCliente = codClienteChave;

            System.out.print("Digite o Nome do Cliente...........: ");
            nomeCliente = leia.nextLine();

            do {
                System.out.print("Digite o N�mero da Carteira........: ");
                numCarteira = leia.nextLine();
            } while (!consistirCarteira(numCarteira, nomeCliente));


            System.out.print("Digite a Data de In�co (DD/MM/AAAA): ");
            dataInicio = leia.nextLine();

            System.out.print("Data de Nascimento (DD/MM/AAAA)....: ");
            dataNascimento = leia.nextLine();

            System.out.print("Digite O N�mero de Dependentes.....: ");
            numDependentes = leia.nextInt();

            System.out.print("A mensalidade é de .................: ");
            System.out.println("R$ "+calcularMensalidade(dataInicio, dataNascimento, numCarteira, numDependentes));
            do {
                System.out.print("\nConfirma a grava��o dos dados (S/N) ? ");
                confirmacao = leia.next().charAt(0);
                if (confirmacao == 'S') {
                    try {
                        arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
                        arquivo.seek(arquivo.length());
                        arquivo.writeChar(ativo);
                        arquivo.writeUTF(codCliente);
                        arquivo.writeUTF(nomeCliente);
                        arquivo.writeUTF(numCarteira);
                        arquivo.writeUTF(dataInicio);
                        arquivo.writeUTF(dataNascimento);
                        arquivo.writeInt(numDependentes);
                        arquivo.writeFloat(valorMensalidade);
                        arquivo.close();
                        System.out.println("Dados gravados com sucesso !\n");
                    } catch (IOException e) {
                        System.out.println("Erro na grava�ao do registro - programa ser� finalizado");
                        System.exit(0);
                    }

                }
            } while (confirmacao != 'S' && confirmacao != 'N');

            leia.nextLine();
        } while (!codCliente.equals("FIM"));
        leia.close();
    }


    public static boolean consistirCarteira(String numCarteira, String nome) {
        String APEF = numCarteira.substring(0, 2);
        String nomeUsuario = nome.substring(0, 2);
        String nomeCarteira = numCarteira.substring(3, 5);
        char menos = numCarteira.charAt(2);
        if (!APEF.equalsIgnoreCase("AP") && !APEF.equalsIgnoreCase("EF")) {
            System.out.println("O número da carteira está incorreto");
            return false;
        }
        if (!nomeCarteira.equalsIgnoreCase(nomeUsuario)) {
            System.out.println("O número da carteira está incorreto");
            return false;
        }
        if (menos != '-') {
            System.out.println("O número da carteira está incorreto");
            return false;
        }
       return true;
    }

    public float calcularMensalidade(String anoInicio, String anoNasc, String CodCarteira, int numDependentes) {
        int anoNascim = Integer.parseInt(anoNasc.substring(6, 10));
        int anoInic = Integer.parseInt(anoInicio.substring(6, 10));
        int idade = anoInic - anoNascim;
        String tipoPLano = CodCarteira.substring(0, 2);
        int valorBase = 0;
        float valorMensalidade;
        if (tipoPLano.equalsIgnoreCase("AP") && idade <= 35) {
            valorBase = 350;
        } else if (tipoPLano.equalsIgnoreCase("AP") && idade > 36 && idade <= 50) {
            valorBase = 350;
        } else if (tipoPLano.equalsIgnoreCase("AP") && idade > 50) {
            valorBase = 500;
        } else if (tipoPLano.equalsIgnoreCase("EF") && idade <= 60) {
            valorBase = 280;
        } else if (tipoPLano.equalsIgnoreCase("EF") && idade > 60) {
            valorBase = 370;
        }
        valorMensalidade = valorBase + numDependentes * 100;
        return valorMensalidade;
    }


}