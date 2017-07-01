/* Checkpoint: Level 3 */
/* Numrange */

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

