package leetcode;

import java.util.*;
//序列化和反序列化是否可逆
public class 剑指Offer37 {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)
                return "";
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(root.val);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                root = queue.poll();

                if(root.left!=null){
                    TreeNode tmp = root.left;
                    queue.add(tmp);
                    sb.append(",");
                    sb.append(tmp.val);
                }
                else{
                    sb.append(",");
                    sb.append("null");
                }
                if(root.right!=null){
                    TreeNode tmp = root.right;
                    queue.add(tmp);
                    sb.append(",");
                    sb.append(tmp.val);
                }
                else{
                    sb.append(",");
                    sb.append("null");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == "")
                return null;
            System.out.println(data);
            String tmp = data.substring(1,data.length()-1);
            System.out.println(tmp);
            String[] strArr = tmp.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            int index = 0;
            TreeNode root = generateNodeByString(strArr[index++]);
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode tmpNode = queue.poll();
                tmpNode.left = generateNodeByString(strArr[index++]);
                if(tmpNode.left!=null)
                    queue.add(tmpNode.left);
                tmpNode.right = generateNodeByString(strArr[index++]);
                if(tmpNode.right!=null)
                    queue.add(tmpNode.right);
            }
            return root;
        }

        public TreeNode generateNodeByString(String s){
            if(s.equals("null"))
                return null;
            else
                return new TreeNode(Integer.valueOf(s));
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        new Codec().deserialize("[1,2,3,null,null,4,5]");
    }
}
