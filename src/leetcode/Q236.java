package leetcode;

public class Q236 {
    //超时
    class Solution1 {
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            boolean left1 = hasTargetNode(root.left, p);
            boolean left2 = hasTargetNode(root.left, q);
            boolean right1 = hasTargetNode(root.right, p);
            boolean right2 = hasTargetNode(root.right, q);
            if (root.val == p.val && (left2 || right2)
                    || root.val == q.val && ( left1 || right1))
                return root;
            if(left1 && right2 || left2 && right1)
                return root;
            TreeNode tmp1 = lowestCommonAncestor1(root.left, p, q);
            TreeNode tmp2 =lowestCommonAncestor1(root.right, p, q);
            return tmp1 == null ? tmp2 : tmp1;
        }

        private boolean hasTargetNode(TreeNode root, TreeNode targetNode){
            if (root == null)
                return false;

            if (root.val != targetNode.val){
                boolean left = hasTargetNode(root.left, targetNode);
                boolean right = hasTargetNode(root.right, targetNode);
                return left || right;
            }else{
                return true;
            }
        }
    }
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null && right == null)
                return null;
            else if (left == null)
                return right;
            else if (right == null)
                return left;
            else
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
