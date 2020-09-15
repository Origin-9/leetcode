package leetcode;

import java.util.HashSet;

public class Q804 {

    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

            HashSet<String> hashSet = new HashSet<>();

            for(String word : words){
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0 ; i < word.length() ; i++){
                    stringBuilder.append(morseCodes[word.charAt(i) - 'a']);
                }
                hashSet.add(stringBuilder.toString());
            }
            return hashSet.size();
        }
    }
}
