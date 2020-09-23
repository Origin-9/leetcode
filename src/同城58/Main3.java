package 同城58;

import java.util.*;


    public class Main3 {
        /**
         * 合并数组
         * @param arrayA int整型ArrayList 数组A
         * @param arrayB int整型ArrayList 数组B
         * @return int整型ArrayList
         */
        public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
            // write code here
            int size1 = arrayA.size();
            int size2 = arrayB.size();
            int index1 = 0, index2 = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (index1 < size1 && index2 < size2){
                if (arrayA.get(index1) == arrayB.get(index2)) {
                    list.add(arrayA.get(index1));
                    index1++;
                    index2++;
                }else if (arrayA.get(index1)  < arrayB.get(index2)){
                    index1++;
                }
                else
                    index2++;
            }
            return list;
        }
    }
