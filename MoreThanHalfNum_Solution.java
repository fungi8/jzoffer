package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {

    public static class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            if (array == null) return 0;
            if (array.length == 1) return array[0];
            Map<Integer, Integer> map = new HashMap<>();//map的第一个值是数组元素的值，第二个值是数组下标
            int length = array.length;

            //create map
            for (int i = 0; i < length; i++) {
                map.put(array[i], i);
            }

            //run this loop
            for (int i = 0; i < length; i++) {
                int m = 0;
                int aim = array[i];
                for (int j = 0; j < array.length; j++) {
                    if (aim == array[j]) {
                        m++;
                    }
                }
                if (m > array.length / 2) {
                    return aim;
                }
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(new Solution().MoreThanHalfNum_Solution(arr));
    }
}
