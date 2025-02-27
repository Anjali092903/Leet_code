import java.util.*;

class Solution {
    // HashMap to store parent-child relationships
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    
    // To store the infected node
    TreeNode infected = null;

    
    public void travel(TreeNode node, TreeNode parent, int start) {
        if (node == null) return; // Base condition: If node is null, return
        
        // If current node is the infected one, store it
        if (node.val == start) {
            infected = node;
        }

        // Store parent reference in HashMap
        map.put(node, parent);

        // Recursively call for left and right subtree
        travel(node.left, node, start);
        travel(node.right, node, start);
    }

    
    public int amountOfTime(TreeNode root, int start) {
        // Step 1: Traverse the tree and find the infected node
        travel(root, null, start);

        // Step 2: Perform BFS to simulate infection spread
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(infected);
        HashSet<TreeNode> infectedNodes = new HashSet<>();
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;

            while (size-- > 0) {
                TreeNode rem = q.removeFirst();
                infectedNodes.add(rem); // Mark as infected

                // Spread infection to left child
                if (rem.left != null && !infectedNodes.contains(rem.left)) {
                    q.addLast(rem.left);
                    spread = true;
                }

                // Spread infection to right child
                if (rem.right != null && !infectedNodes.contains(rem.right)) {
                    q.addLast(rem.right);
                    spread = true;
                }

                // Spread infection to parent node
                TreeNode parent = map.get(rem);
                if (parent != null && !infectedNodes.contains(parent)) {
                    q.addLast(parent);
                    spread = true;
                }
            }

            // If infection spread in this round, increment time
            if (spread) {
                time++;
            }
        }

        return time;
    }
}
