package jzoffer;

/**
 * create by fungus on 2018/6/26
 *
 * 求1+2+3+...+n，要求不能使用乘
 * 除法、for、while、if、else、switch、case等
 * 关键字及条件判断语句（A?B:C）
 **/

public class Sum {
    public int Sum_Solution(int n) {
        int sum = n;
        // （sum > 0) 短路条件发生，递归终止
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;
    }
}
