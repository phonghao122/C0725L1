package ss3.services;
import ss3.commons.MatrixCommon;

public class SumMainDiagonalToMatrix {
    public static void main(String[] args) {
        int[][] matrix = MatrixCommon.inputMatrix();
        MatrixCommon.printMatrix(matrix);
        System.out.println("sum: "+ MatrixCommon.sumDiagonalMatrix(matrix));
    }
}
