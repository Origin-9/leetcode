package 同城58;

public class Main2 {
    /**
     *
     * @param num int整型 非负整数 num
     * @return int整型一维数组
     */
    public int[] countBits (int num) {
        // write code here
        int[] arr = new int[num+1];
        for(int i = 0; i < arr.length; i++){
            int tmp = 0;
            while (i > 0){
                i = i & (i-1);
                tmp++;
            }
            arr[i] = tmp;
        }
        return arr;
    }
}
