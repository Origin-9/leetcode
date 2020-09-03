public class Q230 {
    class Solution {
        private int cnt = 0;
        private int res = -1;
        public int kthSmallest(TreeNode root, int k) {
            inOrder(root, k);
            return res;
        }

        private void inOrder(TreeNode root, int k){
            if (root == null)
                return;

            inOrder(root.left, k);
            cnt++;
            if (cnt == k){
                res = root.val;
                return;
            }
            inOrder(root.right, k);
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
