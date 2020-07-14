import java.util.List;

public class 面试题0806 {
    //O(2^n−1)
    class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            if(A == null)
                return;
            hanota(A.size(), A, B, C);
        }
        public void hanota(int n,List<Integer> A, List<Integer> B, List<Integer> C){
            if(n == 1) {
                C.add(A.remove(A.size() - 1));
                return;
            }
            else{
                hanota(n-1, A, C, B);
                C.add(A.remove(A.size() - 1));
                hanota(n-1, B, A, C);
            }
        }
    }
}
