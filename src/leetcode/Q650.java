package leetcode;

public class Q650 {
    class Solution {
        public int minSteps(int n) {
            int res = 0, d = 2;
            while (n > 1){
                while(n % d == 0){
                    res += d;
                    n /= d;
                }
                d++;
            }
            return res;
        }
    }
    //递归
    class Solution1 {
        public int minSteps(int n) {
            if (n == 1)
                return 0;
            for(int i = 2; i < n; i++){
                if(n % i == 0)
                    return minSteps(n/i) + i;
            }
            return n;
        }
    }
}
