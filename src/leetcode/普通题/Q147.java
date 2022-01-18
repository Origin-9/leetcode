package leetcode.普通题;

public class Q147 {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if(head == null){
                return null;
            }
            if(head.next == null)
                return head;

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode curMax = head,cur = head.next;

            while(cur != null){
                if(cur.val >= curMax.val){
                    curMax = cur;
                    cur = cur.next;
                    continue;
                }
                //摘节点
                curMax.next = cur.next;
                ListNode temp = dummyNode;

                while(temp.next.val < cur.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
                temp.next = cur;

                cur = curMax.next;
            }
            return dummyNode.next;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

