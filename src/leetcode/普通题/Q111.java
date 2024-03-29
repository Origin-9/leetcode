package leetcode.普通题;

public class Q111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int l = minDepth(root.left);
            int r = minDepth(root.right);
            if (l == 0 || r == 0)
                return l + r + 1;
            return Math.min(l, r)+1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
