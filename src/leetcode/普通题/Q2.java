package leetcode.普通题;

public class Q2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode curr = new ListNode(0);
            ListNode l3 = curr;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;

                int sum = x + y + carry;
                l3.next = new ListNode(sum % 10);
                carry = sum / 10;

                l3 = l3.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;

            }
            if (carry > 0)
                l3.next = new ListNode(carry);

            return curr.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
