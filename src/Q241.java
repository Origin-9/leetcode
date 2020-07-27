import java.util.ArrayList;
import java.util.List;

public class Q241 {
    class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if(c == '+' || c == '-' || c=='*'){
                    List<Integer> lRes = diffWaysToCompute(input.substring(0, i));
                    List<Integer> rRes = diffWaysToCompute(input.substring(i+1, input.length()));

                    for(int l : lRes){
                        for(int r : rRes){
                            if(c == '+')
                                res.add(l + r);
                            else if(c == '-')
                                res.add(l - r);
                            else if(c == '*')
                                res.add(l * r);
                        }
                    }
                }
            }
            if (res.isEmpty())
                res.add(Integer.valueOf(input));
            return res;
        }
    }
}
