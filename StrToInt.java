package jzoffer;

/**
 * create by fungus on 2018/6/26
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 *
 * 数值为0或者字符串不是一个合法的数值则返回0
 **/

public class StrToInt {

    public static int StrToInt(String str) {
        if (str == null || str.length() < 1) return 0;
        char[] chars = str.toCharArray();
        int [] ints = new int[chars.length];

        //判断正负逻辑
        boolean minusSign = false;
        int po = 0;
        char sign = chars[0];
        if (sign == 45) {
            minusSign = true;
            po = 1;
        } else if (sign == 43) {
            minusSign = false;
            po = 1;
        } else {
            po = 0;
        }
        for (; po < ints.length; po++) {
            if (chars[po] > 57 || chars[po] < 48) {
                return 0;
            }
            ints[po] = chars[po] - 48;
        }
        int res = 0;
        for (int i = 0, j = ints.length - 1; i < ints.length; i++) {
            ints[i] = (int) (Math.pow(10, j--) * ints[i]);
            res += ints[i];
        }
        if (minusSign) {
            return 0 - res;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("123"));
    }
}
