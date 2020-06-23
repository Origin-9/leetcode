import java.util.HashMap;
import java.util.HashSet;

public class Q13 {
    class Solution {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        public int romanToInt(String s) {
            HashMap<String , Integer> hashMap = new HashMap<>();

            int index = 0;
            for(String temp : symbols){
                hashMap.put(temp, index ++);
            }

            int res = 0;
            while(s.length() > 0){
                if(s.length() >= 2 && hashMap.containsKey(s.substring(s.length()-2 ,s.length()))){
                    res += values[hashMap.get(s.substring(s.length()-2 ,s.length()))];
                    s = s.substring(0,s.length() - 2);
                }
                else{
                    res += values[hashMap.get(s.substring(s.length()-1 ,s.length()))];
                    s = s.substring(0,s.length() - 1);
                }
            }
            return res;
        }
    }
}
