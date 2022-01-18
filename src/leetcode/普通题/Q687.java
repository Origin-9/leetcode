package leetcode.普通题;

public class Q687 {
    class Solution {
        private int ret =0;
        public int longestUnivaluePath(TreeNode root) {
            maxLengthUnivalueStartWithRoot(root);
            return ret;
        }

        private int maxLengthUnivalueStartWithRoot(TreeNode root){
            if (root == null)
                return 0;
            int left = maxLengthUnivalueStartWithRoot(root.left);
            int right = maxLengthUnivalueStartWithRoot(root.right);
            int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
            int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;

            ret = Math.max(ret, leftPath + rightPath);

            return Math.max(leftPath, rightPath);
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
