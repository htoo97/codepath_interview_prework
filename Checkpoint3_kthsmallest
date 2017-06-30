/* Checkpoint: Level 3 */
/* Kth Smallest Element in the Array */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int temp[] = new int[B];

        for (int i=0; i<B; i++) {
            temp[i] = A[i];    
        }

        for (int i=B; i<A.length; i++) {
            int maxIndex = findMaxIndex(temp);
            if (A[i] < temp[maxIndex]) {
                temp[maxIndex] = A[i];
            }
        }

        return temp[findMaxIndex(temp)];
    }

    // helper function to find maximum in temporary array
    public int findMaxIndex(final int[] A) {
        int maxIndex = 0;
        for (int i=1; i<A.length; i++) {
            if (A[i] > A[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}

