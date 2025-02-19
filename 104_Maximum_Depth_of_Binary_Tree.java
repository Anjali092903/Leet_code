/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Main function to calculate the maximum depth of a binary tree
    public int maxDepth(TreeNode root) {
        // Calls the recursive helper function to calculate height
        int height = Calculateheight(root);
        return height;
    }

    // Recursive function to calculate the height of the tree
    public int Calculateheight(TreeNode root) {
        // Base Case: If the node is null, return 0 (empty subtree has height 0)
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int lh = Calculateheight(root.left);

        // Recursively calculate the height of the right subtree
        int rh = Calculateheight(root.right);

        // The height of the current node is the maximum of the left and right subtree heights plus 1
        int height = Math.max(lh, rh) + 1;

        // Return the calculated height
        return height;
    }
}



104. Maximum Depth of Binary Tree
Solved
Easy
Topics
Companies
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
