package jzoffer;

import java.util.*;

/**
 * create by fungus on 2018/6/6
 * <p>
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 **/

public class GetLeastNumbers {

    private static ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < length; i++) {

            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }

        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
