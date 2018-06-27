package jzoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * create by fungus on 2018/6/26
 *
 * 约瑟夫环的子问题
 **/

public class LastRemaining {

    //人的编号是0 - (n-1)一共有n个人。。。数字是m。。从0到m - 1
    //return 最后一个人的index
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) return -1;
        List<Integer> li = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            li.add(i);
        }
        int bt = 0;
        while (li.size() > 1) {
            bt = (bt + m - 1) % li.size();
            li.remove(bt);
        }
        return li.size() == 1 ? li.get(0) : -1;
    }
}
