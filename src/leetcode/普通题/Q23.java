package leetcode.普通题;

import java.util.PriorityQueue;

public class Q23 {
    class Solution {
        //时间复杂度：O(NlogK)
        public ListNode mergeKLists1(ListNode[] lists) {
            if(lists.length == 0)
                return null;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(
                    (l1,l2)->l1.val - l2.val);

            for(ListNode node : lists){
                if(node == null)
                    continue;
                while(node!=null){
                    queue.add(node);
                    node = node.next;
                }
            }

            ListNode res = new ListNode(0);
            ListNode cur = res;
            while(!queue.isEmpty()){
                cur.next = queue.poll();
                cur.next.next = null;
                cur = cur.next;
            }
            return res.next;
        }
        //逐一合并
        public ListNode mergeKLists(ListNode[] lists) {
            return null;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
