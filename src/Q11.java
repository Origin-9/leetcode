public class Q11 {
    static class Solution {
        public int maxArea(int[] height) {
            //res 返回值，s面积
            int s = 0;

            s = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
            for(int i = 0, j = height.length - 1 ; i <= j ;) {
                if(height[i] < height[j])
                    i++;
                else
                    j--;
                if(i <= j)
                    s = Math.max(s, Math.min(height[i], height[j]) * (j - i));


            }
            return s;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(new Solution().maxArea(arr));
    }
}
