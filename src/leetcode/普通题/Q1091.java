package leetcode.普通题;

import java.util.LinkedList;
import java.util.Queue;

public class Q1091 {
    static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if(grid == null || grid.length == 0 || grid[0].length == 0)
                return -1;
            if(grid[0][0] == 1)
                return -1;
            int M = grid.length;
            int N = grid[0].length;
            int[][] dir = {{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1}};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            grid[0][0] = 1;
            int path = 1;

            while(!queue.isEmpty()){
                int size = queue.size();
                while (size-- != 0){
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    if(x == M - 1 && y == N - 1){
                        return path;
                    }

                    for (int[] d : dir){
                        int x1 = x + d[0];
                        int y1 = y + d[1];

                        if(x1 < 0 || x1 >= M || y1 < 0 || y1 >= N || grid[x1][y1] == 1)
                            continue;
                        queue.add(new int[]{x1, y1});
                        grid[x1][y1] = 1;
                    }
                }
                path++;

            }
            return -1;
        }
    }

    public static void main(String[] args) {
        new Solution().shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}});
    }

}
