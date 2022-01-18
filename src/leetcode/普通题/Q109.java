package leetcode.普通题;

public class Q109 {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null)
                return null;
            if(head.next == null)
                return new TreeNode(head.val);

            ListNode midPreNode = getMidPreNode(head);
            ListNode midNode = midPreNode.next;

            TreeNode root = new TreeNode(midNode.val);

            ListNode tmp = midNode.next;
            //截断
            midPreNode.next = null;

            root.left = sortedListToBST(head);
            root.right = sortedListToBST(tmp);

            return root;
        }
        private ListNode getMidPreNode(ListNode head){
            ListNode slow = head, first = head.next, ret = head;
            while (first != null && first.next != null){
                ret = slow;
                slow = slow.next;
                first = first.next.next;
            }
            return ret;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
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
