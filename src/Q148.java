public class Q148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode fast = head.next, slow = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode temp = slow.next;
            slow.next = null;

            ListNode leftSorted = sortList(head);
            ListNode rightSorted = sortList(temp);

            ListNode h = new ListNode(0);
            ListNode res = h;

            while(leftSorted !=null && rightSorted!= null){
                if(leftSorted.val < rightSorted.val){
                    h.next = leftSorted;
                    leftSorted = leftSorted.next;
                }
                else {
                    h.next = rightSorted;
                    rightSorted = rightSorted.next;
                }
                h = h.next;
            }
            h.next = leftSorted != null ? leftSorted :rightSorted;
            return res.next;

        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
