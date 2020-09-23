package GI;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution ans = new Solution();
        while (sc.hasNextLine()){
            String[] targetLine = sc.nextLine().split(" ");
            int[] targets = new int[targetLine.length];
            for(int i = 0; i < targetLine.length; i++){
                targets[i] = Integer.parseInt(targetLine[i]);
            }
            int target = Integer.parseInt(sc.nextLine());
            int out = ans.search(targets, target);
            System.out.println(out);
        }
    }
}
class Solution{
    public int search(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else
                return mid;
        }
        return -1;
    }
}
