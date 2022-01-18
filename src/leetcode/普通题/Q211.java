package leetcode.普通题;

import java.util.TreeMap;

public class Q211 {
    class WordDictionary {
        class Trie {
            private Node node;
            private class Node{
                private boolean isWord;
                private TreeMap<Character, Node> next;

                public Node(boolean isWord){
                    this.isWord = isWord;
                    next = new TreeMap();
                }

                public Node(){
                    this(false);
                }
            }

            private Node root;
            /** Initialize your data structure here. */
            public Trie() {
                root = new Node();
            }

            /** Inserts a word into the trie. */
            public void insert(String word) {
                Node cur = root;

                for(int i = 0 ; i < word.length() ; i++){
                    if(!cur.next.containsKey(word.charAt(i)))
                        cur.next.put(word.charAt(i), new Node());
                    cur = cur.next.get(word.charAt(i));
                }
                if(!cur.isWord)
                    cur.isWord = true;
            }

            /** Returns if the word is in the trie. */
            public boolean search(String word) {
                return search(root, word, 0);
            }

            private boolean search(Node cur,String word, int index){
                if(index == word.length())
                    return cur.isWord;

                char c = word.charAt(index);

                if(c!='.'){
                    if(cur.next.get(c) == null)
                        return false;
                    return search(cur.next.get(c), word, index + 1);
                }
                else {
                    for (Character character : cur.next.keySet()){
                        if(search(cur.next.get(character), word, index + 1))
                            return true;
                    }
                    return false;
                }

            }

            /** Returns if there is any word in the trie that starts with the given prefix. */
            public boolean startsWith(String prefix) {
                Node cur = root;

                for(int i = 0 ; i < prefix.length() ; i++){
                    if(!cur.next.containsKey(prefix.charAt(i)))
                        return false;
                    cur = cur.next.get(prefix.charAt(i));
                }
                return true;
            }
        }

        private Trie trie;
        /** Initialize your data structure here. */
        public WordDictionary() {
            trie = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            trie.insert(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return trie.search(word);
        }
    }

}
