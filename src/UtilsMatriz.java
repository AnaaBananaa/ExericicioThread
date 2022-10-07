public class UtilsMatriz {
    
    public static void multiplicar(int[][] matrizA, int[][] matrizB, int[][] matrizC, int inicioA, int fimA) {
        for (int linhaA = inicioA; linhaA < fimA; linhaA++) {
            for (int colunaB = 0; colunaB < matrizB[0].length; colunaB++) {
                for (int aux = 0; aux < matrizA[0].length; aux++) {
                    matrizC[linhaA][colunaB] += matrizA[linhaA][aux] * matrizB[aux][colunaB];
                }
            }
        }
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
