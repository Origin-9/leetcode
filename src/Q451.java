import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q451 {
    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> hashMap = new HashMap<>();

            for(char c : s.toCharArray()){
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            }

            List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
            for(char c : hashMap.keySet()){
                if (frequencyBucket[hashMap.get(c)] == null)
                    frequencyBucket[hashMap.get(c)] = new ArrayList<>();
                frequencyBucket[hashMap.get(c)].add(c);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = frequencyBucket.length-1; i >= 0; i--){
                if(frequencyBucket[i] == null)
                    continue;
                for(int j = 0; j < frequencyBucket[i].size(); j++){
                    for(int k = 0;k < i; k++){
                        sb.append(frequencyBucket[i].get(j));
                    }
                }
            }
            return sb.toString();
        }
    }
}
