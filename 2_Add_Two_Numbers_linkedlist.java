
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Temporary pointers to traverse l1 and l2
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        // Dummy node to help build the resulting linked list
        ListNode head3 = new ListNode(-1);
        ListNode temp3 = head3;

        // Variable to store carry
        int carry = 0;

        // Loop until both lists are exhausted
        while (temp1 != null || temp2 != null) {
            int val1 = 0; // Value from the first list
            if (temp1 != null) {
                val1 = temp1.val;
                temp1 = temp1.next;
            }

            int val2 = 0; // Value from the second list (fix: declare val2)
            if (temp2 != null) {
                val2 = temp2.val;
                temp2 = temp2.next;
            }

            // Sum the digits and the carry
            int sum = val1 + val2 + carry;

            // Calculate the digit to store in the current node and the carry
            int base = sum % 10; // Extract the last digit
            carry = sum / 10;    // Extract the carry

            // Create a new node for the result and attach it to the list
            ListNode nn = new ListNode(base);
            temp3.next = nn;

            // Move to the next node in the result list
            temp3 = nn;
        }

        // If there's a carry left, add a new node for it
        if (carry != 0) {
            ListNode nn = new ListNode(carry);
            temp3.next = nn;
        }

        // The result starts from the next node after the dummy
        return head3.next;
    }
}






2. Add Two Numbers
Medium
Topics
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
