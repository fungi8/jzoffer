package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * create by fungus on 2018/6/28
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 **/

public class MaxInWindows {

    //需要维护一个窗口内最大值的更新结构--->
    //加数的逻辑：使用一个双端队列，每次进来一个数，从尾部进，并且保证双端队列从头到尾是从大到小的，
    //如果新进来的数大，从尾部弹出，一直弹出到可以满足从大到小，或者空，然后加入

    //窗口减数逻辑：窗口向右移动，检查双端队列中头部的index是否过期，如果过期，从头部弹出
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || size < 1 || num.length < size) return new ArrayList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        Integer[] res = new Integer[num.length - size + 1];
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            //下面4行是更新逻辑
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);

            //如果过期，从头部弹出
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }

            if (i >= size - 1) {
                res[index++] = num[qmax.peekFirst()];
            }
        }
        return new ArrayList<Integer>(Arrays.asList(res));
    }


    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(arr, 3));
    }
}
