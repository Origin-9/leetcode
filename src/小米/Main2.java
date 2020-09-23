package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (!hashSet.contains(s.charAt(i))){
                stringBuilder.append(s.charAt(i));
                hashSet.add(s.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
