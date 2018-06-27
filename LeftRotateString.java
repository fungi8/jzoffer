package jzoffer;

/**
 * create by fungus on 2018/6/26
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 **/

// YX = (X转置Y转置)转置
public class LeftRotateString {

    public static String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) return "";
        //X转置
        reverse(chars, 0, n - 1);
        //Y转置
        reverse(chars, n, chars.length - 1);
        //转置
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    private static void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

}
