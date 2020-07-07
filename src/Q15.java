import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if(nums.length < 2){
                return new ArrayList<>();
            }
            List<List<Integer>> resList= new ArrayList<>();
            Arrays.sort(nums);
            for(int index = 0 ; index < nums.length - 2; index ++) {
                if(nums[index] > 0)
                    break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if(index > 0 && nums[index] == nums[index-1])
                    continue; // 去重

                int l = index + 1 , r = nums.length - 1;
                while(l < r) {
                    if (nums[index] + nums[l] + nums[r] < 0) {
                        l++;
                    } else if (nums[index] + nums[l] + nums[r] > 0) {
                        r--;
                    }else {
                        List<Integer> tmpList = new ArrayList<>();

                        tmpList.add(nums[index]);
                        tmpList.add(nums[l]);
                        tmpList.add(nums[r]);
                        while(l<r && nums[l] == nums[l+1])
                            l++;
                        while(l>r && nums[r] == nums[l-1])
                            r--;
                        l++;
                        r--;
                        resList.add(tmpList);
                    }
                }

            }
            return resList;
        }
    }

}
