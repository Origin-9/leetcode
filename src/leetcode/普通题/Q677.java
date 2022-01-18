package leetcode.普通题;

import java.util.TreeMap;

public class Q677 {
    class MapSum {
        private class Node{

            public int value;
            public TreeMap<Character, Node> next;

            public Node(int value){
                this.value = value;
                next = new TreeMap<>();
            }

            public Node(){
                this(0);
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            for(int i = 0 ; i < key.length() ; i ++){
                char c = key.charAt(i);
                if(cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            cur.value = val;
        }

        public int sum(String prefix) {
            Node cur = root;
            for(int i = 0 ; i < prefix.length() ; i ++){
                char c = prefix.charAt(i);
                if(cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            int sum = 0;
            return sum(cur, sum);
        }

        public int sum(Node node, int sum){
            if(node == null)
                return sum;
            sum = node.value;
            for(Character character : node.next.keySet()){
                Node cur = node.next.get(character);

                sum += sum(cur, sum);
            }

            return sum;
        }
    }

}
