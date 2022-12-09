package procuras;

/**
 * @authors António Kudiezo, Rosário de Cristo & Marcos Danilson
 */
public class ProcuraDiagonal {
    public static boolean procurarNaDiagonalPrincipalParaCimaDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                l--; c--;
                if(l < 0 || c < 0)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
    public static boolean procurarNaDiagonalPrincipalParaBaixoDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                l++; c++;
                if(l == tabelaCacaPalavras.length || c == tabelaCacaPalavras[0].length)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
    public static boolean procurarNaDiagonalSecundariaParaCimaDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                l--; c++;
                if(l < 0 || c == tabelaCacaPalavras[0].length)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
    public static boolean procurarNaDiagonalSecundariaParaBaixoDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                l++; c--;
                if(l == tabelaCacaPalavras.length || c < 0)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
}
