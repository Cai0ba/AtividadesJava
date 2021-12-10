import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Motos {

    char ativo;
    String codMoto;
    String marca;
    String modelo;
    String origem;
    String estilo;
    int cilindros;
    int cilindradas;
    int potencia;
    float peso;
    float preco;
    String mesAnoFab;


    public long pesquisarMoto(String motoPesquisa) {
        // metodo para localizar um registro no arquivo em disco
        long posicaoCursorArquivo;
        try {
            RandomAccessFile arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
            while (true) {
                posicaoCursorArquivo = arqMoto.getFilePointer();    // posicao do inicio do registro no arquivo
                ativo = arqMoto.readChar();
                codMoto = arqMoto.readUTF();
                marca = arqMoto.readUTF();
                modelo = arqMoto.readUTF();
                origem = arqMoto.readUTF();
                estilo = arqMoto.readUTF();
                cilindros = arqMoto.readInt();
                cilindradas = arqMoto.readInt();
                potencia = arqMoto.readInt();
                peso = arqMoto.readFloat();
                preco = arqMoto.readFloat();
                mesAnoFab = arqMoto.readUTF();

                if (motoPesquisa.equals(codMoto) && ativo == 'S') {
                    arqMoto.close();
                    return posicaoCursorArquivo;
                }
            }
        } catch (EOFException e) {
            return -1; // registro nao foi encontrado
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
            return -1;
        }
    }

    public void salvarMoto() {
        // metodo para incluir um novo registro no final do arquivo em disco
        try {
            RandomAccessFile arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
            arqMoto.seek(arqMoto.length());  // posiciona o ponteiro no final do arquivo (EOF)
            arqMoto.writeChar(ativo);
            arqMoto.writeUTF(codMoto);
            arqMoto.writeUTF(marca);
            arqMoto.writeUTF(modelo);
            arqMoto.writeUTF(origem);
            arqMoto.writeUTF(estilo);
            arqMoto.writeInt(cilindros);
            arqMoto.writeInt(cilindradas);
            arqMoto.writeInt(potencia);
            arqMoto.writeFloat(peso);
            arqMoto.writeFloat(preco);
            arqMoto.writeUTF(mesAnoFab);
            arqMoto.close();
            System.out.println("Dados gravados com sucesso !\n");
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
        }
    }

    public void desativarMoto(long posicao) {
        // metodo para alterar o valor do campo ATIVO para N, tornando assim o registro excluido
        try {
            RandomAccessFile arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
            arqMoto.seek(posicao);
            arqMoto.writeChar('N');   // desativar o registro antigo
            arqMoto.close();
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
        }
    }

    // ***********************   INCLUSAO   *****************************
    public void incluir() {
        String codMotoChave;
        char confirmacao;
        long posicaoRegistro;

        do {
            do {
                Main.leia.nextLine();
                System.out.println("\n ***************  INCLUSAO DE MOTOS  ***************** ");
                System.out.print("Digite o Código da Moto( FIM para encerrar): ");
                codMotoChave = Main.leia.nextLine();
                if (codMotoChave.equals("FIM")) {
                    break;
                }
                posicaoRegistro = pesquisarMoto(codMotoChave);

                if (posicaoRegistro >= 0) {
                    System.out.println("Código ja cadastrada, digite outro valor\n");
                }
            } while (posicaoRegistro >= 0);

            if (codMotoChave.equals("FIM")) {
                break;
            }
            ativo = 'S';
            codMoto = codMotoChave;
            System.out.print("Digite a marca da moto.........................: ");
            marca = Main.leia.nextLine();
            do {
                System.out.print("Digite o modelo da moto........................: ");
                modelo = Main.leia.nextLine();
            } while (!exModelos(modelo));
            System.out.println("Origem da moto: " + ConsistirMarca(marca));
            System.out.print("Digite o estilo da moto........................: ");
            estilo = Main.leia.nextLine();
            do {
                System.out.print("Quantidade de cilindros da moto................: ");
                cilindros = Main.leia.nextInt();
            } while (!exCilindros(cilindros));
            do {
                System.out.print("Digite as cilindradas da moto..................: ");
                cilindradas = Main.leia.nextInt();
            } while (!exCilindradas(cilindradas));
            do {
                System.out.print("Digite a potencia da moto......................: ");
                potencia = Main.leia.nextInt();
            } while (potencia < 0);
            do {
                System.out.print("Digite o peso da moto..........................: ");
                peso = Main.leia.nextFloat();
            } while (peso < 0);
            do {
                System.out.print("Digite o preço da moto.........................: ");
                preco = Main.leia.nextFloat();
            } while(preco < 1000);
            do {
                System.out.print("Digite o mes/ano da moto.......................: ");
                mesAnoFab = Main.leia.next();
            } while (!consistirMesAnoFab(mesAnoFab));
            do {
                System.out.print("\nConfirma a gravacao dos dados (S/N) ? ");
                confirmacao = Main.leia.next().charAt(0);
                if (confirmacao == 'S') {
                    salvarMoto();
                }
            } while (confirmacao != 'S' && confirmacao != 'N');

        } while (!codMoto.equalsIgnoreCase("FIM"));
    }

    //************************  ALTERACAO  *****************************
    public void alterar() {
        String codMotoChave;
        char confirmacao;
        long posicaoRegistro = 0;
        byte opcao;

        do {
            do {
                Main.leia.nextLine();
                System.out.println("\n ***************  ALTERACAO DE MOTOS  ***************** ");
                System.out.print("Digite o código da moto que deseja alterar( FIM para encerrar ): ");
                codMotoChave = Main.leia.nextLine();
                if (codMotoChave.equalsIgnoreCase("FIM")) {
                    break;
                }

                posicaoRegistro = pesquisarMoto(codMotoChave);
                if (posicaoRegistro == -1) {
                    System.out.println("Código nao cadastrado no arquivo, digite outro valor\n");
                }
            } while (posicaoRegistro == -1);

            if (codMotoChave.equalsIgnoreCase("FIM")) {
                break;
            }

            ativo = 'S';

            do {
                System.out.println("[ 1 ] Marca da moto............: " + marca);
                System.out.println("[ 2 ] Modelo da moto ......: " + modelo);
                System.out.println("[ 3 ] Origem da moto.....: " + origem);
                System.out.println("[ 4 ] Estilo da moto............: " + estilo);
                System.out.println("[ 4 ] Cilindros da moto............: " + cilindros);
                System.out.println("[ 5 ] Cilindradas da moto............: " + cilindradas);
                System.out.println("[ 6 ] Potencia da moto............: " + potencia);
                System.out.println("[ 7 ] Peso da moto............: " + peso);
                System.out.println("[ 8 ] Preço da moto............: " + preco);
                System.out.println("[ 9 ] Mes/Ano da moto............: " + mesAnoFab);
                do {
                    System.out.println("Digite o numero do campo que deseja alterar (0 para finalizar as alterações): ");
                    opcao = Main.leia.nextByte();
                } while (opcao < 0 || opcao > 10);

                switch (opcao) {
                    case 1 -> {
                        Main.leia.nextLine();
                        System.out.print("Digite a NOVA marca..................: ");
                        marca = Main.leia.nextLine();
                        origem = ConsistirMarca(marca);
                    }
                    case 2 -> {
                        Main.leia.nextLine();
                        System.out.print("Digite o NOVO modelo: ");
                        modelo = Main.leia.nextLine();
                    }
                    case 3 -> {
                        System.out.print("Digite a NOVA origem...........: ");
                        origem = Main.leia.nextLine();
                    }
                    case 4 -> {
                        System.out.print("Digite o NOVO estilo............: ");
                        estilo = Main.leia.nextLine();
                    }
                    case 5 -> {
                        System.out.print("Digite o NOVO cilindros............: ");
                        cilindros = Main.leia.nextInt();
                    }
                    case 6 -> {
                        System.out.print("Digite a NOVA cilindrada............: ");
                        cilindradas = Main.leia.nextInt();
                    }
                    case 7 -> {
                        System.out.print("Digite a NOVA potência............: ");
                        potencia = Main.leia.nextInt();
                    }
                    case 8 -> {
                        System.out.print("Digite o NOVO peso............: ");
                        peso = Main.leia.nextFloat();
                    }
                    case 9 -> {
                        System.out.print("Digite o NOVO preço ............: ");
                        preco = Main.leia.nextFloat();
                    }
                    case 10 -> {
                        System.out.print("Digite o NOVO Mes/ano............: ");
                        mesAnoFab = Main.leia.next();
                    }
                }
                System.out.println();
            } while (opcao != 0);

            do {
                System.out.print("\nConfirma a alteracao dos dados (S/N) ? ");
                confirmacao = Main.leia.next().charAt(0);
                if (confirmacao == 'S') {
                    desativarMoto(posicaoRegistro);
                    salvarMoto();
                    System.out.println("Dados gravados com sucesso !\n");
                }
            } while (confirmacao != 'S' && confirmacao != 'N');

        } while (!codMoto.equalsIgnoreCase("FIM"));
    }


    //************************  EXCLUSAO  *****************************
    public void excluir() {
        String codMotoChave;
        char confirmacao;
        long posicaoRegistro = 0;

        do {
            do {
                Main.leia.nextLine();
                System.out.println(" ***************  EXCLUSAO DE MOTOS  ***************** ");
                System.out.print("Digite o código da moto que deseja excluir ( FIM para encerrar ): ");
                codMotoChave = Main.leia.nextLine();
                if (codMotoChave.equalsIgnoreCase("FIM")) {
                    break;
                }

                posicaoRegistro = pesquisarMoto(codMotoChave);
                if (posicaoRegistro == -1) {
                    System.out.println("Código nao cadastrada no arquivo, digite outro valor\n");
                }
            } while (posicaoRegistro == -1);

            if (codMotoChave.equalsIgnoreCase("FIM")) {
                System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
                break;
            }

            System.out.println("[ 1 ] Marca da moto............: " + marca);
            System.out.println("[ 2 ] Modelo da moto ......: " + modelo);
            System.out.println("[ 3 ] Origem da moto.....: " + origem);
            System.out.println("[ 4 ] Estilo da moto............: " + estilo);
            System.out.println("[ 4 ] Cilindros da moto............: " + cilindros);
            System.out.println("[ 5 ] Cilindradas da moto............: " + cilindradas);
            System.out.println("[ 6 ] Potencia da moto............: " + potencia);
            System.out.println("[ 7 ] Peso da moto............: " + peso);
            System.out.println("[ 8 ] Preço da moto............: " + preco);
            System.out.println("[ 9 ] Mes/Ano da moto............: " + mesAnoFab);
            System.out.println();

            do {
                System.out.print("\nConfirma a exclusao desta moto (S/N) ? ");
                confirmacao = Main.leia.next().charAt(0);
                if (confirmacao == 'S') {
                    desativarMoto(posicaoRegistro);
                }
            } while (confirmacao != 'S' && confirmacao != 'N');

        } while (!codMotoChave.equalsIgnoreCase("FIM"));
    }

    // ************************  CONSULTA  *****************************
    public void consultar() {
        RandomAccessFile arqMoto;
        byte opcao;
        String codMotoChave;
        String marcaAux;
        float valorIni;
        float valorFim;
        String mesanoAux;
        long posicaoRegistro;

        do {
            do {
                System.out.println(" ***************  CONSULTA DE MOTOS  ***************** ");
                System.out.println(" [1] LISTA DE TODAS AS MOTOS DE UM MARCA");
                System.out.println(" [2] LISTA DE TODAS AS MOTOS DE UM ANO");
                System.out.println(" [3] LISTA DE TODAS AS MOTOS DE UMA FAIXA DE PREÇO ");
                System.out.println(" [4] LISTA DE TODAS AS MOTOS");
                System.out.println(" [0] SAIR");
                System.out.print("\nDigite a opcao desejada: ");
                opcao = Main.leia.nextByte();
                if (opcao < 0 || opcao > 4) {
                    System.out.println("opcao Invalida, digite novamente.\n");
                }
            } while (opcao < 0 || opcao > 4);
            Main.leia.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
                    break;

                case 1:  // imprime motos da marca desejado
                    System.out.print("Digite a marca desejada: ");
                    marcaAux = Main.leia.nextLine();
                    try {
                        arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
                        imprimirCabecalho();
                        while (true) {
                            ativo = arqMoto.readChar();
                            codMoto = arqMoto.readUTF();
                            marca = arqMoto.readUTF();
                            modelo = arqMoto.readUTF();
                            origem = arqMoto.readUTF();
                            estilo = arqMoto.readUTF();
                            cilindros = arqMoto.readInt();
                            cilindradas = arqMoto.readInt();
                            potencia = arqMoto.readInt();
                            peso = arqMoto.readFloat();
                            preco = arqMoto.readFloat();
                            mesAnoFab = arqMoto.readUTF();

                            if (marcaAux == marca && ativo == 'S') {
                                imprimirMoto();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                        codMotoChave = Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }

                    break;
                case 2:  // imprime motos do ano desejado
                    do {
                        System.out.print("Digite o ano de fabricação desejado: ");
                        mesanoAux = Main.leia.nextLine();
                    } while (!consistirMesAnoFab(mesanoAux));

                    try {
                        arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
                        imprimirCabecalho();
                        while (true) {
                            ativo = arqMoto.readChar();
                            codMoto = arqMoto.readUTF();
                            marca = arqMoto.readUTF();
                            modelo = arqMoto.readUTF();
                            origem = arqMoto.readUTF();
                            estilo = arqMoto.readUTF();
                            cilindros = arqMoto.readInt();
                            cilindradas = arqMoto.readInt();
                            potencia = arqMoto.readInt();
                            peso = arqMoto.readFloat();
                            preco = arqMoto.readFloat();
                            mesAnoFab = arqMoto.readUTF();

                            if (mesanoAux == mesAnoFab && ativo == 'S') {
                                imprimirMoto();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                        codMotoChave = Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }

                    break;
                case 3:  // imprime motos da faixa de preço desejado
                    System.out.print("Digite valor inicial desejado: ");
                    valorIni = Main.leia.nextFloat();
                    System.out.print("Digite valor final desejado: ");
                    valorFim = Main.leia.nextFloat();

                    try {
                        arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
                        imprimirCabecalho();
                        while (true) {
                            ativo = arqMoto.readChar();
                            codMoto = arqMoto.readUTF();
                            marca = arqMoto.readUTF();
                            modelo = arqMoto.readUTF();
                            origem = arqMoto.readUTF();
                            estilo = arqMoto.readUTF();
                            cilindros = arqMoto.readInt();
                            cilindradas = arqMoto.readInt();
                            potencia = arqMoto.readInt();
                            peso = arqMoto.readFloat();
                            preco = arqMoto.readFloat();
                            mesAnoFab = arqMoto.readUTF();

                            if (valorIni >= preco && valorFim <= preco && ativo == 'S') {
                                imprimirMoto();
                            } else {
                                System.out.println("Faixa de preço não encontrada!");
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                        codMotoChave = Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }
                    break;
                case 4:  // imprime todos as motos
                    try {
                        arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
                        imprimirCabecalho();
                        while (true) {
                            ativo = arqMoto.readChar();
                            codMoto = arqMoto.readUTF();
                            marca = arqMoto.readUTF();
                            modelo = arqMoto.readUTF();
                            origem = arqMoto.readUTF();
                            estilo = arqMoto.readUTF();
                            cilindros = arqMoto.readInt();
                            cilindradas = arqMoto.readInt();
                            potencia = arqMoto.readInt();
                            peso = arqMoto.readFloat();
                            preco = arqMoto.readFloat();
                            mesAnoFab = arqMoto.readUTF();
                            if (ativo == 'S') {
                                imprimirMoto();
                            }
                        }
                        //    arqMoto.close();
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                        codMotoChave = Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }
                    break;
            }

        } while (opcao != 0);
    }

    public void imprimirCabecalho() {
        System.out.println("CODMOTO MARCA            MODELO         ORIGEM         ESTILO        CIL             POT            PESO           PREÇO            ANO  ");
    }

    public void imprimirMoto() {
        System.out.println(formatarString(codMoto, 6) + "  " +
                formatarString(marca, 15) + "  " +
                formatarString(modelo, 13) + "  " +
                formatarString(origem, 13) + "  " +
                formatarString(estilo, 13) + "  " +
                formatarString(String.valueOf(cilindradas), 13) + "  " +
                formatarString(String.valueOf(potencia), 13) + "  " +
                formatarString(String.valueOf(peso), 13) + "  " +
                formatarString(String.valueOf(preco), 13) + "  " +
                formatarString(String.valueOf(mesAnoFab), 13));
    }

    public static String formatarString(String texto, int tamanho) {
        // retorna uma string com o numero de caracteres passado como parametro em TAMANHO
        if (texto.length() > tamanho) {
            texto = texto.substring(0, tamanho);
        } else {
            StringBuilder textoBuilder = new StringBuilder(texto);
            while (textoBuilder.length() < tamanho) {
                textoBuilder.append(" ");
            }
            texto = textoBuilder.toString();
        }
        return texto;
    }

    public static boolean consistirMesAnoFab(String mesAno) {
        int mes;
        int ano;
        mes = Integer.parseInt(mesAno.substring(0, 2));
        ano = Integer.parseInt(mesAno.substring(3, 7));
        char barra = mesAno.charAt(2);
        if (mesAno.length() != 7) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (ano < 1980 || ano > 2021) {
            return false;
        }
        if (barra != '/') {
            return false;
        }

        return true;
    }

    public String ConsistirMarca(String marca) {
        String origem;
        for (int i = 0; i <= Main.vetmarca.length; i++) {
            if (marca.equalsIgnoreCase(Main.vetmarca[i])) {
                origem = Main.vetorigem[i];
                return origem;
            }
        }
        return "ERRO";
    }

    public boolean exModelos(String modelo) {
        if (modelo.equalsIgnoreCase("CUSTOM") || modelo.equalsIgnoreCase("TRAIL") || modelo.equalsIgnoreCase("SPORT") || modelo.equalsIgnoreCase("NAKED") || modelo.equalsIgnoreCase("TOURING")) {
            return true;
        }
        System.out.println("O modelo deve ser um dos seguintes: CUSTOM, TRAIL, SPORT, NAKED ou TOURING");
        return false;
    }

    public boolean exCilindros(int cilindros) {
        if (cilindros > 1 && cilindros < 6) {
            return true;
        }
        System.out.println("A moto pode ter entre 1 e 6 cilindros!");
        return false;

    }

    public boolean exCilindradas(int cilindradas) {
        if (cilindradas > 100 && cilindradas < 1800) {
            return true;
        }
        System.out.println("A moto pode ter entre 100 e 1800 cilindradas");
        return false;

    }


}