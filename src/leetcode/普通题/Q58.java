package leetcode.普通题;

public class Q58 {
    class Solution {
        public int lengthOfLastWord(String s) {

            String[] words = s.split(" ");
            if (words.length == 0)
                return 0;
            String lastWord = words[words.length-1];
            return lastWord.length();
        }
    }
}
