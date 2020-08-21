import java.util.HashSet;

public class Q83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null)
                return null;
            HashSet<Integer> hashSet = new HashSet<>();

            ListNode dummyHead  = head;
            hashSet.add(head.val);
            while (dummyHead != null){
                if(dummyHead.next != null &&
                    hashSet.contains(dummyHead.next.val)){
                    dummyHead.next = dummyHead.next.next;
                }else if(dummyHead.next != null &&
                        !hashSet.contains(dummyHead.next.val)){
                    hashSet.add(dummyHead.next.val);
                    dummyHead = dummyHead.next;
                }else
                    dummyHead = dummyHead.next;
            }
            return head;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
