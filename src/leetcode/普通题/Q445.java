package leetcode.普通题;

public class Q445 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverseList(l1);
            l2 = reverseList(l2);
            int tmp = 0;
            ListNode dummyNode = new ListNode(0);
            ListNode cur = dummyNode;
            while(l1 != null || l2 != null){
                int sum = 0;
                if(l1 != null && l2 != null)
                    sum = l1.val + l2.val + tmp;
                else if(l1 == null)
                    sum = l2.val + tmp;
                else if (l2 == null)
                    sum = l1.val+ tmp;
                ListNode tmpNode = null;
                if(sum< 10){
                    tmpNode = new ListNode(sum);
                    tmp = 0;
                }else{
                    tmpNode = new ListNode(sum%10);
                    tmp = 1;
                }
                cur.next = tmpNode;
                cur = cur.next;
                if(l1 != null)
                    l1 = l1.next;
                if(l2 != null)
                    l2 = l2.next;
            }
            if(tmp == 1)
                cur.next = new ListNode(1);
            return reverseList(dummyNode.next);
        }

        private ListNode reverseList(ListNode l){
            ListNode pre = null;
            while (l != null){
                ListNode next = l.next;
                l.next = pre;
                pre = l;
                l = next;
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
