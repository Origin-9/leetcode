package leetcode.普通题;

public class Q69 {
    static class Solution {
        public int mySqrt(int x) {
            if(x <= 1)
                return x;

            int l = 0, r = x;
            while(l <= r){
                int m = l + (r-l)/2;
                int sqrt = x/m;
                if (sqrt == m)
                    return m;
                else if(sqrt > m)
                    l = m+1;
                else if (sqrt < m)
                    r = m-1;
            }
            return r;
        }
    }

    public static void main(String[] args) {
        new Solution().mySqrt(8);
    }
}
