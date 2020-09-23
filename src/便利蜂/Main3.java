package 便利蜂;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String s = bufferedReader.readLine();
        if (s.equals("")){
            System.out.println(0);
            return;
        }
        String[] str = s.split(",");

        int[] items = new int[str.length];
        for (int i = 0; i < str.length; i++){
            items[i] = Integer.parseInt(str[i]);
        }
        int ret = 0, index = items.length - 1;
        while (index >= 0){
            for (int i = index; i >0 ;){
                int money = n;
                if (money < 0) {
                    i--;
                    continue;
                }
                if(money == 0) {
                    ret++;
                }
                money = money - items[i];
            }

            index--;
        }
        System.out.println(ret);
    }

    private static int dfs(int money, int[] items, int index){
        if (money < 0)
            return 0;
        if (money == 0)
            return 1;
        int ret = 0;
        for (int i = index; i >= 0 ; i--){
            ret += dfs(money - items[i], items, i);
        }
        return ret;
    }
}
