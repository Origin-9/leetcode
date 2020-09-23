package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Q257 {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            if(root == null)
                return new ArrayList<>();

            List<String> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            HashSet<TreeNode> hashSet = new HashSet<>();
            stack.add(root);
            hashSet.add(root);
            StringBuilder sb = new StringBuilder();

            path.add(root.val);
            while(!stack.empty()){
                TreeNode tmp = stack.pop();
                if(tmp.left != null && !hashSet.contains(tmp.left)){
                    stack.push(tmp);
                    stack.push(tmp.left);
                    hashSet.add(tmp.left);
                    path.add(tmp.left.val);
                    continue;
                }
                if(tmp.right != null && !hashSet.contains(tmp.right)){
                    stack.push(tmp);
                    stack.push(tmp.right);
                    hashSet.add(tmp.right);
                    path.add(tmp.right.val);
                    continue;
                }
                //走到叶子节点
                if(tmp.left == null && tmp.right == null){
                    for (int i = 0; i < path.size(); i++) {
                        sb.append(path.get(i));
                        if (i != path.size() - 1) {
                            sb.append("->");
                        }
                    }
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
                path.remove(path.size()-1);
            }
            return res;
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
