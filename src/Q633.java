public class Q633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
            int l = 0;
            int r = (int) Math.sqrt(c);

            while (l <= r){
                int tmp = l*l + r*r;
                if(tmp > c)
                    r--;
                else if(tmp < c)
                    l++;
                else
                    return true;
            }
            return false;
        }
    }
}
