import java.util.HashSet;

public class Q3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> hashSet = new HashSet<>();

            int left = 0, max = 0;
            for(int i = 0 ; i < s.length() ; i++){
                if(hashSet.contains(s.charAt(i))){
                    while(left <= i){
                        hashSet.remove(s.charAt(left));
                        left++;
                        if(!hashSet.contains(s.charAt(i))) {
                            break;
                        }
                    }
                }
                hashSet.add(s.charAt(i));
                max = Math.max(max, i - left + 1);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
