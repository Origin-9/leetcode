package leetcode.普通题;

import java.io.InputStreamReader;
import java.io.OutputStream;

public class Q235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > q.val){
                TreeNode tmp = p;
                p = q;
                q = tmp;
            }
            if (q.val < root.val)
                return lowestCommonAncestor(root.left, p ,q);
            if(p.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
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
