import java.util.LinkedList;
import java.util.Queue;

public class Q279 {
    class Solution {
        public int numSquares(int n) {
            if(n == 0)
                return 0;

            int steps = 0, tempSize, tempValue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            while(!queue.isEmpty()){
                tempSize = queue.size();

                while (tempSize-- != 0){
                    tempValue = queue.poll();

                    for (int j = (int) Math.sqrt(tempValue); j > 0; j--){
                        if(tempValue == j * j)
                            return steps + 1;
                        else {
                            queue.add(tempValue - j * j);
                        }
                    }
                }
                steps++;
            }
            return -1;
        }
    }
}
