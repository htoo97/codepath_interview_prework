/* Checkpoint: Level 2 */
/* Prettyprint */
/*
 * Print concentric rectangular pattern in a 2d matrix. 
 */

public class Solution {
    public int[][] prettyPrint(int A) {
        int size = 2*A - 1;
        int[][] arr = new int[size][size];

        int mid = A-1;    // or size / 2

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int rowDiff = Math.abs(mid-row);
                int colDiff = Math.abs(mid-col);

                // arr[row[col] = larger difference from middle + 1
                arr[row][col] = 1;
                arr[row][col] += ((rowDiff > colDiff)? rowDiff : colDiff);
            }
        }

        return arr;
    }
}
