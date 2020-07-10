import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q面试题0406 {
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(root == null || (root.left==null&&root.right==null)){
                return null;
            }
            if(p.right != null){
                TreeNode right = p.right;
                while(right.left!=null){
                    right = right.left;
                }
                return right;
            }
            else {
                if(root == p)
                    return null;

                Stack<TreeNode> Stack = new Stack<>();
                while(root != p){
                    if(p.val<=root.val) {
                        Stack.push(root);
                        root = root.left;
                    }
                    else {
                        Stack.push(root);
                        root = root.right;
                    }
                }

                TreeNode tmp1 = Stack.pop();
                if(tmp1.left == p)
                    return tmp1;
                while (!Stack.empty()){
                    TreeNode tmp2 = Stack.pop();
                    if(tmp2.left == tmp1)
                        return tmp2;
                    tmp1 = tmp2;
                }
            }
            return null;
        }
    }

    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }
}
