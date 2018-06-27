package jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * create by fungus on 2018/6/27
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中<b>任意</b>一个重复的数字。
 *
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 **/

public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false


    //下面是额外空间复杂度O(N)的算法，用了hashTable
    /*
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
            set.add(numbers[i]);
        }
        return false;
    }

    {2,3,1,0,2,5,3}

    */

    /*
    使用boolean是直接将上面的算法优化了8倍的空间。 但是长期期望上将还是O(N)的空间
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length < 2) return false;
        boolean[] judge = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (judge[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            judge[numbers[i]] = true;
        }
        return false;
    }
    */

    //尝试O(1)的空间
    //开始遍历，如果没有重复元素应该都可以归到他的下标位置。但是显然本题目是有重复元素的
    //如果当前的元素不在他应该在的位置
    //归位
    /*
    * case : {2,3,1,0,2,5,3}
    *
    * 1. {2,3,1,0,2,5,3}
    * 2. {1,3,2,0,2,5,3}
    * 3. {3,1,2,0,2,5,3}
    * 4. {0,1,2,3,2,5,3}
    * 5. {0,1,2,3,2,5,3}
    *    return true;
    * */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length < 2) return false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
