package procuras;

/**
 * @authors António Kudiezo, Rosário de Cristo & Marcos Danilson
 */
public class ProcuraHorizontal {
    public static boolean procurarADireitaDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                c++;
                if(c == tabelaCacaPalavras[0].length)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
    public static boolean procurarAEsquerdaDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                c--;
                if(c < 0)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
}
