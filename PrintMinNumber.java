package jzoffer;


/**
 * create by fungus on 2018/6/19
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 **/

import java.util.Arrays;
import java.util.Comparator;

/**
 * 解题思路：
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 排序规则如下：
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 * 解释说明：
 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] strs = new String[len];
        StringBuilder sb = new StringBuilder();
        //整型数组转换成String数组
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        //将String数组排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });

        //排好序的字符串数组拼接出来
        for (int i = 0; i < len; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
