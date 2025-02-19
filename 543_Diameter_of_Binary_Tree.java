class Solution {
    int maxDia = Integer.MIN_VALUE; // Stores the maximum diameter found so far.

    // Recursive function to compute the height of the tree
    public int height(TreeNode root) {
        // Base case: if the node is null, return -1 (height of an empty tree)
        if (root == null) {
            return -1; 
        }

        // Recursively compute the height of the left and right subtrees
        int lh = height(root.left);  
        int rh = height(root.right);

        // Update the maximum diameter encountered so far
        // Diameter at any node = left subtree height + right subtree height + 2 (for edges)
        maxDia = Math.max(maxDia, lh + rh + 2);

        // Return the height of the current subtree (1 + max of left or right height)
        return Math.max(lh, rh) + 1;
    }

    // Function to calculate the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        int h = height(root); // This call updates the maxDia variable
        return maxDia;  // Return the maximum diameter found
    }
}



543. Diameter of Binary Tree
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
