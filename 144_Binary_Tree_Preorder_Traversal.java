import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        pretraversal(root, ans);  // Call the helper function to populate the list
        return ans;  // Return the final preorder traversal result
    }

    // Helper method to perform recursive preorder traversal
    private void pretraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;  // Base case: if the node is null, return
        }
        ans.add(root.val);  // Visit the current node
        pretraversal(root.left, ans);  // Recur on the left subtree
        pretraversal(root.right, ans);  // Recur on the right subtree
    }
}



144. Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

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
