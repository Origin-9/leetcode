package leetcode;

import java.util.*;

public class Q347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap <Integer, Integer> hashMap = new HashMap<>();
            for(int num : nums){
                if(!hashMap.containsKey(num))
                    hashMap.put(num, 1);
                else
                    hashMap.put(num, hashMap.get(num) + 1);
            }
            PriorityQueue<Integer> priorityQueue =
                    new PriorityQueue<>((n1, n2) -> hashMap.get(n1) - hashMap.get(n2));

            for(int n : hashMap.keySet()){
                priorityQueue.add(n);
                if(priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }

            int index = 0;
            int[] res = new int[priorityQueue.size()];
            while (!priorityQueue.isEmpty()){
                res[index++]  = priorityQueue.poll();
            }

            return Arrays.copyOf(res, index);
        }
    }
}
