class Solution {
    
    // Function to find the middle node of the linked list
    public ListNode getMid(ListNode head) {
        ListNode fp = head, sp = head; // fp = fast pointer, sp = slow pointer
        
        // Move fast by 2 steps and slow by 1 step to find the middle
        while (fp.next != null && fp.next.next != null) {
            fp = fp.next.next;  // Move fast pointer two steps
            sp = sp.next;        // Move slow pointer one step
        }
        
        return sp; // Slow pointer will be at the middle
    }

    // Function to merge two sorted linked lists
    public ListNode mergeSortedLL(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(-1); // Dummy node to simplify merging
        ListNode temp = dummyHead; // Pointer to track the merged list

        // Merging both lists using two-pointer technique
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) { // Choose the smaller value
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }

        // Append remaining nodes from either list
        if (h1 != null) temp.next = h1;
        if (h2 != null) temp.next = h2;

        return dummyHead.next; // Return merged sorted list
    }

    // Function to perform Merge Sort on the linked list
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) { // Base case: Single node is already sorted
            return head;
        }

        // Step 1: Find the middle of the linked list
        ListNode sp = getMid(head); // Find the middle node
        ListNode h2 = sp.next; // Start of the second half
        sp.next = null; // Break the linked list into two halves
        ListNode h1 = head; // Start of the first half

        // Step 2: Recursively sort both halves
        h1 = mergeSort(h1);
        h2 = mergeSort(h2);

        // Step 3: Merge the sorted halves
        return mergeSortedLL(h1, h2);
    }

    // Main function to sort the list
    public ListNode sortList(ListNode head) {
        if (head == null) return null; // Edge case: If the list is empty
        return mergeSort(head); // Sort the list using mergeSort
    }
}



148. Sort List
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
