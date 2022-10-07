import java.util.ArrayList;
import java.util.List;

public class CalculaMatrizXThread {

    public static void main(String[] args) {
        try {
            int[][] matrizA = LeitorArquivo.montarMatriz("./src/caso4/A.TXT");
            int[][] matrizB = LeitorArquivo.montarMatriz("./src/caso4/B.TXT");
            int[][] matrizC = new int[matrizA.length][matrizB[0].length];
            int numeroDeThread = 11;
            List<CalculadoraMatrizThread> threads = new ArrayList<>();
            
            if (matrizC.length > numeroDeThread) {
                int tamanhoMatrizesA = (matrizA.length%2 != 0 ? (matrizA.length+1) : matrizA.length)/numeroDeThread;
                for (int i = 0; i < numeroDeThread; i++) {
                    int inicioA = 0;
                    for (int j = 0; j < i; j++) {
                        inicioA += tamanhoMatrizesA;
                    }
                    CalculadoraMatrizThread thread;
                    if (i == numeroDeThread-1) {
                        thread = new CalculadoraMatrizThread(matrizA, matrizB, matrizC, inicioA, matrizA.length);
                    } else {
                        thread = new CalculadoraMatrizThread(matrizA, matrizB, matrizC, inicioA, inicioA + tamanhoMatrizesA);
                    }
                    thread.start();
                    threads.add(thread);
                }

            } else {
                for (int i = 0; i < matrizC.length; i++) {
                    CalculadoraMatrizThread thread = new CalculadoraMatrizThread(matrizA, matrizB, matrizC, i, i+1);
                    thread.start();
                    threads.add(thread);
                }
            }
            
            for (CalculadoraMatrizThread thread: threads) {
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
