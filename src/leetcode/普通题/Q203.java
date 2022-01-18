package leetcode.普通题;

/**
 * Definition for singly-linked list.
 */


// 删除链表中等于给定值 val 的所有节点
public class Q203 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode pre = dummyHead;

            while(pre.next != null){
                if(pre.next.val == val){
//                ListNode cur = pre.next;
//                pre.next = cur.next;
//                cur.next = null;
                    pre.next = pre.next.next;
                }
                else
                    pre = pre.next;
            }
            return dummyHead.next;
        }
    }
}
