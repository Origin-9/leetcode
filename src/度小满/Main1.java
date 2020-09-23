package 度小满;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (char c : t.toCharArray()){
            if (hashMap.get(c)!=null && hashMap.get(c) > 0){
                res++;
                hashMap.put(c, hashMap.get(c)-1);
            }
        }
        System.out.println(res);
    }
}
