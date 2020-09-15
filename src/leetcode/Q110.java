package leetcode;

public class Q110 {
    class Solution {
        private boolean res = true;
        public boolean isBalanced(TreeNode root) {
            maxHeight(root);
            return res;
        }

        private int maxHeight(TreeNode root){
            if (root == null)
                return 0;
            int l = maxHeight(root.left);
            int r = maxHeight(root.right);
            if(Math.abs(l -r) > 1)
                res = false;
            return Math.max(l, r) + 1;
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
