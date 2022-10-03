
public class CalculaMatrizSemThread {

    public static void main(String[] args) {
        int[][] matrizA = {{7, 4, 3, 6},{5, 0, 5, 4},{5, 6, 8, 9}};
        int[][] matrizB = {{2, 8, 0},{3, 1, 0},{4, 9, 8}, {1,6,0}};
        calculaMatriz(matrizA, matrizB);
    }

    public static void calculaMatriz(int[][] matrizA, int[][] matrizB){
        int[][] matrizC = new int[matrizA.length][matrizA.length];
        for (int l = 0; l < matrizA.length; l++) {
            for (int co = 0; co < matrizA.length; co++) {
                matrizC[l][co] = matrizA[l][co] * matrizB[l][co];
            }
        }
    }

}
