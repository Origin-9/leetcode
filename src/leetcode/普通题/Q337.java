package leetcode.普通题;

public class Q337 {
    class Solution {
        public int rob(TreeNode root) {
            if (root == null)
                return 0;
            int val1 = root.val;
            if(root.left!=null)
                val1 += rob(root.left.left) + rob(root.left.right);
            if(root.right!=null)
                val1 += rob(root.right.left) + rob(root.right.right);
            int val2 = rob(root.left) +
                    rob(root.right);
            return Math.max(val1, val2);
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
