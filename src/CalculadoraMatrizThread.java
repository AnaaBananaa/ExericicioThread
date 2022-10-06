public class CalculadoraMatrizThread extends Thread {

    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] matrizC;

    public CalculadoraMatrizThread(int[][] matrizA, int[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    @Override
    public void run() {
        matrizC = UtilsMatriz.multiplicar(matrizA, matrizB);
    }
    
    public int[][] getMatrizC() {
        return matrizC;
    }
}
