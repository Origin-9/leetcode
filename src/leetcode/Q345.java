package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Q345 {
    class Solution {
        public String reverseVowels(String s) {
            char[] arr = s.toCharArray();

            int l = 0, r = s.length() - 1;

            while (l <= r) {
                if (isChar(arr[l]) && isChar(arr[r])) {
                    swap(arr, l, r);
                    l++;
                    r--;
                    continue;
                }
                if (!isChar(arr[l]))
                    l++;
                if (!isChar(arr[r]))
                    r--;
            }
            return new String(arr);
        }

        private void swap(char[] arr, int l, int r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }

        private Boolean isChar(char c) {
            switch (c) {
                case 'a':
                    return true;
                case 'e':
                    return true;
                case 'i':
                    return true;
                case 'o':
                    return true;
                case 'u':
                    return true;
                case 'A':
                    return true;
                case 'E':
                    return true;
                case 'I':
                    return true;
                case 'O':
                    return true;
                case 'U':
                    return true;
                default:
                    return false;
            }
        }
    }
}
