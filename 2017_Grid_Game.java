2017. Grid Game
You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.

Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).

At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.

The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.

 

Example 1:


Input: grid = [[2,5,4],[1,5,1]]
Output: 4
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 0 + 4 + 0 = 4 points.
Example 2:


Input: grid = [[3,3,1],[8,5,2]]
Output: 4
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 3 + 1 + 0 = 4 points.
Example 3:


Input: grid = [[1,3,1,15],[1,3,3,1]]
Output: 7
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 1 + 3 + 3 + 0 = 7 points.
 

Constraints:

grid.length == 2
n == grid[r].length
1 <= n <= 5 * 104
1 <= grid[r][c] <= 105






  class Solution {
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;  // Initialize answer with maximum possible value
        int n = grid[0].length;     // Get the number of columns (since grid has 2 rows)
        
        // Prefix sum array to store cumulative sums for both rows
        long [][] pSum = new long[2][n];

        // Compute prefix sums for each row
        for(int row = 0; row < grid.length; row++){
            pSum[row][0] = grid[row][0]; // First column prefix sum is the same as grid value
            for(int col = 1; col < grid[0].length; col++ ){
                // Prefix sum is current cell value + previous prefix sum
                pSum[row][col] = grid[row][col] + pSum[row][col - 1];
            }
        }

        // Try every possible column to switch from top row to bottom row
        for(int col = 0; col < n; col++){
            // z1: points remaining in top row after column `col`
            long z1 = pSum[0][n - 1] - pSum[0][col];

            // z2: points collected in bottom row before column `col`
            long z2 = col > 0 ? pSum[1][col - 1] : 0;

            // Second robot will get max of z1 and z2 in worst case
            ans = Math.min(ans, Math.max(z1, z2));
        }

        return ans;  // Minimum value of maximum points second robot can collect
    }   
}
