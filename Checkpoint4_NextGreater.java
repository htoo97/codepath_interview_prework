/* Checkpoint: Level 4 */
/* Next Greater */
/*
 * Given an array, find the next greater element G[i] for every element A[i] in the array.
 * The Next greater Element for an element A[i] is the first greater element on the right 
 * side of A[i] in array. 
 */

public class Solution {
    public int[] nextGreater(int[] A) {
        int[] output = new int[A.length];

        for (int i=0; i<A.length; i++) {
            int nGIndex = i+1;

            while (nGIndex < A.length) {
                if (A[nGIndex] <= A[i]) {
                    nGIndex++;
                }
                else {
                    break;
                }
            }

            output[i] = (nGIndex == A.length)? -1 : A[nGIndex];
        }

        return output;
    }
}

