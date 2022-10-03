public class CalculadoraMatriz2Thread {

    public static void main(String[] args) {
        int[][] matrizA = {{7, 4, 3, 6},{5, 0, 5, 4},{5, 6, 8, 9}};
        int[][] matrizB = {{2, 8, 0},{3, 1, 0},{4, 9, 8}, {1,6,0}};
        CalculadoraMatrizThread thread1 = new CalculadoraMatrizThread(matrizA, matrizB);
        thread1.start();

        CalculadoraMatrizThread thread2 = new CalculadoraMatrizThread(matrizA, matrizB);
        thread2.start();
    }
}
