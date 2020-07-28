import java.util.Stack;

public class Q739 {
    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[T.length];
            for(int curIndex = 0; curIndex < T.length; curIndex++){
                while (!stack.empty() && T[curIndex] > T[stack.peek()]){
                    int preIndex = stack.pop();
                    res[preIndex] = curIndex - preIndex;
                }
                stack.push(curIndex);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        new Solution().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
