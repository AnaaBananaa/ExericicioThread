public class CalculaMatrizSemThread {

    public static void main(String[] args) {
        try {
            int[][] matrizA = LeitorArquivo.montarMatriz("./src/caso4/A.TXT");
            int[][] matrizB = LeitorArquivo.montarMatriz("./src/caso4/B.TXT");
            int[][] matrizC = new int[matrizA.length][matrizB[0].length];
            UtilsMatriz.multiplicar(matrizA, matrizB, matrizC, 0, matrizA.length);
            System.out.println("Matriz A");
            UtilsMatriz.imprimir(matrizA);
            System.out.println("\nMatriz B");
            UtilsMatriz.imprimir(matrizB);
            System.out.println("\nMatriz C");
            UtilsMatriz.imprimir(matrizC);
        } catch(Exception e) {
            System.out.println("Nao foi possivel localizar um arquivo valido nesse caminho");
        }
    }
}
