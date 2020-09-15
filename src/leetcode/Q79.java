package leetcode;

public class Q79 {
    static class Solution {
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        public boolean exist(char[][] board, String word) {
            if(board == null || board.length == 0 ||  board[0].length == 0) {
                return false;
            }
            if( word == null || word.length() == 0)
                return true;
            int m = board.length;
            int n = board[0].length;
            boolean[][] isVisited = new boolean[m][n];
            for (int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(dfs(board,word, 0, i, j,m,n,isVisited)){
                        return true;
                    }
                }
            }
            return false;
        }
        private boolean dfs(char[][] board,String s, int index, int i, int j, int m, int n,boolean[][] isVisited){
            if(s.length() == index)
                return true;
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != s.charAt(index) || isVisited[i][j])
                return false;
            isVisited[i][j] = true;
            for(int[] tmp : dir){
                if(dfs(board,s, index+1, i+tmp[0], j+tmp[1],m,n,isVisited)) {
                    return true;
                }
            }
            isVisited[i][j] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        new Solution().exist(new char[][]{{'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}}, "ABCCED");
    }
}
