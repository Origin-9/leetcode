package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q653 {
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null)
                return false;
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int i = 0, j = list.size() - 1;
            while (i < j){
                int sum = list.get(i) + list.get(j);
                if (sum == k)
                    return true;
                else if (sum > k)
                    j--;
                else
                    i++;
            }
            return false;
        }
        private void inOrder(TreeNode root, List<Integer> list){
            if (root == null)
                return;

            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
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
