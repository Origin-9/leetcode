public interface Q142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode first = head;
            ListNode second = head;

            while (first != null) {
                if (first.next == null || first.next.next == null) {
                    return null;
                }
                first = first.next.next;
                second = second.next;
                if (first == second)
                    break;
            }

            first = head;

            while (first != second) {
                first = first.next;
                second = second.next;
            }
            return first;
        }
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

