/**
 * @author : Ori
 * @date : 2019/12/5
 */
public class Q1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for(int i = 0;i < nums.length;i++){
                for (int j = i+1;j<nums.length;j++){
                    if((nums[i] + nums[j]) == target)
                        return new int[]{i,j};
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];
        //allocation2 = new byte[900*1024];

    }
}