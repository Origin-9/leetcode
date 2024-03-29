package leetcode.普通题;

public class Q669 {
    class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null)
                return root;

            if (root.val > R)
                return trimBST(root.left, L, R);
            if (root.val < L)
                return trimBST(root.right, L, R);
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
