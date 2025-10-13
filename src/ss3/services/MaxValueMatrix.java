package ss3.services;

import ss3.commons.MatrixCommon;

public class MaxValueMatrix {
    public static void main(String[] args) {
        int[][] matrix = MatrixCommon.inputMatrix();
        MatrixCommon.printMatrix(matrix);
        System.out.println("Max: " + MatrixCommon.findMaxValue(matrix));
    }
}
