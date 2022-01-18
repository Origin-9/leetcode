package leetcode.普通题;

public class Q404 {
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null)
                return 0;
            int ret = 0;

            if(root.left != null && root.left.left == null && root.left.right == null)
                ret += root.left.val;
            return ret + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
