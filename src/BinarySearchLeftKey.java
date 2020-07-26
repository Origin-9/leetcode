public class BinarySearchLeftKey {
    public int binarySearch(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] == key) {
                h = m;
            }
            else if(nums[m] > key){
                h = m-1;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchLeftKey().binarySearch(new int[]{1,2,3,4,4,5,5}, 5));
    }
}
