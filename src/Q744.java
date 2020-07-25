public class Q744 {
    static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int l = 0, r = letters.length-1;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(letters[mid] <= target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            return l < letters.length ? letters[0] : letters[l];
        }
    }

    public static void main(String[] args) {
        new Solution().nextGreatestLetter(new char[]{'c','f','j'}, 'c');
    }
}
