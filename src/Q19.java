public class Q19 {
    class Solution {
        //多次遍历
        public ListNode removeNthFromEnd1(ListNode head, int n) {
            if(head.next == null || head == null)
                return null;

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode cur = head;
            int length = 0;
            while(cur!=null){
                cur = cur.next;
                length++;
            }
            cur = head;
            for(int i = 1; i < length - n + 1; i++){
                cur = cur.next;
            }
            ListNode targetNode = cur;
            ListNode tmp = dummyNode;
            cur = head;
            while(tmp.next!=targetNode){
                tmp = cur;
                cur = cur.next;
            }
            tmp.next = null;
            tmp.next = cur.next;
            return dummyNode.next;
        }

        //o(n)
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode first = dummyNode, sec = dummyNode;
            int tmp = -1;
            while(first!=null){
                if(tmp == n){
                    first = first.next;
                    sec = sec.next;
                    continue;
                }
                first = first.next;
                tmp++;
            }
            sec.next = sec.next.next;
            return dummyNode.next;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
