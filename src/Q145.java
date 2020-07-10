import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            ArrayList<Integer> res = new ArrayList<>();
            while(!stack1.empty()){
                TreeNode tmp = stack1.pop();
                stack2.push(tmp);
                if(tmp.left!=null)
                    stack1.push(tmp.left);
                if(tmp.right!=null)
                    stack1.push(tmp.right);
            }
            while (!stack2.empty()){
                res.add(stack2.pop().val);
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
