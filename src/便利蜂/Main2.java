package 便利蜂;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.valueOf(bufferedReader.readLine());
        HashSet<String> hashSet = new HashSet<>();
        String s = bufferedReader.readLine();
        String[] str = s.split("->");
        hashSet.add(str[0]);
        hashSet.add(str[1]);
        while (n-- > 1){
            String tmp = bufferedReader.readLine();
            String[] strTmp = tmp.split("->");
            if (hashSet.contains(strTmp[1])){
                System.out.println("Y");
                return;
            }
            hashSet.add(strTmp[1]);
        }
        System.out.println("N");
    }
}
