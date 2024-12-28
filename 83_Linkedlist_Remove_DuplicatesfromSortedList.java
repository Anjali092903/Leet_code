
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        // Initialize two pointers: temp1 and temp2
        // temp1 is used to track the last unique node
        // temp2 is used to traverse the list
        ListNode temp1 = head;
        ListNode temp2 = head;

        // Traverse the list using temp2
        while (temp2 != null) {
            // If the value of temp2 is the same as temp1, move temp2 forward
            if (temp1.val == temp2.val) {
                temp2 = temp2.next;
            } else {
                // If temp2 has a new value, link temp1 to temp2 and move temp1 forward
                temp1.next = temp2;
                temp1 = temp2;
            }
        }

        // After exiting the loop, terminate the unique list
        // temp2 is now null, so set temp1.next to null to ensure the list ends properly
        temp1.next = temp2;

        // Return the head of the modified list
        return head;
    }
}




83. Remove Duplicates from Sorted List
Easy
Topics
Companies
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
