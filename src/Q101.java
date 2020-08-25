public class Q101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            TreeNode reverseTree = reverseTree(root);
            return isEquals(root, reverseTree);
        }
        private boolean isEquals(TreeNode treeNode1, TreeNode treeNode2){
            if (treeNode1 == null && treeNode2 == null)
                return true;
            if(treeNode1 == null || treeNode2 == null)
                return false;

            if (treeNode1.val != treeNode2.val)
                return false;
            else
                return isEquals(treeNode1.left, treeNode2.left) && isEquals(treeNode1.right, treeNode2.right);
        }

        private TreeNode reverseTree(TreeNode root){
            if (root == null)
                return null;
            TreeNode treeNode = new TreeNode(root.val);
            treeNode.left = reverseTree(root.right);
            treeNode.right = reverseTree(root.left);

            return treeNode;
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
