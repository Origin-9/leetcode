import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            if(people == null || people.length == 0 || people[0].length == 0)
                return new int[0][0];
            Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
            List<int[]> list = new ArrayList<>();
            for(int[] arr : people){
                list.add(arr[1], arr);
            }
            return list.toArray(new int[list.size()][2]);
        }
    }
}
