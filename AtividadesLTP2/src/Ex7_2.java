import java.io.*;
import java.util.Scanner;
public class Ex7_2 {
        public static class Cliente {

            public char ativo;
            public int codCliente;
            public String nome;
            public float valor;
            public int dataCompra;
            public char dia;


        }
        public static void main(String[] args) {
            Scanner leia= new Scanner (System.in);
            Cliente cliente = new Cliente();
            RandomAccessFile arquivocliente;
            boolean encontrou;
            int codigochave;
            char confirmacao;

            do {
                do {

                    System.out.println(".........Incluir Cliente.........");
                    System.out.println("Digite o codigo do cliete ou digite '1' para finalizar o programa");
                    codigochave = leia.nextInt();
                    if(codigochave == 1) {
                        break;
                    }
                    encontrou = false;

                    try {
                        arquivocliente= new RandomAccessFile("Usuario.DAT", "rw");

                        while(true) {

                            cliente.ativo = arquivocliente.readChar();
                            cliente.codCliente = arquivocliente.readInt();
                            cliente.nome = arquivocliente.readUTF();
                            cliente.valor = arquivocliente.readFloat();
                            cliente.dataCompra = arquivocliente.readInt();
                            cliente.dia = arquivocliente.readChar();
                            if(codigochave == cliente.codCliente && cliente.ativo == 'S') {
                                System.out.println("Codigo Existente, digite outro codigo");
                                encontrou = true;

                                break;

                            }
                        }

                        arquivocliente.close();


                    } catch (EOFException e) {
                        encontrou = false;
                    } catch (IOException e) {
                        System.out.println("Erro na gravação dos dados, Programa finalizado");
                        System.exit(0);
                    }


                } while(encontrou);
                if(codigochave == 1) {
                    System.out.println("Progama finalizado!");
                    break;
                }

                cliente.ativo = 'S';


                cliente.codCliente = codigochave;

                leia.nextLine();
                do {
                    System.out.println("Digite o Nome do CLiente .....:");
                    cliente.nome = leia.nextLine();
                    if(cliente.nome.length() < 10) {
                        System.out.println("o nome precisa conter no minimo 10 caracteres");

                    }
                    //leia.nextLine();
                }while(cliente.nome.length() < 10);

                do {
                    System.out.println("Digite o valor da compra do CLiente .....:");
                    cliente.valor = leia.nextFloat();
                    if(cliente.valor <= 0) {
                        System.out.println("Valor compra invalido");
                    }
                } while(cliente.valor <= 0);

                do {
                    System.out.println("Digite o ano da primeira compra do CLiente .....:");
                    cliente.dataCompra = leia.nextInt();
                    if(cliente.dataCompra > 2013) {
                        System.out.println("ano de compra invalido, digite um ano menor igual a 2013");

                    }
                }while(cliente.dataCompra > 2013);

                System.out.println("Digite se o CLiente está em dia (S/N).....:");
                cliente.dia = leia.next().charAt(0);

                do {

                    System.out.println("\nAceita confirmar a gravação dos dados");
                    confirmacao = leia.next().charAt(0);
                    if(confirmacao == 'S') {
                        try {
                            arquivocliente = new RandomAccessFile("CLIENTE.DAT", "rw");
                            arquivocliente.seek(arquivocliente.length());
                            arquivocliente.writeChar(cliente.ativo);
                            arquivocliente.writeInt(cliente.codCliente);
                            arquivocliente.writeUTF(cliente.nome);
                            arquivocliente.writeFloat(cliente.valor);
                            arquivocliente.writeInt(cliente.dataCompra);
                            arquivocliente.writeChar(cliente.dia);

                            arquivocliente.close();
                            System.out.println("Dados Gravados com sucesso! \n");
                        }catch (IOException e) {
                            System.out.println("Erro na gravação");
                            System.exit(0);
                        }
                    }

                } while(confirmacao != 'S' && confirmacao != 'N');


            } while(cliente.codCliente != 1);

            leia.close();
        }

}
