51. N-Queens
Solved
Hard
Topics
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9









  class Solution {
    
    // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    
    List<List<String>> main = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        boolean [][] board = new boolean[n][n];
        travelBoard(board, 0);
        return main;
        
    }
    
    public boolean isValidCell(boolean [][] board, int row, int col){
        int i = row;
        int j = col;
        
        while(i >= 0 && j >= 0){
            if(board[i][j] == true){
                return false;
            }
            i--;
            j--;
        }
        
        i = row;
        j = col;
        while(i >= 0){
            if(board[i][j] == true){
                return false;
            }
            i--;
        }
        
        i = row;
        j = col;
        
        while(i >= 0 && j < board.length){
            if(board[i][j] == true){
                return false;
            }
            i--;
            j++;
        }
        
        return true;
        
    }
    
    public void travelBoard(boolean [][] board, int row){
        
        if(row == board.length){
            List<String> config = new ArrayList<>();
            
            for(int i = 0; i < board.length; i++){
                String str = "";
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == true){
                        str += 'Q';
                    }else{
                        str += '.';
                    }
                }
                config.add(str);
            }
            
            main.add(config);
            return;
            
        }
        
        for(int col = 0; col < board[0].length; col++){
            if(isValidCell(board, row, col) == true){
                board[row][col] = true;
                travelBoard(board, row + 1);
                board[row][col] = false;
            }
        }
        
        
        
        
    }
}
