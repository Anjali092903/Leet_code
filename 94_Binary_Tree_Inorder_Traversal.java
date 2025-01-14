
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();  // List to store the result
        inorderHelper(root, result);  // Helper function to perform the traversal
        return result;  // Return the result list
    }
    
    // Helper function for recursive inorder traversal
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;  // Base case: if the node is null, return
        }
        
        // Traverse the left subtree
        inorderHelper(node.left, result);
        
        // Visit the current node
        result.add(node.val);
        
        // Traverse the right subtree
        inorderHelper(node.right, result);
    }
}





94. Binary Tree Inorder Traversal
Solved
Easy
Topics
Companies
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
