import java.util.Arrays;

public class Q179 {
    class Solution {
        public String largestNumber(int[] nums) {
            String[] arr = new String[nums.length];

            for (int i = 0; i < nums.length; i++) {
                arr[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

            if (arr[0].equals("0"))
                return "0";

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                stringBuilder.append(arr[i]);
            }
            return stringBuilder.toString();
        }
    }
}
