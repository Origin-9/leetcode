package leetcode;

public class Q37 {
    class Solution {
        public void solveSudoku(char[][] board) {
            boolean[][] rowUsed = new boolean[9][10];
            boolean[][] colUsed = new boolean[9][10];
            boolean[][][] boxUsed = new boolean[3][3][10];
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    int num = board[i][j] - '0';
                    if(num >= 1 && num <= 9){
                        rowUsed[i][num] = true;
                        colUsed[j][num] = true;
                        boxUsed[i/3][j/3][num] = true;
                    }
                }
            }

            dfs(board,0,0,rowUsed,colUsed,boxUsed);
        }

        private boolean dfs(char[][] board,int i,int j,boolean[][] rowUsed,boolean[][] colUsed,boolean[][][] boxUsed){
            if(j==board[0].length){
                j=0;
                i++;
                if(i==board.length)
                    return true;
            }
            if(board[i][j] == '.'){
                for(int k = 1; k <= 9;k++){
                    boolean canUsed = !(rowUsed[i][k] || colUsed[j][k] || boxUsed[i/3][j/3][k]);
                    if(canUsed){
                        rowUsed[i][k] = true;
                        colUsed[j][k] = true;
                        boxUsed[i/3][j/3][k] = true;

                        board[i][j] = (char)('0' + k);
                        if(dfs(board,i,j+1,rowUsed,colUsed,boxUsed))
                            return true;

                        board[i][j] = '.';
                        rowUsed[i][k] = false;
                        colUsed[j][k] = false;
                        boxUsed[i/3][j/3][k] = false;
                    }
                }
            }
            else
                return dfs(board,i,j+1,rowUsed,colUsed,boxUsed);
            return false;
        }

    }
}
