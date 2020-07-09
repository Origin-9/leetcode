public class Q912 {
    //冒泡排序
    class Solution1 {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            for(int e = nums.length - 1; e > 0; e--){
                for(int i = 0; i < e; i++){
                    if(nums[i] > nums[i+1]){
                        swap(nums,i,i+1);
                    }
                }
            }
            return nums;
        }
        private void swap(int[] nums,int a,int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b]= tmp;
        }
    }
    //插入排序
    class Solution2 {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length < 2) {
                return nums;
            }

            for(int i = 1; i < nums.length;i++){
                for(int j = i-1;j >= 0 && nums[j] > nums[j+1];j--){
                    swap(nums,j,j+1);
                }
            }
            return nums;
        }

        private void swap(int[] nums,int a,int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b]= tmp;
        }
    }
    //选择排序
    class Solution3 {
        public int[] sortArray(int[] nums) {
            for(int i = 0 ; i < nums.length - 1 ; i++){
                int minIndex = i;
                for(int j = i+1;j < nums.length;j++){
                    minIndex = nums[minIndex] < nums[j] ? minIndex : j;
                }
                swap(nums,i,minIndex);
            }
            return nums;
        }
        private void swap(int[] nums,int a,int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b]= tmp;
        }

    }
}
