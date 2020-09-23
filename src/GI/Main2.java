package GI;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] targetLine = sc.nextLine().split(" ");
            long[] targets = new long[targetLine.length];
            for(int i = 0; i < targetLine.length; i++){
                targets[i] = Integer.parseInt(targetLine[i]);
            }
            //寻找数组最长上升子序列
            //dp[i]:[0-i]的最长上升子序列
            int[] dp = new int[targets.length+1];
            dp[0] = 0;
            for (int i = 1; i < dp.length; i ++){
                dp[i] = 1;
            }
            for (int i = 2; i < dp.length; i++){
                for(int j = i - 1; j > 0; j--){
                    if (targets[i-1] >= targets[j-1]){
                        dp[i] = dp[j] + 1;
                        break;
                    }
                }
            }
            System.out.println(dp[dp.length-1]);
        }
    }
}