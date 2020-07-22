import java.util.Arrays;
import java.util.Comparator;
public class Q452 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            if (points.length == 0) {
                return 0;
            }
            int res = 1;
            int end = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= end) {
                    continue;
                }
                res++;
                end = points[i][1];
            }
            return res;
        }
    }
}
