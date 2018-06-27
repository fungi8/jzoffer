package jzoffer;

import java.util.ArrayList;

/**
 * create by fungus on 2018/6/26
 *
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 **/

public class FindContinuousSequence {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum == 0) return null;
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        innerList.add(2);
        int small = 0; // small index
        int big = 1; //big index
        int num = innerList.get(big);
        while (small < big) {
            if (sum(innerList, small, big) < sum) {
                innerList.add(++num);
                big++;
            } else if (sum(innerList, small, big) > sum) {
                innerList.remove(small);
                big--;
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>(innerList);
                outerList.add(list);
                innerList.add(++num);
                big++;
            }
        }
        return outerList;
    }

    private static int sum(ArrayList<Integer> list, int small, int big) {
        //3 , 5
        int res = 0;
        while (small <= big) {
            res += list.get(small);
            small++;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> outer = FindContinuousSequence(15);
        for ( ArrayList<Integer> inner : outer) {
            for (Integer i : inner) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
