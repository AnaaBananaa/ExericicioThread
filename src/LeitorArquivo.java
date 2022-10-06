import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeitorArquivo {
    
    public static int[][] montarMatriz(String caminho) throws Exception {
        List<String> linhas = Files.readAllLines(Paths.get(caminho));
        int[][] matriz = new int[Integer.parseInt(linhas.get(0))][Integer.parseInt(linhas.get(1))];
        linhas.remove(0);
        linhas.remove(0);
        for (int linha = 0; linha < linhas.size(); linha++) {
            String[] colunas = linhas.get(linha).split(" ");
            for (int coluna = 0; coluna < colunas.length; coluna++) {
                matriz[linha][coluna] = Integer.parseInt(colunas[coluna]);
            }
        }
        return matriz;
    }
}
