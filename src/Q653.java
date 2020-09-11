public class Q653 {
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            return findTarget(root, k, 0);
        }
        private boolean findTarget(TreeNode root, int k, int n){
            if (root == null || k < 0)
                return false;
            if (k == 0 && n == 2)
                return true;
            if (root.val > k)
                return findTarget(root.left, k, n);
            else {
                return findTarget(root.right, k - root.val, n++)
                        || findTarget(root.left, k - root.val, n++)
                        || findTarget(root.left, k, n)
                        || findTarget(root.right, k, n);
            }
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
