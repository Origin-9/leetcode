package leetcode.普通题;

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
            ListNode fast = dummyNode, slow = dummyNode;

            for (int i = 1; i <= n+1; i++){
                fast = fast.next;
            }
            //删第一个节点
            if(fast == null)
                return head.next;
            while (fast!= null){
                slow = slow.next;
                fast = fast.next;
            }
            if(slow.next != null)
                slow.next = slow.next.next;
            return head;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
