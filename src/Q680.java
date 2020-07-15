public class Q680 {
    class Solution {
        private Boolean flag = true;
        public boolean validPalindrome(String s) {
            char[] array = s.toCharArray();

            int l = 0,r = array.length - 1;
            while(l < r){
                if(array[l] != array[r] && !flag){
                    return false;
                }
                if(array[l] != array[r] && flag){
                    flag = false;
                    return validPalindrome(s.substring(l,r)) || validPalindrome(s.substring(l+1,r+1));
                }
                else if(array[l] == array[r]){
                    l++;
                    r--;
                }
            }
            return true;
        }
    }
}
