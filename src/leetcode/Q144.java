package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144 {
    class Solution {
        //二叉树先序的非递归方式
        //|-- 借助栈,先压右，再压左
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()){
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                if(tmp.right!=null)
                    stack.push(tmp.right);
                if(tmp.left!=null)
                    stack.push(tmp.left);
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
