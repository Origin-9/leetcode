import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q513 {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null)
                return -1;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int res = -1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                res = queue.peek().val;
                while (size > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null)
                        queue.add(cur.left);
                    if (cur.right != null)
                        queue.add(cur.right);
                    size--;
                }
            }
            return res;
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
