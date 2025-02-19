import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // If the tree is empty, return an empty list
        if (root == null) {
            return new ArrayList<>();
        }

        // Queue to facilitate level order traversal (BFS)
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root); // Add root node to queue

        // Result list to store level-wise nodes
        List<List<Integer>> ans = new ArrayList<>();

        // BFS traversal (while queue is not empty)
        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes at current level
            List<Integer> li = new ArrayList<>(); // Stores nodes at current level

            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode rem = q.removeFirst(); // Remove first node from queue
                li.add(rem.val); // Store its value

                // If left child exists, add to queue
                if (rem.left != null) {
                    q.addLast(rem.left);
                }

                // If right child exists, add to queue
                if (rem.right != null) {
                    q.addLast(rem.right);
                }
            }

            // Add current level list to result
            ans.add(li);
        }

        return ans; // Return the level-order traversal result
    }
}




102. Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
