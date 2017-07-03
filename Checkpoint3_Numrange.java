/* Checkpoint: Level 3 */
/* Numrange */
/*
 * Given an array of non negative integers A, and a range (B, C), 
 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
 *
 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 * where 0 <= i <= j < size(A)
 */

public class Solution {
    public int numRange(int[] A, int B, int C) {
        int count = 0;

        for (int i=0; i<A.length; i++) {

            int j = i;
            int sum = 0;
            // for each number, iterate through the array and find sum
            while (j<A.length) {

                if (A[j] > C) {
                    break;
                }

                sum += A[j];

                if (sum >= B && sum <= C) {
                    count++;
                }
                else if (sum > C && j != A.length-1) {
                    break;
                }


                j++;
            }
        }

        return count;
    }
}

