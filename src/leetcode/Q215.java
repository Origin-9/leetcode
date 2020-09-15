package leetcode;

public class Q215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int l = 0, r = nums.length - 1;
            int target = nums.length - k;

            while(true){
                int index = partition(nums, l, r);
                if(index == target)
                    return nums[index];
                else if(index < target)
                    l = index+1;
                else
                    r = index - 1;
            }
        }
        private int partition(int[] nnums, int l, int r){
            swap(nnums, l + (int)Math.random() * (r - l),r);
            int p1 = l - 1, p2 = r;
            while (l < p2){
                if(nnums[l] < nnums[r]){
                    swap(nnums, ++p1, l++);
                }
                else if(nnums[l] > nnums[r]){
                    swap(nnums, --p2, l);
                }
                else {
                    l++;
                }
            }
            swap(nnums, p2, r);
            return p2;
        }

        private void swap(int[] nums, int l, int r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
