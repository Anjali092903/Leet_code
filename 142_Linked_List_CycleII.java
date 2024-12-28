
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle possible if the list is empty or has only one node
        }

        ListNode fp = head; // Fast pointer
        ListNode sp = head; // Slow pointer

        // Detect if there is a cycle
        while (fp != null && fp.next != null) {
            sp = sp.next;        // Move slow pointer one step
            fp = fp.next.next;   // Move fast pointer two steps

            if (sp == fp) { // Cycle detected
                sp = head; // Reset the slow pointer to head

                // Move both pointers one step at a time until they meet
                while (sp != fp) {
                    sp = sp.next;
                    fp = fp.next;
                }

                return sp; // The meeting point is the start of the cycle
            }
        }

        return null; // No cycle found
    }
}






142. Linked List Cycle II
Solved
Medium
Topics
Companies
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
