package jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * create by fungus on 2018/6/26
 *
 * 大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 *
 * 有2个大王,2个小王(一副牌原本是54张^_^)..
 *
 * 要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 **/

public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 1) return false;
        Set<Integer> set = new HashSet<>();
        int maxn = -1, minn = 14;
        for (int a : numbers) {
            //已经存在了会返回false
            //出现对子，不可能成为串子
            if (!set.add(a) && a != 0) return false;
            if (a != 0) {
                maxn = Math.max(maxn, a);
                minn = Math.min(minn, a);
            }
        }
        return (maxn - minn) <= 4;
    }
}
