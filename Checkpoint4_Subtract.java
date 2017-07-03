/* Chceckpoint: Level 4 */
/* Subtract */
/*
 * Given a singly linked list, modify the value of first half nodes such that :
 *
 * 1st nodes new value = the last nodes value - first nodes current value
 * 2nd nodes new value = the second last nodes value - 2nd nodes current value,
 * and so on 
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *      public int val;
 *      public ListNode next;
 *      ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        // find size of singly linked list
        int size = 0;
        ListNode current = A;
        while (current != null) {
            current = current.next;
            size++;
        }

        // make temp array to store first half
        int[] temp = new int[size/2];
        current = A;
        for (int i=0; i<size/2; i++) {
            temp[i] = current.val;
            current = current.next;
        }

        // if size is odd, skip the middle node
        if (size % 2 != 0) {
            current = current.next;
        }

        for (int i=size/2 -1; i>=0; i--) {
            temp[i] = current.val - temp[i];
            current = current.next;
        }

        // reassign subtacted values in array
        current = A;
        for (int i=0; i<size/2; i++) {
            current.val = temp[i];
            current = current.next;
        }

        return A;
    }
}

