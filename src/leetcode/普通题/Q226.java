package leetcode.普通题;

public class Q226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return null;
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = r;
            root.right = l;
            invertTree(root.left);
            invertTree(root.right);
            return root;
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
