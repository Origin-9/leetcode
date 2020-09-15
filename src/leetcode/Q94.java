package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94 {
    class Solution {
        //	当前节点为空，从栈中取一打印，当前向右
        //	当前节点不为空，当前节点压入栈，当前节点向左
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null)
                return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.empty() || root!=null){
                if(root!=null){
                    stack.push(root);
                    root = root.left;
                }
                else {
                    TreeNode tmp = stack.pop();
                    res.add(tmp.val);
                    root = tmp.right;
                }
            }
            return res;
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
