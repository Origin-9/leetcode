package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
                if(matrix.length == 0){
                    return new ArrayList<>();
                }
                int[] res = new int[matrix.length*matrix[0].length];
                int a = 0, b = 0, c = matrix.length-1,
                        d = matrix[0].length -1;
                List<Integer> list = new ArrayList<>();
                while(a <= c && b <= d){
                    printEdge(matrix,a++,b++,c--,d--,list);
                }
                return list;
            }

            public void printEdge(int[][] matrix, int a, int b,
                int c, int d,List<Integer> list ){
                if(a == c){
                    while (b <= d){
                        list.add(matrix[a][b++]);
                    }
                }
                else if(b == d){
                    while (a <= c){
                        list.add(matrix[a++][b]);
                    }
                }
                else {
                    int tmpa = a, tmpb = b;
                    while (tmpb < d){
                        list.add(matrix[a][tmpb++]);
                    }
                    while (tmpa < c){
                        list.add(matrix[tmpa++][d]);
                    }
                    while(tmpb > b){
                        list.add(matrix[c][tmpb--]);
                    }
                    while (tmpa > a){
                        list.add(matrix[tmpa--][b]);
                    }
                }
            }
    }

}
