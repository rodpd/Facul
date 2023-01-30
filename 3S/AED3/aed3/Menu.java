package aed3;
import java.io.*;
import java.util.Scanner;

public class Menu {
    
    public static int readInt( ) {
        String input;
        int number = -1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            number = Integer.parseInt(input);
        }
        catch (NumberFormatException | IOException ex) {
        }
    return ( number );
    }
    
    public static short readShort( ) {
        String input;
        short number = -1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            number = Short.parseShort(input);
        }
        catch (NumberFormatException | IOException ex) {
        }
    return ( number );
    }
    
        public static double readDouble( ) {
        String input;
        double number = -1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            number = Double.parseDouble(input);
        }
        catch (NumberFormatException | IOException ex) {
        }
    return ( number );
    }
    
    public static void main ( String [] args ) throws IOException {
        
        RandomAccessFile arq = new RandomAccessFile("prods.db", "rw");
        //arq.writeByte(' ');
        arq.writeShort(26);
        char resposta;
        Scanner scanner = new Scanner(System.in);
        Produto p;
        ArquivoProduto arquivo = new ArquivoProduto("produtos.db");
        Indice indice = new Indice("indice.db");
        int opcao;
        do {
                System.out.println ( "1.Incluir"
                + "\n2.Busca"
                + "\n3.Exclusao"
                + "\n4.Alteracao"
                + "\n5.Listar produtos"
                + "\n6.Listar indices"
                + "\n7.Parar");
            opcao = readInt();
            p = new Produto ();
            switch (opcao) {
                case 1:                
                    System.out.println("Inclusao de produto");
                    System.out.println("Nome: ");
                    p.nome = scanner.nextLine();
                    System.out.println("Marca: ");
                    p.marca = scanner.nextLine();
                    System.out.println("Categoria: ");
                    p.categoria = scanner.nextLine();
                    System.out.println("Descricao: ");
                    p.descricao = scanner.nextLine();
                    System.out.println("Preco: ");
                    p.preco = readDouble();
                    System.out.println("\n");
                    p.mostrar();
                    System.out.println("Inserir produto?(S/N)");
                    resposta = scanner.nextLine().charAt(0);
                switch (resposta) {
                    case 'S':
                    case 's':
                        arquivo.incluir(p);
                        indice.incluir(p.id, p.endereco);
                        System.out.println("Produto de ID " + p.id + " inserido com sucesso");
                        break;
                    case 'N':
                    case 'n':
                        System.out.println("Produto nao inserido");
                        break;
                    default:
                        System.out.println("Opcao invalida");
                        break;
                }
                    break;
                case 2:
                    System.out.println("Busca");
                    System.out.println("ID do produto: ");
                    do {
                        p.id = readShort();
                        if (p.id == -1) {
                            System.out.println("Opcao invalida"
                                    + "ID do produto: ");
                        }
                    } while ( p.id == -1 );
                    p.endereco = indice.buscar(p.id);
                    // se encontrado no indice, procurar no arquivo
                    if ( p.endereco != -1 ) {
                        arquivo.buscar(p.id, p.endereco);
                    }
                    else {
                        System.out.println("Produto nao encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Exclusao");
                    System.out.println("ID do produto: ");
                    do {
                        p.id = readShort();
                        if (p.id == -1) {
                            System.out.println("Opcao invalida"
                                    + "ID do produto: ");
                        }
                    } while ( p.id == -1 );
                    p.endereco = indice.buscar(p.id);
                    // se encontrado no indice, procurar no arquivo
                    if ( p.endereco != -1 ) {
                        p = arquivo.buscar(p.id, p.endereco);
                        if (p != null) {
                            p.mostrarID();
                            System.out.println("Excluir produto?(S/N)");
                            resposta = scanner.nextLine().charAt(0);
                            switch (resposta) {
                                case 'S':
                                case 's':
                                    indice.excluir(p.id);
                                    arquivo.excluir( p.endereco);
                                    break;
                                case 'N':
                                case 'n':
                                    System.out.println("Arquivo nao excluido");
                                    break;
                                default:
                                    System.out.println ("Opcao invalida");
                                    break;
                            }
                        }
                    }
                    else {
                        System.out.println("Produto nao encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Alteracao");
                    System.out.println("ID do produto: ");
                    do {
                        p.id = readShort();
                        if (p.id == -1) {
                            System.out.println("Opcao invalida"
                                    + "ID do produto: ");
                        }
                    } while ( p.id == -1 );
                    p.endereco = indice.buscar(p.id);
                    // se encontrado no indice, procurar no arquivo
                    if ( p.endereco != -1 ) {
                        p = arquivo.buscar(p.id, p.endereco);
                        if (p != null) {
                            System.out.println("Nome: ");
                            p.nome = scanner.nextLine();
                            System.out.println("Marca: ");
                            p.marca = scanner.nextLine();
                            System.out.println("Categoria: ");
                            p.categoria = scanner.nextLine();
                            System.out.println("Descricao: ");
                            p.descricao = scanner.nextLine();
                            System.out.println("Preco: ");
                            p.preco = readDouble();
                            p.mostrarID();
                            System.out.println("Alterar para produto acima?(S/N)");
                            resposta = scanner.nextLine().charAt(0);
                            switch (resposta) {
                                case 'S':
                                case 's':
                                    arquivo.excluir(p.endereco);
                                    arquivo.incluir(p);
                                    indice.alterar(p.id, p.endereco);
                                    break;
                                case 'N':
                                case 'n':
                                    System.out.println("Arquivo nao alterado");
                                    break;
                                default:
                                    System.out.println ("Opcao invalida");
                                    break;
                            }
                        }
                    }
                    else {
                        System.out.println("Produto nao encontrado");
                    }
                    break;
                case 5:
                    arquivo.listar();
                    break;
                case 6:
                    indice.listar();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while ( opcao != 7 );
    }
}
