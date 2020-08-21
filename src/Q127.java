import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            boolean[] marked = new boolean[wordList.size()];
            int steps = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    String curStr = queue.poll();

                    for (int i = 0; i < wordList.size(); i++) {
                        if (marked[i])
                            continue;

                        String tmp = wordList.get(i);
                        if (canChange(curStr, tmp)) {
                            if (tmp.equals(endWord))
                                return steps + 1;
                            queue.add(tmp);
                            marked[i] = true;

                        }
                    }
                }
                steps++;
            }
            return 0;
        }

        private boolean canChange(String s1, String s2) {
            int dif = 0;
            int n = s1.length();
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i))
                    dif++;
            }
            return dif <= 1;
        }
    }

    class Solution1 {
        //BFS的思想
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<String>();//少不了队列
            queue.add(beginWord);
            boolean[] marked = new boolean[wordList.size() + 1];//少不了标记
            int layer = 1;//注意返回的是层数+1.所以这里直接放1了
            while (!queue.isEmpty()) {//固定的层数记录形式
                layer++;
                int size = queue.size();
                while (size-- > 0) {
                    String cur = queue.poll();
                    for (int i = 0; i < wordList.size(); i++) {
                        if (marked[i]) continue;
                        String dic = wordList.get(i);
                        if (canChange(dic, cur)) {
                            if (dic.equals(endWord)) return layer;
                            queue.add(dic);
                            marked[i] = true;
                        }
                    }
                }
            }

            return 0;
        }

        //是否可以转换的辅助函数
        public boolean canChange(String s, String t) {
            int len = s.length();
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) diff++;
            }
            return diff == 1;
        }
    }
}

