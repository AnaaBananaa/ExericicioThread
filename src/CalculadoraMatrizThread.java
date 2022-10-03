public class CalculadoraMatrizThread extends Thread {

    private int[][] matrizA;
    private int[][] matrizB;

    public CalculadoraMatrizThread(int[][] matrizA, int[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    @Override
    public void run() {
        int[][] matrizC = new int[matrizA.length] [matrizB[0].length];
        for (int l = 0; l < matrizA.length; l++) {
            for (int co = 0; co < matrizA.length; co++) {
                matrizC[l][co] = matrizA[l][co] * matrizB[l][co];
            }
        }
    }
}
