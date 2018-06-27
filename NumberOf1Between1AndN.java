package jzoffer;

/**
 * create by fungus on 2018/6/19
 * 求出1~13的整数中1出现的次数,
 * 并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数
 **/

public class NumberOf1Between1AndN {

    /*
    最普通的解法，如果输入的数字n,n有O(log n)位，，时间复杂度是O(n * log n)
    public int NumberOf1Between1AndN_Solution(int n) {
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number += numberOfOne(i);
        }
        return number;
    }
    private int numberOfOne(int i) {
        int res = 0;
        while (i > 0) {
            if (i % 10 == 1) {
                res++;
            }
            i = i / 10;
        }
        return res;
    }

    */


    /**
     * 梦幻解法，，比较难理解，时间复杂度提高了一个O(N)的数量级 最终的时间复杂度只有O(log n)
     *
     * 这道题为什么会有独特的解法，独特的解法其实是来源于这个表达式中的数字规律而已
     * @param n
     * @return
     */

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) return 0;
        int count = 0;//1的个数
        int i = 1;
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;

            if (current == 0) {
                count += before * i;
            } else if (current == 1) {
                count += before * i + after + 1;
            } else {
                count += (before + 1) * i;
            }
            i = i * 10;
        }
        return count;
    }
    }
