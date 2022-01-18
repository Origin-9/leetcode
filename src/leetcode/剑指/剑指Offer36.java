package leetcode.剑指;

public class 剑指Offer36 {
    class Solution {
        Node pre, head;
        public Node treeToDoublyList(Node root) {
            if(root == null)
                return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        private void dfs(Node root){
            if (root == null)
                return;
            dfs(root.left);
            if (pre == null)
                head = root;
            else if (pre != null){
                pre.right = root;
            }
            root.left = pre;
            pre = root;
            dfs(root.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
