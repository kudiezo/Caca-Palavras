package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static main.CacaPalavras.procurar;

/**
 * @authors António Kudiezo, Rosário de Cristo & Marcos Danilson
 */
public class Ficheiro {
/**
 * @runEntradaFicheiro: função em que a lógica do programa é feita com a entrada dos dados 
 * feita pelo ficheiro "entrada.txt" que se encontra na pasta principal do projecto
 */
    static void runEntradaFicheiro() throws IOException{
        Scanner ficheiro;
        StringBuilder conteudo = new StringBuilder();
        try {
            ficheiro = new Scanner(new File("entrada.txt"));
            while(ficheiro.hasNext()){
                conteudo.append(ficheiro.nextLine());
                conteudo.append("-");//Cada quebra de linha vai ser representada por "-"
            }
            ficheiro.close();
            
            String[] conteudoLinhaALinha;
            conteudoLinhaALinha = conteudo.toString().split("-");
            char[][] tabelaCacaPalavra;
            String mn;
            int m, n, k, linhaDeLeituraAtual = 0;
            StringBuilder palavras = new StringBuilder();
            StringBuilder saida = new StringBuilder();
            int quantidadeDeCacaPalavras = Integer.parseInt(conteudoLinhaALinha[linhaDeLeituraAtual].trim());
            linhaDeLeituraAtual += 2;
            for(int i = 0; i < quantidadeDeCacaPalavras; i++){
                mn = conteudoLinhaALinha[linhaDeLeituraAtual];
                m = Integer.parseInt(mn.split(" ")[0]);
                n = Integer.parseInt(mn.split(" ")[1]);
                if(n > 50 || n < 1 || m > 50 || m < 1){
                    System.out.println("Dados mal introduzidos no ficheiro de entrada \nNúmero de linhas/colunas fora do limite! Programa terminado...");
                    System.exit(0);
                }
                linhaDeLeituraAtual++;
                tabelaCacaPalavra = criarCacaPalavraEntradaDoFicheiro(m, n, conteudoLinhaALinha, linhaDeLeituraAtual);
                linhaDeLeituraAtual += m;
                k = Integer.parseInt(conteudoLinhaALinha[linhaDeLeituraAtual].trim());
                if(k > 20 || k < 1){
                    System.out.println("Dados mal introduzidos no ficheiro de entrada \nNúmero de palavras a procura fora do limite! Programa terminado...");
                    System.exit(0);
                }
                linhaDeLeituraAtual++;
                for(int c = 1; c <= k; c++){
                    palavras.append(conteudoLinhaALinha[linhaDeLeituraAtual].trim());
                    palavras.append(',');
                    linhaDeLeituraAtual++;
                }
                saida.append(procurar(tabelaCacaPalavra, palavras.toString().split(",")));
                saida.append(";");
                linhaDeLeituraAtual += 1;
                palavras = palavras.replace(0, palavras.length(), "");
            }
            System.out.print(saida.toString().replace(";", "\n").replace(",", "\n"));
            Ficheiro.escritaTemporaria("Saída da entrada pelo ficheiro: \n"+saida.toString().replace(";", "\n").replace(",", "\n"));//Escrevendo a saída no ficheiro
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
/**
 * @criarCacaPalavraEntradaDoFicheiro: recebe dois parámetros inteiros "m" e "n" que representam número 
 * de linhas e colunas respectivamente, cria o caça palavras de m x n, preenche-o com os dados vindos
 * do ficheiro "entrada.txt", e retorna-o
 */
    static char[][] criarCacaPalavraEntradaDoFicheiro(int m, int n, String[] conteudoLinhaALinha, int ultimaLinhaDeLeitura){
        char[][] tabelaCacaPalavras = new char[m][n];
        String leituraDaLinha;
        for (int i = 0; i < m; i++) {
            leituraDaLinha = conteudoLinhaALinha[ultimaLinhaDeLeitura].replaceAll(" ", "");
            ultimaLinhaDeLeitura++;
            if(leituraDaLinha.length() != n){
                System.out.println("Dados mal introduzidos no ficheiro de entrada \nNúmero de palavras por linha não satisfaz! Programa terminado...");
                System.exit(0);
            }
            tabelaCacaPalavras[i] = leituraDaLinha.toCharArray();
        }
        return tabelaCacaPalavras;
    }
/**
 * @escritaTemporaria: função recebe a escrita "String texto" e escreve 
 * no ficheiro "temporario.txt" que posteriormente, quando a sessão for terminada, terá
 * nomeclatura “YYYYMMDDhhmmss.txt"
 */
    static void escritaTemporaria(String texto) throws IOException {
        try {
            FileWriter fw = new FileWriter("temporario.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter escrita = new PrintWriter(bw);
            escrita.println(texto);
            escrita.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
 /**
  * @terminarSessao: Renomea o ficheiro "temporario.txt" para "“YYYYMMDDhhmmss.txt"
  */
    static void terminarSessao(){
        DateTimeFormatter dataEHora = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String nomeDaSessao = dataEHora.format(LocalDateTime.now());
        File temporario = new File("temporario.txt");
        File fimDeSessao = new File(nomeDaSessao+".txt");
        temporario.renameTo(fimDeSessao);
    }
}
