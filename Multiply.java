package jzoffer;

/**
 * create by fungus on 2018/6/27
 *
 * 给定一个数组A[0,1,...,n-1]
 * 请构建一个数组B[0,1,...,n-1],
 *
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 **/

public class Multiply {
    //dp大佬式炫技解法
    public int[] multiply(int[] a) {
        int len = a.length;
        int[] forward = new int[len];
        int[] backward = new int[len];
        int[] b = new int[len];
        //dp基
        forward[0] = 1;
        backward[0] = 1;
        forward[len - 1] = 1;
        backward[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            forward[i] = a[i - 1] * forward[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            backward[i] = a[i + 1] * backward[i + 1];
        }
        for (int i = 0; i < len; i++) {
            b[i] = forward[i] * backward[i];
        }
        return b;
    }
}
