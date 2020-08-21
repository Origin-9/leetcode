public class Q24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode pre = dummyNode;
            while (pre.next != null && pre.next.next != null){
                ListNode l1 = pre.next, l2 = pre.next.next;

                l1.next = l2.next;
                l2.next = l1;
                pre.next = l2;

                pre = l1;
            }
            return dummyNode.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
