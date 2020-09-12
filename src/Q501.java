import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q501 {
    class Solution {
        private int preVal = 0;
        private int curTimes = 0;
        private int maxTimes = 0;
        List<Integer> list = new ArrayList<>();
        public int[] findMode(TreeNode root) {
            inOrder(root);
            int n = list.size();
            int[] ret = new int[n];

            for (int i = 0; i < n; i++){
                ret[i] = list.get(i);
            }
            return ret;
        }

        private void inOrder(TreeNode root){
            if (root == null)
                return;
            inOrder(root.left);

            if (preVal == root.val){
                curTimes++;
            }else {
                preVal = root.val;
                curTimes = 1;
            }
            if (curTimes == maxTimes){
                list.add(root.val);
            }else if (curTimes > maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }

            inOrder(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
