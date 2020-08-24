public class Q543 {
    class Solution {
        private int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return max;
        }
        private int maxDepth(TreeNode root){
            if(root == null)
                return 0;
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            max = Math.max(max, l + r);
            return Math.max(l, r)+1;
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
