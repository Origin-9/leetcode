package leetcode.普通题;

public class Q8 {
    static class Solution {
        public int myAtoi(String str) {
            String temp = str.trim();

            //去除字符串首尾空格后字符串长度判断
            if(temp.length() == 0)
                return 0;

            int index = 0;
            if((temp.charAt(index) != '-' && !Character.isDigit(temp.charAt(index))) && temp.charAt(index) != '+')
                return 0;

            if(temp.charAt(index) == '-' || temp.charAt(index) == '+')
                index ++;

            int res = 0;
            while(index < temp.length() && Character.isDigit(temp.charAt(index))){
                int tem = temp.charAt(index)  - '0';
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && tem > 7)){
                    if(temp.charAt(0) == '-') {
                        res = -res;
                        return  Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }
                res = res * 10 + tem;
                index++;
            }


            if(temp.charAt(0) == '-') {
                    res = -res;
                    return  res;
            }
            else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("18446744073709551617"));
    }
}
