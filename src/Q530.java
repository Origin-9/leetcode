import java.util.ArrayList;
import java.util.List;

public class Q530 {
    class Solution {
        public int getMinimumDifference(TreeNode root) {
            if (root == null)
                return 0;
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            if (list.size() == 1)
                return 0;
            int i = 0, j = 1;
            int ret = Integer.MAX_VALUE;
            while (j < list.size()){
                int tmp = Math.abs(list.get(j) - list.get(i));
                ret = ret > tmp ? tmp : ret;
                i++;
                j++;
            }
            return ret;
        }

        private void inOrder(TreeNode root, List<Integer> list){
            if (root == null)
                return;

            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
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
