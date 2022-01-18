package leetcode.普通题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q95 {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n == 0)
                return new ArrayList<>();

            return generateTrees(1, n);
        }
        public List<TreeNode> generateTrees(int s, int n) {
            List<TreeNode> res = new LinkedList<>();
            if(s > n) {
                res.add(null);
                return res;
            }
            for (int i = s; i <= n; i++){
                List<TreeNode> lRes = generateTrees(s,i-1);
                List<TreeNode> rRes = generateTrees(i+1,n);
                for(TreeNode l : lRes){
                    for(TreeNode r : rRes){
                        TreeNode head = new TreeNode(i);
                        head.left = l;
                        head.right = r;
                        res.add(head);
                    }
                }
            }
            return res;
        }
    }



    private class TreeNode {
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
