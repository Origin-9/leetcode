package leetcode;

public class Q413 {
    //暴力
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            if(A.length < 3)
                return 0;
            int res = 0;
            for(int i = 0; i < A.length - 2; i++){
                int d = A[i+1] - A[i];

                for(int j = i+2; j < A.length; j++){
                    int k = 0;
                    for(k = i+2; k <= j; k++){
                        if(A[k] - A[k-1] != d)
                            break;
                    }
                    if(k > j)
                        res++;
                }
            }
            return res;
        }
    }
    // 递归实现，来求在区间 (k,i) 中等差数列的个数
    static class Solution1 {
        int sum = 0;
        public int numberOfArithmeticSlices(int[] A) {
            slices(A, A.length - 1);
            return sum;
        }
        public int slices(int[] A, int i) {
            if (i < 2)
                return 0;
            int ap = 0;
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                ap = 1 + slices(A, i - 1);
                sum += ap;
            } else
                slices(A, i - 1);
            return ap;
        }
    }
    // 动态规划
    class Solution2 {

        public int numberOfArithmeticSlices(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            int n = A.length;
            int[] dp = new int[n];
            for (int i = 2; i < n; i++) {
                if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            int total = 0;
            for (int cnt : dp) {
                total += cnt;
            }
            return total;
        }
    }

    public static void main(String[] args) {
        new Solution1().numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
    }
}
