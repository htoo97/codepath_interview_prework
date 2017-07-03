/* Checkpoint: Level 3 */
/* Kth Smallest Element in the Array */
/*
 * Find the kth smallest element in an unsorted array of non-negative integers.
 */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int heap[] = new int[B];

        for (int i=0; i<B; i++) {
            heap[i] = A[i];    
            int parent;   // integer division - floor
            int current = i;
            while ((parent = (current-1)/2) >= 0 && heap[parent] < heap[current]) {
                // swap parent and child
                int temp = heap[parent];
                heap[parent] = heap[current];
                heap[current] = temp;
                current = parent;
            }
        }

        for (int i=B; i<A.length; i++) {
            // compare with heap of max heap
            if (A[i] < heap[0]) {
                heap[0] = A[i];

                int j=0;
                int left, right, swapIndex;
                // trickle down new element at root
                // get larger element among the two children

                do {
                    left = 2*j + 1;
                    right = 2*j + 2;

                    // both left and right in bounds
                    if (left < heap.length && right < heap.length) {
                        swapIndex = (heap[left] > heap[right])? left : right;
                    }
                    // right out of bounds
                    else if (left < heap.length) {
                        swapIndex = left;
                    }
                    // left out of bounds
                    else if (right < heap.length) {
                        swapIndex = right;
                    }
                    // no left or right children
                    else {
                        break;
                    }

                    if (heap[j] < heap[swapIndex]) {
                        // swap 
                        int temp = heap[j];
                        heap[j] = heap[swapIndex];
                        heap[swapIndex] = temp;
                        j = swapIndex;
                    }
                    else {
                        break;
                    }

                } while (j < heap.length);
            }
        }

        // return kth smallest at root of max heap of k elements
        return heap[0];
    }
}

