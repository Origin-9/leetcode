public class Q75 {
    class Solution {
        public void sortColors(int[] nums) {
            int l = -1;
            int r = nums.length ;

            int cur = 0;
            while(cur < r){
                if(nums[cur] < 1){
                   swap(nums, ++l, cur++);
                }
                else if(nums[cur] > 1){
                    swap(nums, --r, cur);
                }
                else{
                    cur++;
                }
            }
        }

        public void swap(int[] arr,int a,int b){
            int temp = arr[b];
            arr[b] = arr[a];
            arr[a] = temp;
        }
    }
}
