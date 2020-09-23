package 度小满;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (;t > 0; t--){
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] chars = new char[n][m];
            for(int i = 0; i < n; i++){
                chars[i] = sc.next().toCharArray();
            }
            //一组输入处理完毕
            int l = 0, r = 0;
            for (int i = 0; i < n;i++){
                for (int j = 0; j < m; j++){
                    if(chars[i][j] == '@'){
                        l = i;
                        r = j;
                    }
                }
            }
            int paths = 0;
            int ret = Integer.MAX_VALUE;
            boolean[][] isMarked = new boolean[n][m];
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<Integer, Integer>(l, r));
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size--> 0){
                    Pair<Integer, Integer> pair = queue.poll();
                    int k = pair.getKey();
                    int v = pair.getValue();

                }
            }

        }
    }
//    private static int dfs(char[][] chars, int i, int j, int n, int m, int ret, boolean[][] isMarked){
//        if (i == 0 || i == n)
//            return ret;
//        if (j == 0 || j == m)
//            return ret;
//        if (isMarked[i][j])
//            return ret;
//        isMarked[i][j] = true;
//        if (chars[i][j] == '*'){
//            ret++;
//        }else if (chars[i][j] == '#'){
//            return -1;
//        }
//        int l1 = dfs(chars, i+1, j, n, m, ret, isMarked);
//        l1 = l1 == -1 ? Integer.MAX_VALUE : l1;
//        int l2 =dfs(chars, i-1, j, n, m, ret, isMarked);
//        l2 = l2 == -1 ? Integer.MAX_VALUE : l2;
//        int r1 =dfs(chars, i, j+1, n, m, ret, isMarked);
//        r1 = r1 == -1 ? Integer.MAX_VALUE : r1;
//
//        int r2 =dfs(chars, i, j-1, n, m, ret, isMarked);
//        r2 = r2 == -1 ? Integer.MAX_VALUE : r2;
//        return ret + Math.min(Math.min(Math.min(l1,l2), r1), r2);
//    }
}
