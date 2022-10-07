public class CalculaMatriz2Thread {

    public static void main(String[] args) {
        try {
            int[][] matrizA = LeitorArquivo.montarMatriz("./src/caso4/A.TXT");
            int[][] matrizB = LeitorArquivo.montarMatriz("./src/caso4/B.TXT");
            int[][] matrizC = new int[matrizA.length][matrizB[0].length];
            int linhasMatrizA1 = matrizA.length/2;
            int linhasMatrizA2 = matrizA.length-linhasMatrizA1;

            CalculadoraMatrizThread thread1 = new CalculadoraMatrizThread(matrizA, matrizB, matrizC, 0, linhasMatrizA1);
            thread1.start();

            CalculadoraMatrizThread thread2 = new CalculadoraMatrizThread(matrizA, matrizB, matrizC, linhasMatrizA1, linhasMatrizA1+linhasMatrizA2);
            thread2.start();

            thread1.join();
            thread2.join();

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
