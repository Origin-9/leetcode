package leetcode;

public class Q面试题0107 {
    class Solution {
        public void rotate(int[][] matrix) {
            if(matrix.length == 1)
                return;

            int a = 0,b=0,c = matrix.length -1,d = matrix.length - 1;

            while(a<c){
                rotate(matrix,a++,b++,c--,d--);
            }
        }

        private void rotate(int[][] matrix,int a,int b,int c,int d) {
            int times = d - b;
            int tmp = 0;

            for(int i = 0; i != times; i++){
                tmp = matrix[a][b+i];
                matrix[a][b+i] = matrix[c-i][b];
                matrix[c-i][b] = matrix[c][d-i];
                matrix[c][d-i] = matrix[a+i][d];
                matrix[a+i][d] = tmp;
            }
        }
    }
}
