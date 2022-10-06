public class CalculaMatriz2Thread {

    public static void main(String[] args) {
        try {
            int[][] matrizA = LeitorArquivo.montarMatriz("./src/caso2/A.TXT");
            int[][] matrizB = LeitorArquivo.montarMatriz("./src/caso2/B.TXT");
            
            int linhaMatrizA1 = matrizA.length/2;
            int linhaMatrizA2 = matrizA.length-linhaMatrizA1;
            
            int[][] matrizA1 = new int[linhaMatrizA1][matrizA[0].length];
            int[][] matrizA2 = new int[linhaMatrizA2][matrizA[0].length];
            
            for (int linhaA1 = 0; linhaA1 < linhaMatrizA1; linhaA1++) {
                matrizA1[linhaA1] = matrizA[linhaA1];
            }
            for (int linhaA2 = linhaMatrizA1; linhaA2 < linhaMatrizA1+linhaMatrizA2; linhaA2++) {
                matrizA2[linhaA2-linhaMatrizA1] = matrizA[linhaA2];
            }
    
            CalculadoraMatrizThread thread1 = new CalculadoraMatrizThread(matrizA1, matrizB);
            thread1.start();
    
            CalculadoraMatrizThread thread2 = new CalculadoraMatrizThread(matrizA2, matrizB);
            thread2.start();
            
            thread1.join();
            thread2.join();
            
            int[][] matrizC = new int[matrizA.length][matrizB[0].length];
    
            int[][] matrizC1 = thread1.getMatrizC();
            for (int linhaC1 = 0; linhaC1 < matrizC1.length; linhaC1++) {
                matrizC[linhaC1] = matrizC1[linhaC1];
            }
            int[][] matrizC2 = thread2.getMatrizC();
            for (int linhaC2 = matrizC1.length; linhaC2 < matrizC1.length+matrizC2.length; linhaC2++) {
                matrizC[linhaC2] = matrizC2[linhaC2-matrizC1.length];
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
