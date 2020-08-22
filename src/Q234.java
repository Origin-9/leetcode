public class Q234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null)
                return true;
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode fast = pre, slow = pre;

            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode tmp = slow.next;

            tmp = reverseList(tmp);
            while (tmp != null){
                if(tmp.val != head.val)
                    return false;
                tmp = tmp.next;
                head = head.next;
            }

            return true;
        }

        private ListNode reverseList(ListNode head){
            ListNode pre = null;
            while (head != null){
                ListNode next = head.next;
                head.next = pre;
                pre = head;

                head = next;
            }
            return pre;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
