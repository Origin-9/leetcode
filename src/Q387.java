import java.util.HashMap;
import java.util.HashSet;

public class Q387 {
    class Solution {

        public int firstUniqChar(String s) {
            HashMap<Character, Integer> hashMap = new HashMap<>();

            for(int i = 0 ; i < s.length() ; i++){
                if(hashMap.containsKey(s.charAt(i)))
                    hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
                else
                    hashMap.put(s.charAt(i), 1);
            }
            for (int i = 0 ; i < s.length() ; i++){
                if(hashMap.containsKey(s.charAt(i)) && hashMap.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
    }
}
