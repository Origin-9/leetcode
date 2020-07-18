public class Q151 {
    static class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            if(s.length() == 0){
                return "";
            }
            if(s.length() == 1)
                return s;

            StringBuilder sb = new StringBuilder();
            String tmp = reverse(s,0,s.length() - 1);
            int start = 0,end = 0;
            int n = tmp.length();
            while(start < n){
                while(end < n && tmp.charAt(end) != ' '){
                    end++;
                }
                if(start < end) {
                    sb.append(reverse(tmp, start, end - 1));
                    sb.append(" ");
                }
                start = end + 1;
                end++;
            }

            return sb.toString().trim();
        }

        private String reverse(String s,int start,int end){
            StringBuilder sb = new StringBuilder();

            for(int i = end; i >= start; i--){
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        new Solution().reverseWords(" ");
    }
}
