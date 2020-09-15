package leetcode;

public class Q605 {
    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if(flowerbed == null || flowerbed.length == 0)
                return false;

            for(int i = 0; i < flowerbed.length;) {
                if (flowerbed[i] == 1) {
                    i += 2;
                    continue;
                }
                int pre = i == 0 ? 0 : flowerbed[i-1];
                int next = i == flowerbed.length-1 ? 0 : flowerbed[i+1];
                if(pre == 0 && next == 0) {
                    n--;
                    i += 2;
                }
                else
                    i++;
            }
            return n <= 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{1,0,0,0,1},1));
    }
}
