import java.util.HashMap;

public class Q594 {
    class Solution {
        public int findLHS(int[] nums) {
            if(nums == null)
                return 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int num : nums)
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            int longest = 0;
            for(int num : hashMap.keySet()){
                if(hashMap.containsKey(num+1))
                    longest = Math.max(longest, hashMap.get(num) + hashMap.get(num+1));
            }
            return longest;
        }
    }
}
