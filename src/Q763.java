import java.util.ArrayList;
import java.util.List;

public class Q763 {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            if(S == null || S.length() == 0)
                return new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < S.length();){
                char c = S.charAt(i);
                int end = S.lastIndexOf(c);
                end = subStringEnd(S, S.substring(i, end+1), end);
                list.add(end - i + 1);
                i = end+1;
            }
            return list;
        }
        //tmp 一元素从出现到S中的最后位置
        private int subStringEnd(String S, String tmp, int end){
            if(tmp.length() == 1)
                return end;
            for(int j = 0; j <  tmp.length();){
                char tmpChar = tmp.charAt(j);
                int tmpEnd = S.lastIndexOf(tmpChar);
                if(tmpEnd > end) {
                    return subStringEnd(S, S.substring(0, tmpEnd+1), tmpEnd);
                }
                else
                    j++;
            }
            return end;
        }
    }
}
