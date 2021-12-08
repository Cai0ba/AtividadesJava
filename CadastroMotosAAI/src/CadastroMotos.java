import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CadastroMotos {

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

    public long pesquisarMoto(String codMotoSearch) {
        // metodo para localizar um registro no arquivo em disco
        long posicaoCursorArquivo;
        try {
            RandomAccessFile arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
            while (true) {
                posicaoCursorArquivo  = arqMoto.getFilePointer();	// posicao do inicio do registro no arquivo
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

                if ( codMotoSearch.equals(codMoto) && ativo == 'S') {
                    arqMoto.close();
                    return posicaoCursorArquivo;
                }
            }
        }catch (EOFException e) {
            return -1; // registro nao foi encontrado
        }catch (IOException e) {
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
        }catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
        }
    }

    public void desativarMoto(long posicao)	{
        // metodo para alterar o valor do campo ATIVO para N, tornando assim o registro excluido
        try {
            RandomAccessFile arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
            arqMoto.seek(posicao);
            arqMoto.writeChar('N');   // desativar o registro antigo
            arqMoto.close();
        }catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
        }
    }

    // ***********************   INCLUSAO   *****************************
    public void incluir() {
        String codMotoI;
        char confirmacao;
        long posicaoRegistro;

        do {
            do {
                Main.leia.nextLine();
                System.out.println("\n ***************  INCLUSAO DE MOTOS  ***************** ");
                System.out.print("Digite o código da Moto( FIM para encerrar): ");
                codMotoI = Main.leia.nextLine();
                if (codMotoI.equals("FIM")) {
                    break;
                }
                posicaoRegistro = pesquisarMoto(codMotoI);

                if (posicaoRegistro >= 0) {
                    System.out.println("Matricula ja cadastrada, digite outro valor\n");
                }
            }while (posicaoRegistro >= 0);

            if (codMoto.equals("FIM")) {
                break;
            }

            ativo = 'S';
            codMoto = codMotoI;
            System.out.print("Digite a marca da moto.........................: ");
            marca = Main.leia.nextLine();
            System.out.print("Digite o modelo da moto........................: ");
            modelo = Main.leia.nextLine();
            System.out.print("Digite a origem da moto........................: ");
            origem = Main.leia.nextLine();
            System.out.print("Digite o estilo da moto........................: ");
            estilo = Main.leia.nextLine();
            System.out.print("Digite a quantidade de cilindros da moto.......: ");
            cilindros = Main.leia.nextInt();
            System.out.print("Digite as cilindradas da moto..................: ");
            cilindradas = Main.leia.nextInt();
            System.out.print("Digite a potencia da moto........................: ");
            potencia = Main.leia.nextInt();
            System.out.print("Digite o peso da moto........................: ");
            peso = Main.leia.nextFloat();
            System.out.print("Digite o preço da moto........................: ");
            preco = Main.leia.nextFloat();
            System.out.print("Digite o estilo da moto........................: ");
            mesAnoFab = Main.leia.nextLine();

            do {
                System.out.print("\nConfirma a gravacao dos dados (S/N) ? ");
                confirmacao = Main.leia.next().charAt(0);
                if (confirmacao == 'S') {
                    salvarMoto();
                }
            }while (confirmacao != 'S' && confirmacao != 'N');

        }while ( ! codMoto.equals("FIM"));
    }


    //************************  ALTERACAO  *****************************
    public void alterar() {
        String codMotoA;
        char confirmacao;
        long posicaoRegistro = 0;
        byte opcao;

        do {
            do {
                Main.leia.nextLine();
                System.out.println("\n ***************  ALTERACAO DE ALUNOS  ***************** ");
                System.out.print("Digite o código da moto que deseja alterar( FIM para encerrar ): ");
                codMotoA = Main.leia.nextLine();
                if (codMotoA.equals("FIM")) {
                    break;
                }

                posicaoRegistro = pesquisarMoto(codMotoA);
                if (posicaoRegistro == -1) {
                    System.out.println("Código não cadastrado no arquivo, digite outro valor\n");
                }
            }while (posicaoRegistro == -1);

            if (codMotoA.equals("FIM")) {
                break;
            }

            ativo = 'S';

            do {
                System.out.println("[ 1 ] Marca da moto............: " + marca);
                System.out.println("[ 2 ] Modelo da moto ..........: " + modelo);
                System.out.println("[ 4 ] Origem da moto...........: " + origem);
                System.out.println("[ 5 ] Estilo da moto...........: " + estilo);
                System.out.println("[ 6 ] Cilindros da moto........: " + cilindros);
                System.out.println("[ 7 ] Cilindradas da moto......: " + cilindradas);
                System.out.println("[ 8 ] Potência da moto.........: " + potencia);
                System.out.println("[ 9 ] Peso da moto.............: " + peso);
                System.out.println("[ 10 ] Preço da moto...........: " + preco);
                System.out.println("[ 11 ] Ano da moto.............: " + mesAnoFab);
                do{
                    System.out.println("Digite o numero do campo que deseja alterar (0 para finalizar as alterações): ");
                    opcao = Main.leia.nextByte();
                }while (opcao < 0 || opcao > 4);

                switch (opcao) {
                    case 1 -> {
                        Main.leia.nextLine();
                        System.out.print("Digite a nova marca da moto..................: ");
                        marca = Main.leia.nextLine();
                    }
                    case 2 -> {
                        Main.leia.nextLine();
                        System.out.print("Digite o novo modelo da moto: ");
                        modelo = Main.leia.nextLine();
                    }
                    case 3 -> {
                        System.out.print("Digite a nova origem da moto...........: ");
                        origem = Main.leia.nextLine();
                    }
                    case 4 -> {
                        System.out.print("Digite o novo estilo da moto)............: ");
                        estilo = Main.leia.nextLine();
                    }
                    case 5 -> {
                        System.out.print("Digite a nova quantidade de cilindros....: ");
                        cilindros = Main.leia.nextInt();
                    }
                    case 6 -> {
                        System.out.print("Digite a nova quantidade de cilindradas..: ");
                        cilindradas = Main.leia.nextInt();
                    }
                    case 7 -> {
                        System.out.print("Digite a nova potência da moto............: ");
                        potencia = Main.leia.nextInt();
                    }
                    case 8 -> {
                        System.out.print("Digite o novo peso da moto................: ");
                        peso = Main.leia.nextFloat();
                    }
                    case 9 -> {
                        System.out.print("Digite o novo preço da moto...............: ");
                        preco = Main.leia.nextFloat();
                    }
                    case 10 -> {
                        System.out.print("Digite o novo MES/ano da moto............: ");
                        mesAnoFab = Main.leia.nextLine();
                    }
                }
                System.out.println();
            }while (opcao != 0);

            do {
                System.out.print("\nConfirma a alteracao dos dados (S/N) ? ");
                confirmacao = Main.leia.next().charAt(0);
                if (confirmacao == 'S') {
                    desativarMoto(posicaoRegistro);
                    salvarMoto();
                    System.out.println("Dados gravados com sucesso !\n");
                }
            }while (confirmacao != 'S' && confirmacao != 'N');

        }while ( ! codMoto.equals("FIM"));
    }


    //************************  EXCLUSAO  *****************************
    public void excluir() {
        String codMotoE;
        char confirmacao;
        long posicaoRegistro = 0;

        do {
            do {
                Main.leia.nextLine();
                System.out.println(" ***************  EXCLUSAO DE MOTOS  ***************** ");
                System.out.print("Digite o código da moto que deseja excluir ( FIM para encerrar ): ");
                codMotoE = Main.leia.nextLine();
                if (codMotoE.equals("FIM")) {
                    break;
                }

                posicaoRegistro = pesquisarMoto(codMotoE);
                if (posicaoRegistro == -1) {
                    System.out.println("Código não cadastrado no arquivo, digite outro valor\n");
                }
            }while (posicaoRegistro == -1);

            if (codMotoE.equals("FIM")) {
                System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
                break;
            }

            System.out.println("Marca da moto.......: " + marca);
            System.out.println("Modelo da moto.......: " + modelo);
            System.out.println("Origem da moto.......: " + origem);
            System.out.println("Estilo da moto.......: " + estilo);
            System.out.println("Cilindros da moto.......: " + cilindros);
            System.out.println("Cilindradas da moto.......: " + cilindradas);
            System.out.println("Potência da moto.......: " + potencia);
            System.out.println("Peso da moto.......: " + peso);
            System.out.println("Preço da moto.......: " + preco);
            System.out.println("Mês/Ano da moto.......: " + mesAnoFab);
            System.out.println();

            do {
                System.out.print("\nConfirma a exclusao deste aluno (S/N) ? ");
                confirmacao = Main.leia.next().charAt(0);
                if (confirmacao == 'S') {
                    desativarMoto(posicaoRegistro);
                }
            }while (confirmacao != 'S' && confirmacao != 'N');

        }while ( ! codMoto.equals("FIM"));
    }

    //************************  CONSULTA  *****************************
    public void consultar() 	{
        RandomAccessFile arqMoto;
        byte opcao;
        String codMotoC;
        String marcaAux;
        long posicaoRegistro;

        do {
            do {
                System.out.println(" ***************  CONSULTA DE ALUNOS  ***************** ");
                System.out.println(" [1] CONSULTAR APENAS 1 MOTO ");
                System.out.println(" [2] LISTA DE TODAS AS MOTOS ");
                System.out.println(" [3] LISTA SOMENTE DE UMA MARCA");
                System.out.println(" [4] LISTA DENTRO DE UMA FAIXA DE PREÇO");
                System.out.println(" [0] SAIR");
                System.out.print("\nDigite a opcao desejada: ");
                opcao = Main.leia.nextByte();
                if (opcao < 0 || opcao > 3) {
                    System.out.println("opcao Invalida, digite novamente.\n");
                }
            }while (opcao < 0 || opcao > 3);

            switch (opcao) {
                case 0:
                    System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
                    break;

                case 1:  // consulta de uma unica moto
                    Main.leia.nextLine();  // limpa buffer de memoria
                    System.out.print("Digite o Código da moto: ");
                    codMotoC = Main.leia.nextLine();

                    posicaoRegistro = pesquisarMoto(codMotoC);
                    if (posicaoRegistro == -1) {
                        System.out.println("Moto nao cadastrada no arquivo \n");
                    } else {
                        imprimirCabecalho();
                        imprimirMoto();
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                    }

                    break;

                case 2:  // imprime todas as motos
                    try {
                        arqMoto = new RandomAccessFile("MOTO.DAT", "rw");
                        imprimirCabecalho();
                        while (true) {
                            ativo		= arqMoto.readChar();
                            codMoto		= arqMoto.readUTF();
                            marca		= arqMoto.readUTF();
                            modelo		= arqMoto.readUTF();
                            origem		= arqMoto.readUTF();
                            estilo		= arqMoto.readUTF();
                            cilindradas = arqMoto.readInt();
                            potencia	= arqMoto.readInt();
                            peso		= arqMoto.readFloat();
                            preco		= arqMoto.readFloat();
                            mesAnoFab	= arqMoto.readUTF();

                            if ( ativo == 'S') {
                                imprimirMoto();
                            }
                        }
                        //    arqAluno.close();
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                        codMotoC = Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }
                    break;

                case 3:  // imprime alunos do sexo desejado
                    do {
                        System.out.print("Digite o Sexo desejado (M/F): ");
                        marcaAux = Main.leia.nextLine();
                        if (marcaAux != "" && marcaAux != "") {
                            System.out.println("Sexo Invalido, digite M ou F");
                        }
                    }while (marcaAux != "" && marcaAux != "");

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

                            if ( marcaAux == marcaAux && ativo == 'S') {
                                imprimirMoto();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                        codMotoC = Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }

            }

        } while ( opcao != 0 );
    }

    public void imprimirCabecalho () {
        System.out.println("-CODMOTO-  -------- MARCA ----------  --MODELO--  -ORIGEM-  -ESTILO-  --CIL--.  --POT--.  ----PRECO----  ---ANO--- ");
    }

    public void imprimirMoto () {
        System.out.println(	formatarString(codMoto, 6 ) + "  " +
                formatarString(marca , 15) + "  " +
                formatarString(modelo , 100) + "  " +
                formatarString( origem, 10 ) + "  " +
                formatarString( String.valueOf(cilindradas) , 4 ) + "  " +
                formatarString( String.valueOf(potencia) , 1000 ) + "  " +
                formatarString( String.valueOf(peso) , 13 ) + "  " +
                formatarString( String.valueOf(preco) , 13 ) + "  " +
                formatarString( mesAnoFab, 13 ) + "  " );

    }

    public static String formatarString (String texto, int tamanho) {
        // retorna uma string com o numero de caracteres passado como parametro em TAMANHO
        if (texto.length() > tamanho) {
            texto = texto.substring(0,tamanho);
        }else{
            while (texto.length() < tamanho) {
                texto = texto + " ";
            }
        }
        return texto;
    }
}