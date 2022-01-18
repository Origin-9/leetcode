package leetcode.普通题;

public class Q12 {
    static class Solution {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; num > 0 && i < 13; ) {
                int temp = num - values[i];
                if (temp >= 0) {
                    stringBuilder.append(symbols[i]);
                    num = num - values[i];
                } else {
                    i++;
                }
            }

            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        new Solution().intToRoman(3);
    }
}
