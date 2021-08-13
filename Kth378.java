import java.util.ArrayList;
import java.util.Arrays;

public class Kth378 {

    public int kthSmallest(int[][] matrix, int k) {
        int matrixSize = matrix.length * matrix.length;
        int queue[] = new int[matrixSize];
        int queueIndex = 0;

        int[] startLine = new int[matrix.length];
        int starter [] = new int[matrix.length];

        int x = 0;
        int y = 0;

        int smaller = matrix[x][y];
        int smallerLine = x;

        do {

            for (int i = 0; i < matrix.length; i++) {

                if (startLine[i] < matrix.length ) {
                    if (matrix[i][startLine[i]] < smaller || (matrix[i][startLine[i]] == smaller)) {
                        smaller = matrix[i][startLine[i]];
                        smallerLine = i;
                    }
                }

            }

            queue[queueIndex] = smaller;
            queueIndex++;
            startLine[smallerLine]++;

            for (int l = 0; l < startLine.length; l++) {
                if (startLine[l] < matrix.length) {
                    smaller = matrix[l][startLine[l]];
                    break;
                }
            }

            for (int l = 0; l < startLine.length; l++) {
                starter[l] = startLine[l];
            }
            Arrays.sort(starter);

        } while (starter[0] != matrix.length);

        return queue[k-1];
    }

    public static void main(String[] args) {
        Kth378 obj = new Kth378();
        int matrix[][] = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int r = obj.kthSmallest(matrix, 8);
        System.out.println(r);
    }

}
