public class 剑指Offer29 {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if(matrix.length == 0){
                return new int[]{};
            }
            int[] res = new int[matrix.length*matrix[0].length];
            int a = 0, b = 0, c = matrix.length-1,
                    d = matrix[0].length -1;
            int index = 0;
            while(a <= c && b <= d){
                index = printEdge(matrix,a++,b++,c--,d--,res,index + 0);
            }
            return res;
        }

        public int printEdge(int[][] matrix, int a, int b,
                              int c, int d,int[] tmp, int index){
            if(a == c){
                while (b <= d){
                    tmp[index++] = matrix[a][b++];
                }
            }
            else if(b == d){
                while (a <= c){
                    tmp[index++] = matrix[a++][b];
                }
            }
            else {
                int tmpa = a, tmpb = b;
                while (tmpb < d){
                    tmp[index++] = matrix[a][tmpb++];
                }
                while (tmpa < c){
                    tmp[index++] = matrix[tmpa++][d];
                }
                while(tmpb > b){
                    tmp[index++] = matrix[c][tmpb--];
                }
                while (tmpa > a){
                    tmp[index++] = matrix[tmpa--][b];
                }
            }
            return index;
        }
    }
}
