package leetcode;

public class SubstringJudge {

        public static boolean getResult(String targetStr, String str) {
            if (targetStr.contains(str)) {
                return true;
            } else {
                return false;
            }
        }

        public static void main(String[] args) {

            String targetStr = "I love china,my motherland!";
            String str = "china";
            System.out.println(getResult(targetStr, str));
        }


}
