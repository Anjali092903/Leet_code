
class Solution {
    public static int findMax(Node root) {
        // Base case: If tree is empty, return the smallest possible value
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        // Recursive call to find max in left and right subtrees
        int lmax = findMax(root.left);
        int rmax = findMax(root.right);
        
        // Return the maximum among root's value, left max, and right max
        return Math.max(root.data, Math.max(lmax, rmax));
    }

    public static int findMin(Node root) {
        // Base case: If tree is empty, return the largest possible value
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        // Recursive call to find min in left and right subtrees
        int lMin = findMin(root.left);
        int rMin = findMin(root.right);  // Fixed: Changed `findin` to `findMin`
        
        // Return the minimum among root's value, left min, and right min
        return Math.min(root.data, Math.min(lMin, rMin));
    }
}




Max and min element in Binary Tree
Difficulty: EasyAccuracy: 60.57%Submissions: 34K+Points: 2
Given a Binary Tree, find maximum and minimum elements in it.

Example:

Input: 
           
Output: 11 1
Explanation: The maximum and minimum element in this binary tree is 11 and 1 respectively.
Input: 
           6
        / \
       5   8
      /
     2
Output: 8 2
Explanation: The maximum and minimum element in this binary tree is 8 and 2 respectively.
Constraints:
1 <= number of nodes <= 105
1 <= data of a node <= 105
