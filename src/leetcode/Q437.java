package leetcode;

public class Q437 {
    class Solution {
        private int sum = 0;
        public int pathSum(TreeNode root, int sum) {
            if(root == null)
                return 0;
            return pathSum(root.left, sum) +
                    pathSum(root.right, sum) +
                    pathSumStartedWithRoot(root, sum);
        }

        private int pathSumStartedWithRoot(TreeNode root, int sum){
            if (root == null)
                return 0;
            int ret = 0;
            if (root.val == sum)
                ret++;
            ret += pathSumStartedWithRoot(root.right, sum - root.val)+
                    pathSumStartedWithRoot(root.left, sum - root.val);
            return ret;
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
