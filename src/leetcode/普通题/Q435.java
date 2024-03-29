package leetcode.普通题;

import java.util.Arrays;
import java.util.Comparator;

public class Q435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length == 0)
                return 0;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            int res = 1;
            int end = intervals[0][1];
            for(int i = 1; i < intervals.length; i++){
                if(intervals[i][0] < end){
                    continue;
                }
                end = intervals[i][1];
                res++;
            }
            return intervals.length - res;
        }
    }
}
