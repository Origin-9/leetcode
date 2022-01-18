package leetcode.普通题;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        private int size;
        private int capacity;
        private LinkedNode dummyHead;
        private LinkedNode dummyTail;
        private Map<Integer, LinkedNode> map = new HashMap<>();

        public LRUCache(int capacity) {
            size = 0;
            this.capacity = capacity;
            dummyHead = new LinkedNode();
            dummyTail = new LinkedNode();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public int get(int key) {
            LinkedNode node = map.get(key);
            if (node == null)
                return -1;
            else{
                moveToHead(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            LinkedNode node = map.get(key);
            if (node != null){
                //如果key存在在map中
                node.value = value;
                moveToHead(node);

            }else {
                //如果key不存在在map中
                LinkedNode newNode = new LinkedNode(key,value);
                insertNode(key, newNode);
                map.put(key, newNode);
                size++;
                if (size > capacity){
                    map.remove(deleteNode());
                    --size;
                }
            }
        }
        //虚拟头节点后插入节点
        private void insertNode(int key, LinkedNode newNode){
            LinkedNode tmp = dummyHead.next;
            dummyHead.next = newNode;
            newNode.pre = dummyHead;

            newNode.next = tmp;
            tmp.pre = newNode;
        }
        //移除尾节点
        private int deleteNode(){
            //倒数第二个节点
            LinkedNode tmp = dummyTail.pre.pre;
            LinkedNode gcNode = tmp.next;
            tmp.next = dummyTail;
            dummyTail.pre = tmp;
            int res = gcNode.key;
            gcNode = null;
            return res;
        }
        private void moveToHead(LinkedNode node){
            //将node从双向链表中移除
            LinkedNode next = node.next;
            LinkedNode pre = node.pre;
            next.pre = pre;
            pre.next = next;
            //移到头节点
            LinkedNode tmp = dummyHead.next;
            dummyHead.next = node;
            node.pre = dummyHead;

            node.next = tmp;
            tmp.pre = node;
        }

        private class LinkedNode{
            int key;
            int value;
            LinkedNode pre;
            LinkedNode next;
            public LinkedNode(){

            }
            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "LinkedNode{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }
    }
}
