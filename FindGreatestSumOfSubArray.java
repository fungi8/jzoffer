package jzoffer;

/**
 * create by fungus on 2018/6/6
 *
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决
 * 。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 **/

public class FindGreatestSumOfSubArray {

    // 举例分析数组规律的解法
//    public int FindGreatestSumOfSubArray(int[] array) {
//        if (array == null || array.length == 0) {
//            return -1;
//        }
//        int curSum = 0;
//        int greatestSum = array[0];
//
//        for (int i = 0; i < array.length; i++) {
//
//            if (curSum <= 0) {
//                curSum = array[i];
//            } else {
//                curSum += array[i];
//            }
//            if (curSum > greatestSum) {
//                greatestSum = curSum;
//            }
//        }
//        return greatestSum;
//    }

    //动态规划解法
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int greatestSum = array[0];
        for (int i = 0, dp = 0; i < array.length; ++i) {
            //dp公式
            dp = Math.max(dp + array[i], array[i]);
            //新的dp值和已经存在dp值比较，返回大值
            greatestSum = Math.max(greatestSum, dp);
        }
        return greatestSum;
    }
}
