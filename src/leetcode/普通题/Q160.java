package leetcode.普通题;

public class Q160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int len1 = 0, len2 = 0;
            ListNode end1 = null, end2 = null;
            ListNode start1 = headA, start2 = headB;
            while(start1 != null){
                len1++;
                end1 = start1;
                start1 = start1.next;
            }
            while(start2 != null){
                len2++;
                end2 = start2;
                start2 = start2.next;
            }
            if(end1 != end2)
                return null;
            else {
                if(len1 > len2) {
                    for (int i = 0; i < (len1 - len2) ; i++){
                        headA = headA.next;
                    }
                }else {
                    for (int i = 0; i < (len2 - len1) ; i++){
                        headB = headB.next;
                    }
                }
                while(headA != headB){
                    headA = headA.next;
                    headB = headB.next;
                }
            }
            return headA;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
