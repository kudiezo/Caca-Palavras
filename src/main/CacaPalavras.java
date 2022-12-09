package main;
import java.io.IOException;
import java.util.Scanner;

/**
 * @authors António Kudiezo, Rosário de Cristo & Marcos Danilson
 */
public class CacaPalavras {
    public static void main(String[] args) throws IOException {
    /**
     * Lógica do programa
     */
        while(true){
            menu();
            Scanner leitura = new Scanner(System.in);
            int opt = leitura.nextInt();
            switch(opt){
                case 1:
                    System.out.println("POR FAVOR, INSIRA OS DADOS DE ENTRADA SEGUINDO A REGRA DE ENTRADA");
                    runEntradaManual();
                    break;
                case 2:
                    System.out.println("SAÍDA:");
                    Ficheiro.runEntradaFicheiro();
                    break;
                case 0:
                    Ficheiro.terminarSessao();
                    System.out.println("\nTerminando sessão...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        }
    }
/**
 *  @runEntradaManual: função com a lógica do programa, com a entrada dos dados manual
 */
    static void runEntradaManual() throws IOException{
        Scanner leitura = new Scanner(System.in);
        char[][] tabelaCacaPalavra;
            String mn;
            int m, n, k;
            StringBuilder palavras = new StringBuilder();
            StringBuilder saida = new StringBuilder();
            int quantidadeDeCacaPalavras = Integer.parseInt(leitura.nextLine().trim());
            Ficheiro.escritaTemporaria("Entrada manual: ");//Escrevendo no ficheiro temporário que depois será YYYYMMDDhhmmss.txt
            Ficheiro.escritaTemporaria(Integer.toString(quantidadeDeCacaPalavras));//Escrevendo no ficheiro temporário que depois será YYYYMMDDhhmmss.txt
            System.out.print("\n");
            for(int i = 0; i < quantidadeDeCacaPalavras; i++){
                mn = leitura.nextLine().trim();
                m = Integer.parseInt(mn.split(" ")[0]);
                n = Integer.parseInt(mn.split(" ")[1]);
                if(n > 50 || n < 1 || m > 50 || m < 1){
                    System.out.println("Número de linhas/colunas fora do limite! Programa terminado...");
                    Ficheiro.escritaTemporaria("Houve erro!\n");
                    Ficheiro.terminarSessao();
                    System.exit(0);
                }
                Ficheiro.escritaTemporaria("\n"+mn);//Escrevendo no ficheiro temporário que depois será YYYYMMDDhhmmss.txt
                tabelaCacaPalavra = criarCacaPalavra(m, n);
                k = Integer.parseInt(leitura.nextLine().trim());
                if(k > 20 || k < 1){
                    System.out.println("Número de palavras a procura fora do limite! Programa terminado...");
                    Ficheiro.escritaTemporaria("Houve erro!\n");
                    Ficheiro.terminarSessao();
                    System.exit(0);
                }
                Ficheiro.escritaTemporaria(Integer.toString(k));
                for(int c = 0; c < k; c++){
                    palavras.append(leitura.nextLine().trim());
                    if(c != k-1)
                        palavras.append(',');
                }
                Ficheiro.escritaTemporaria(palavras.toString().replaceAll(",", "\n"));
                saida.append(procurar(tabelaCacaPalavra, palavras.toString().split(",")));
                saida.append(";");
                palavras = palavras.replace(0, palavras.length(), "");
                System.out.print("\n");
            }
            System.out.println("SAÍDA:");
            System.out.print(saida.toString().replace(";", "\n").replace(",", "\n"));
            Ficheiro.escritaTemporaria("\nSaída:\n"+saida.toString().replace(";", "\n").replace(",", "\n"));//Escrevendo no ficheiro temporário que depois será YYYYMMDDhhmmss.txt
    }
    
/**
 * @criarCacaPalavra: recebe dois parámetros inteiros "m" e "n" que representam número 
 * de linhas e colunas respectivamente, cria o caça palavras de m x n, preenche-o e retorna-o
 */
    static char[][] criarCacaPalavra(int m, int n) throws IOException{
        char[][] tabelaCacaPalavras = new char[m][n];
        String leituraDaLinha;
        Scanner leitura = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            leituraDaLinha = leitura.nextLine().replaceAll(" ", "");
            if(leituraDaLinha.length() != n){
                System.out.printf("Erro! Cada linha deve ter %d letras. Programa terminado...\n", n);
                Ficheiro.escritaTemporaria("Houve erro!\n");
                Ficheiro.terminarSessao();
                System.exit(0);
            }
            Ficheiro.escritaTemporaria(leituraDaLinha);//Escrevendo no ficheiro temporário que depois será YYYYMMDDhhmmss.txt
            tabelaCacaPalavras[i] = leituraDaLinha.toCharArray();
        }
        return tabelaCacaPalavras;
    }
/**
 * Função procurar
 * @Recebe:
 *      matriz "char[][] tabelaCacaPalavras" -> tabela de caça palavras;
 *      vector "String[] listaDePalavras" -> vector com a lista de palavras a procura.
 * @Retorna: 
 *      StringBuilder -> contendo as posições onde se encontram as primeiras letras das palavras separadas por vírgula
 */
    static StringBuilder procurar(char[][] tabelaCacaPalavras, String[] listaDePalavras){
        StringBuilder resultado = new StringBuilder();
        forExterno:
        for(String palavra: listaDePalavras){
            for(int i = 0; i < tabelaCacaPalavras.length; i++){
                for(int j = 0; j < tabelaCacaPalavras[0].length; j++){
                    if(procurarPalavraNaPosicao(tabelaCacaPalavras, i, j, palavra) == true){
                        resultado.append((i+1));
                        resultado.append(" ");
                        resultado.append((j+1));
                        resultado.append(",");
                        continue forExterno;
                    }
                }
            }
        }
        return resultado;
    }
/**
 * Função procurarPalavraNaPosicao 
 * @Recebe:
 *      matriz "char[][] tabelaCacaPalavras" -> tabela de caça palavras; 
 *      inteiros "int linha, int coluna" -> determinada posição do caça palavra ([linha][coluna]);
 *      string "String palavra" -> palavra a ser procurada.
 * @Faz:
 *      procura a palavra em todas as direçoes da posição dada ([linha][coluna])
 * @Retorna:
 *      "true" se encontrar a palavra numa das direções da posição dada, "false", senão
 */
    static boolean procurarPalavraNaPosicao(char[][] tabelaCacaPalavras, int linha, int coluna, String palavra){
        boolean direcao1, direcao2, direcao3, direcao4;
        boolean direcao5, direcao6, direcao7, direcao8;
        direcao1 = procuras.ProcuraHorizontal.procurarAEsquerdaDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        direcao2 = procuras.ProcuraHorizontal.procurarADireitaDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        direcao3 = procuras.ProcuraVertical.procurarAcimaDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        direcao4 = procuras.ProcuraVertical.procurarAbaixoDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        direcao5 = procuras.ProcuraDiagonal.procurarNaDiagonalPrincipalParaCimaDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        direcao6 = procuras.ProcuraDiagonal.procurarNaDiagonalPrincipalParaBaixoDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        direcao7 = procuras.ProcuraDiagonal.procurarNaDiagonalSecundariaParaCimaDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        direcao8 = procuras.ProcuraDiagonal.procurarNaDiagonalSecundariaParaBaixoDaPosicao(tabelaCacaPalavras, linha, coluna, palavra);
        return direcao1 || direcao2 || direcao3 || direcao4 || direcao5 || direcao6 || direcao7 || direcao8;
    }
/**
 * MENU DO PROGRAMA
 */
    static void menu(){
        System.out.println(">>>MENU CAÇA PALAVRAS<<<");
        System.out.println("|1| - ENTRADA MANUAL");
        System.out.println("|2| - ENTRADA PELO FICHEIRO (OS DASOS DEVEM SER INTRODUZIDOS NO FICHEIRO \"entrada.txt\" SEGUINDO A REGRA DE ENTRADA)");
        System.out.println("|0| - TERMINAR SESSÃO");
    }
}