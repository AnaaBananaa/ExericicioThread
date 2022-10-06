public class UtilsMatriz {
    
    public static int[][] multiplicar(int[][] matrizA, int[][] matrizB) {
        int linhaC = matrizA.length;
        int colunaC = matrizB[0].length;
        int[][] c = new int[linhaC][colunaC];
        for (int linhaA = 0; linhaA < matrizA.length; linhaA++) {
            for (int colunaB = 0; colunaB < matrizB[0].length; colunaB++) {
                for (int aux = 0; aux < matrizA[0].length; aux++) {
                    c[linhaA][colunaB] += matrizA[linhaA][aux] * matrizB[aux][colunaB];
                }
            }
        }
        return c;
    }
    
    public static void imprimir(int[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.print("|\t");
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna]+"\t");
            }
            System.out.print("|\n");
        }
    }
}
