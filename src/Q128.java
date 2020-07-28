import java.util.HashMap;
import java.util.HashSet;

public class Q128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : nums) {
                hashSet.add(num);
            }
            int longest = 0;
            for (int num : nums) {
                if (hashSet.remove(num)) {
                    int currentLongest = 1;
                    int cur = num;
                    while (hashSet.remove(cur - 1))
                        cur--;
                    currentLongest += (num - cur);

                    cur = num;
                    while (hashSet.remove(cur + 1))
                        cur++;
                    currentLongest += (cur - num);
                    longest = Math.max(longest, currentLongest);
                }
            }
            return longest;
        }
    }
}
