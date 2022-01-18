package leetcode.普通题;

public class Q912 {
    //冒泡排序 o(n^2)
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
    //插入排序 o(n-n^2)
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
    //选择排序 o(n^2)
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
    //归并排序 o(n*logn)
    class Solution4 {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length < 2){
                return nums;
            }
            mergeSort(nums, 0, nums.length-1);
            return nums;
        }
        private void mergeSort(int[] nums, int l, int r){
            if(l==r)
                return;
            int mid = l + ((r-l) >> 1);
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,r);
            merge(nums,l,mid,r);
        }
        private void merge(int[] nums, int l,int mid, int r){
            int[] help = new int[r - l + 1];
            int index = 0,p1 = l,p2 = mid + 1;
            while(p1 <= mid && p2 <= r){
                help[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
            }
            while(p1 <= mid){
                help[index++] = nums[p1++];
            }
            while(p2 <= r){
                help[index++] = nums[p2++];
            }
            for(int i = 0; i < help.length; i++){
                nums[l+i] = help[i];
            }
        }
    }
    //随机快排 o(n*logn)
    class Solution5 {
        public int[] sortArray(int[] nums) {
            if(nums == null || nums.length < 2)
                return nums;

            quickSort(nums, 0, nums.length-1);
            return nums;
        }

        private void quickSort(int[] nums, int l, int r){
            if(l < r){
                swap(nums, l + (int)Math.random()*(r - 1 + 1), r);
                int[] p = partition(nums,l,r);
                quickSort(nums, l, p[0]-1);
                quickSort(nums, p[1]+1,r);
            }
        }

        private int[] partition(int[] nums, int l, int r){
            int less = l - 1;
            int more = r;
            while(l < more){
                if(nums[l] < nums[r])
                    swap(nums, ++less, l++);
                else if(nums[l] > nums[r])
                    swap(nums, --more, l);
                else
                    l++;
            }
            swap(nums, more, r);
            return new int[]{less + 1, more};
        }

        private void swap(int[] nums, int l, int r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
    //堆排o(n*logn)
    class Solution6{
        public int[] sortArray(int[] nums) {
            if(nums == null || nums.length < 2){
                return nums;
            }
            for(int i = 0; i < nums.length; i++){
                insertHeap(nums, i);
            }
            int size = nums.length;
            swap(nums,0, --size);
            while(size > 0){
                heapify(nums, 0, size);
                swap(nums, 0 ,--size);
            }
            return nums;
        }
        //生成大顶堆
        private void insertHeap(int[] nums, int i){
            while(nums[i] > nums[(i - 1)/2]){
                swap(nums, i ,(i-1)/2);
                i = (i-1)/2;
            }
        }
        //弹出最大之后，重新生成新树
        private void heapify(int[] nums, int index, int size){
            int left = index * 2 + 1;
            while(left < size){
                int largest = left + 1 < size &&
                        nums[left+1] > nums[left] ? left+1 : left;
                largest = nums[largest] > nums[index] ? largest : index;
                if(largest == index){
                    break;
                }
                swap(nums,largest,index);
                index = largest;
                left = index * 2 + 1;
            }
        }
        private void swap(int[] nums, int l, int r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

}
