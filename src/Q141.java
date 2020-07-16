public class Q141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode first = head;
            ListNode second = head;

            while(first != null){
                if(first.next == null || first.next.next == null){
                    return false;
                }
                first = first.next.next;
                second = second.next;
                if(first == second)
                    return true;
            }
            return false;

//            first = head;
//
//            while(first != second){
//                first = first.next;
//                second = second.next;
//            }
//            return true;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
