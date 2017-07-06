/* Checkpoint: Level 5 */
/* All Unique Permutations */
/* 
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations
 */

public class Solution {
    public int[][] permute(int[] A) {
        int divisor = 1;

        // sort array first to count duplicates
        Arrays.sort(A);

        int count = 1;
        for (int i=1; i<A.length; i++) {
            if (A[i-1] == A[i]) {
                count++;
            }
            else {
                divisor *= factorial(count);
                count = 1;
            }
        }
        divisor *= factorial(count);

        // total number of distinct permutations = factorial(A.length) / divisor
        int numPermutations = factorial(A.length) / divisor;
        int[][] result = new int[numPermutations][A.length];

        // copy sorted one into first index
        System.arraycopy(A, 0, result[0], 0, A.length);

        int j, k;
        // shuffle indices in lexigraphical order
        for (int i=1; i<numPermutations; i++) {
            // find largest index j such that A[j] < A[j+1]
            j = A.length - 2;
            /                                                                                                                                                                                                                                                                     while (A[j] >= A[j+1]) {
                j--;
            }

            // find largest index k such that A[j] < A[k]
            k = A.length - 1;
            while (A[j] >= A[k]) {
                k--;
            }

            // swap A[j] and A[k]
            int temp = A[j];
            A[j] = A[k];
            A[k] = temp;

            // sort remaining indices of array from A[j+1] until end
            Arrays.sort(A, j+1, A.length);

            // copy permutation into result array
            System.arraycopy(A, 0, result[i], 0, A.length);
        }

        return result;
    }

    // helper method to find factorial n!
    public int factorial(int n) {
        int result = 1;
        while (n > 1) {
            result = result * n;
            n--;
        }
        return result;
    }
}
