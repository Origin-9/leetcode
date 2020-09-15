package leetcode;

import java.util.*;

public class Q637 {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null)
                return new ArrayList<>();

            List<Double> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int n = size;
                double tmp = 0;
                while (n > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null)
                        queue.add(cur.left);
                    if (cur.right != null)
                        queue.add(cur.right);
                    tmp += cur.val;
                    n--;
                }
                res.add(tmp / size);
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
