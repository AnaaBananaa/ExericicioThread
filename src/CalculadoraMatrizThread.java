public class CalculadoraMatrizThread extends Thread {

    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] matrizC;
    private int inicioA;
    private int fimA;

    public CalculadoraMatrizThread(int[][] matrizA, int[][] matrizB, int[][] matrizC, int inicioA, int fimA) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.matrizC = matrizC;
        this.inicioA = inicioA;
        this.fimA = fimA;
    }

    @Override
    public void run() {
        UtilsMatriz.multiplicar(matrizA, matrizB, matrizC, inicioA, fimA);
    }
}
