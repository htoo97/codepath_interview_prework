/* Checkpoint: Level 5 */
/* Longest Consecutive Sequence */
/*
 * Given an unsorted array of integers, find the length of the longest 
 * consecutive elements sequence.
 */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        Set<Integer> set = new HashSet<Integer>();

        // add all elements to set
        for (int i=0; i<A.length; i++) {
            set.add(A[i]);
        }

        int max = 0;

        // iterate through all elements again
        for (int i=0; i<A.length; i++) {
            // A[i] is the start of a sequence
            if (!set.contains(A[i] - 1)) {
                int iterator = A[i] + 1;
                while (set.contains(iterator)) {
                    iterator++;
                }

                max = Math.max(max, iterator - A[i]);
            }
        }

        return max;
    }
}

