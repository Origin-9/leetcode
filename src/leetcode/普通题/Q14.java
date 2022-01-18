package leetcode.普通题;

public class Q14 {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0)
                return "";

            String temp = strs[0];
            for(int i = 1 ; i <= strs.length - 1 && i <= temp.length() -1; i++){
                int j = 0;

                for(; j <= strs[i].length() -1 ; j++){
                    if(strs[i].charAt(j) != temp.charAt(j))
                        break;
                }

                temp = temp.substring(0, j);

                if(temp == "")
                    return temp;
            }
            return temp;
        }
    }
}
