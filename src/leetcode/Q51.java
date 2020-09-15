package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            if(n == 0)
                return new ArrayList<>();
            char[][] res = new char[n][n];
            boolean[] colUsed = new boolean[n];
            boolean[] diagonals45Used = new boolean[2*n-1];
            boolean[] diagonals135Used = new boolean[2*n-1];
            List<List<String>> lists = new ArrayList<>();
            for (int i = 0; i < n; i++){
                Arrays.fill(res[i], '.');
            }
            dfs(n,0,colUsed,diagonals45Used,diagonals135Used,res,lists);

            return lists;
        }

        private  void dfs(int n,int depth,boolean[] colUsed,boolean[] diagonals45Used,boolean[] diagonals135Used,
                          char[][] res, List<List<String>> lists){
            if(depth == n){
                List<String> list = new ArrayList<>();
                for(char[] tmp : res){
                    list.add(new String(tmp));
                }
                lists.add(list);
                return;
            }

            for(int i = 0; i < n; i++){
                int diagonals45Inx = depth + i;
                int diagonals135Inx = n-1-(i-depth);
                if (colUsed[i] || diagonals45Used[diagonals45Inx] || diagonals135Used[diagonals135Inx])
                    continue;
                colUsed[i]= diagonals45Used[diagonals45Inx] = diagonals135Used[diagonals135Inx] = true;
                res[depth][i] = 'Q';
                dfs(n,depth+1,colUsed,diagonals45Used,diagonals135Used,res,lists);
                res[depth][i] = '.';
                colUsed[i]= diagonals45Used[diagonals45Inx] = diagonals135Used[diagonals135Inx] = false;
            }
        }

    }
}
