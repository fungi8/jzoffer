package jzoffer;

import java.util.ArrayList;

/**
 * create by fungus on 2018/6/26
 * <p>
 * 输入一个 <b>递增排序</b> 的数组和一个数字S，
 * 在数组中查找<b>两个数</b>，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 **/

public class FindNumberWithSum {

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int small = 0;
        int big = array.length - 1;
        ArrayList<Integer> res = new ArrayList<>(2);
        while (small < big) {
            if (array[small] + array[big] < sum) {
                small++;
            } else if (array[small] + array[big] > sum) {
                big--;
            } else {
                res.add(0, array[small]);
                res.add(1, array[big]);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 12, 15};
        ArrayList<Integer> list = FindNumbersWithSum(arr, 11);
        System.out.println(list.get(0) + "  " + list.get(1));
    }
}
