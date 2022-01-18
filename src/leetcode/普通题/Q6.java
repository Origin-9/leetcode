package leetcode.普通题;

import java.util.ArrayList;

public class Q6 {

    class Solution {
        public String convert(String s, int numRows) {
            if(numRows < 2)
                return s;

            ArrayList<StringBuilder> arrayList = new ArrayList<>();

            for(int i = 0 ; i < numRows ; i++){
                arrayList.add(new StringBuilder());
            }

            int i = 0, falg = -1;

            for(char c : s.toCharArray()){
                arrayList.get(i).append(c);

                if(i == 0 || i == numRows - 1)
                    falg = -falg;

                i += falg;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(int ii = 0 ; ii < numRows ; ii++){
                stringBuilder.append(arrayList.get(ii).toString());
            }
            return stringBuilder.toString();
        }
    }
}
