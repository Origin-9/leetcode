package leetcode.普通题;

public class Q88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index1 = m-1, index2 = n-1;
            int index = m + n - 1;

            while (index1 >= 0 && index2 >= 0){
                if(nums2[index2] >= nums1[index1])
                    nums1[index--] = nums2[index2--];
                else if(nums2[index2] < nums1[index1]){
                    nums1[index--] = nums1[index1--];
                }
            }
            while (index1 >= 0){
                nums1[index--] = nums1[index1--];
            }
            while (index2 >= 0){
                nums1[index--] = nums2[index2--];
            }
        }
    }
}
