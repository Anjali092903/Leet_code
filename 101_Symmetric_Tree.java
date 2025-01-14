class Solution {
    public boolean isSymmetric(TreeNode root) {
        // If the tree is empty, it is symmetric
        if (root == null) {
            return true;
        }
        
        // Use a helper function to check if two trees are mirrors of each other
        return isMirror(root.left, root.right);
    }
    
    // Helper function to check if two trees are mirror images of each other
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they are symmetric
        if (t1 == null && t2 == null) {
            return true;
        }
        
        // If one of the nodes is null and the other is not, they are not symmetric
        if (t1 == null || t2 == null) {
            return false;
        }
        
        // Check if the current nodes have the same value and recursively check the children
        return (t1.val == t2.val) && 
               isMirror(t1.left, t2.right) && 
               isMirror(t1.right, t2.left);
    }
}





101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 
