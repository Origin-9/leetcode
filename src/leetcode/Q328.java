package leetcode;

public class Q328 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            //奇结点
            ListNode listNode1 = head;
            //偶数节点头
            ListNode listNode2 = head.next;
            //偶数节点尾
            ListNode listNode3 = head.next;
            while (listNode1.next != null && listNode3.next != null) {
                listNode1.next = listNode3.next;
                listNode1 = listNode1.next;

                listNode3.next = listNode1.next;
                listNode3 = listNode3.next;
            }
            listNode1.next = listNode2;
            return head;
        }
    }

    class ListNode {
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
}
