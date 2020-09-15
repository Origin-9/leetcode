package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    class Solution {
        public List<List<String>> partition(String s) {
            if(s.length() == 0) {
                return new ArrayList();
            }
            List<List<String>> lists = new ArrayList<>();
            List<String> list = new ArrayList<>();

            dfs(s,lists,list);
            return lists;
        }

        private void dfs(String s, List<List<String>> lists, List<String> list){
            if(s.length() == 0){
                lists.add(new ArrayList<String>(list));
                return;
            }
            for(int i = 0; i < s.length(); i++){
                if(isPalindrome(s, 0, i)){
                    list.add(s.substring(0, i+1));
                    dfs(s.substring(i+1), lists,list);
                    list.remove(list.size()-1);
                }
            }

        }

        private boolean isPalindrome(String s, int begin, int end){
            while(begin < end){
                if(s.charAt(begin)!=s.charAt(end))
                    return false;
                begin++;
                end--;
            }
            return true;
        }
    }
}
