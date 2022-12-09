package procuras;
/**
 * @authors António Kudiezo, Rosário de Cristo & Marcos Danilson
 */
public class ProcuraVertical {
    public static boolean procurarAcimaDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                l--;
                if(l < 0)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
    public static boolean procurarAbaixoDaPosicao(char[][] tabelaCacaPalavras, int l, int c, String palavra){
        int k = 0; //Contador de letras
        for(char letra: palavra.toCharArray()){
            k++;
            if(tabelaCacaPalavras[l][c] == letra){
                l++;
                if(l == tabelaCacaPalavras.length)
                    return k == palavra.length();
                continue;
            }
            return false;
        }
        return true;
    }
}