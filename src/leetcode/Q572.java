package leetcode;

public class Q572 {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null)
                return false;
            return isSubtreeStartWithRoot(s,t) || isSubtree(s.left, t) ||
                     isSubtree(s.right, t);
        }
        private boolean isSubtreeStartWithRoot(TreeNode s, TreeNode t){
            if (s == null && t == null)
                return true;
            if(s == null || t == null)
                return false;
            if (s.val != t.val)
                return false;
            else {
                return isSubtreeStartWithRoot(s.right, t.right) && isSubtreeStartWithRoot(s.left, t.left);
            }
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
