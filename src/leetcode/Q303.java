package leetcode;

public class Q303 {
    class NumArray {
        private int[] arr;

        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;

            for(; i <= j ;i++){
                sum += arr[i];
            }
            return sum;
        }
    }
}
