package leetcode.普通题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //入度表
            int[] indegrees = new int[numCourses];
            //邻接表
            List<List<Integer>> lists = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++){
                lists.add(new ArrayList<>());
            }

            for (int[] cp : prerequisites){
                indegrees[cp[1]]++;
                lists.get(cp[0]).add(cp[1]);
            }
            for (int i = 0; i < numCourses; i++){
                if (indegrees[i] == 0)
                    queue.add(i);
            }
            while (!queue.isEmpty()){
                int pre = queue.poll();
                numCourses--;
                for(int cur : lists.get(pre)){
                    if(--indegrees[cur] == 0)
                        queue.add(cur);
                }
            }
            return numCourses == 0;
        }
    }

    class Solution1 {
//        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            int[] todegrees = new int[numCourses];
//
//
//        }
    }
}
