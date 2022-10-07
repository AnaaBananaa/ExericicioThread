import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculaMatrizYThread {

    public static void main(String[] args) {
        try {
            int[][] matrizA = LeitorArquivo.montarMatriz("./src/caso2/A.TXT");
            int[][] matrizB = LeitorArquivo.montarMatriz("./src/caso2/B.TXT");
            int[][] matrizC = new int[matrizA.length][matrizB[0].length];
            int linhasDaMatrizC = matrizC.length;
            List<CalculadoraMatrizThread> threads = new ArrayList<>();

            for (int i = 0; i < linhasDaMatrizC; i++) {
                CalculadoraMatrizThread thread = new CalculadoraMatrizThread(matrizA, matrizB, matrizC, i, i+1);
                thread.start();
                threads.add(thread);
            }
            
            for (CalculadoraMatrizThread thread : threads) {
                thread.join();
            }

            System.out.println("Matriz A");
            UtilsMatriz.imprimir(matrizA);
            System.out.println("\nMatriz B");
            UtilsMatriz.imprimir(matrizB);
            System.out.println("\nMatriz C");
            UtilsMatriz.imprimir(matrizC);
        } catch (InterruptedException e) {
            System.out.println("Ocorreu algum problema no gerenciamento de threads");
        } catch(Exception e) {
            System.out.println("Nao foi possivel localizar um arquivo valido nesse caminho");
        }
    }
}
