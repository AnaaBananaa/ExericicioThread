import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculaMatrizXThread {

    public static void main(String[] args) {
        try {
            int[][] matrizA = LeitorArquivo.montarMatriz("./src/caso2/A.TXT");
            int[][] matrizB = LeitorArquivo.montarMatriz("./src/caso2/B.TXT");
            int numeroDeThread = 4;
            int[] linhasMatrizesA = new int[numeroDeThread];
            List<int[][]> matrizesA = new ArrayList<>();
            List<CalculadoraMatrizThread> threads = new ArrayList<>();
            
            for (int i = 0; i < numeroDeThread; i++) {
                int linhaA = matrizA.length;
                if (linhaA%2 != 0) {
                    linhaA++;
                }
                if (i == numeroDeThread-1) {
                    linhasMatrizesA[i] = matrizA.length - Arrays.stream(linhasMatrizesA).sum();
                } else {
                    linhasMatrizesA[i] = linhaA/numeroDeThread;
                }
            }
            
            for (int i = 0; i < numeroDeThread; i++) {
                matrizesA.add(new int[linhasMatrizesA[i]][matrizA[0].length]);
            }
            
            for (int i = 0; i < numeroDeThread; i++) {
                int[][] matriz = matrizesA.get(i);
                int diminuir = 0;
                for (int j = 0; j < i; j++) {
                    diminuir += matrizesA.get(j).length;
                }
                for (int linhaA = diminuir; linhaA < diminuir+matriz.length; linhaA++) {
                    matriz[linhaA-diminuir] = matrizA[linhaA];
                }
            }
           
            for (int[][] matriz : matrizesA) {
                CalculadoraMatrizThread thread = new CalculadoraMatrizThread(matriz, matrizB);
                thread.start();
                threads.add(thread);
            }

            int[][] matrizC = new int[matrizA.length][matrizB[0].length];

            for (int i = 0; i < numeroDeThread; i++) {
                threads.get(i).join();
                int[][] matriz = threads.get(i).getMatrizC();
                int diminuir = 0;
                for (int j = 0; j < i; j++) {
                    diminuir += threads.get(j).getMatrizC().length;
                }
                for (int linhaC = diminuir; linhaC < diminuir+matriz.length; linhaC++) {
                    matrizC[linhaC] = matriz[linhaC-diminuir];
                }
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
