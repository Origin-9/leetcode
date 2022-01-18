package leetcode.普通题;

public class Q92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head.next == null || m== n){
                return head;
            }
            ListNode left = head;
            ListNode preLeft = null;

            for(int i = 1 ; i < m ; i++){
                if(i == m-1)
                    preLeft = left;
                left = left.next;
            }
            ListNode right = left;
            ListNode preRight = null;
            for(; m < n ; m++){
                right = right.next;
                if(m == n-1)
                    preRight = right.next;
            }
            ListNode res = reverseBetween(left,right);
            ListNode resEnd = null;
            ListNode cur = res;
            while(cur.next!=null)
                cur = cur.next;
            cur.next = preRight;
            if(preLeft == null)
                return res;
            else{
                preLeft.next = res;
                return head;
            }

        }

        private ListNode reverseBetween(ListNode left, ListNode right){
            right.next = null;
            ListNode pre = null;
            ListNode next = null;
            ListNode cur = left;

            while(cur != null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
