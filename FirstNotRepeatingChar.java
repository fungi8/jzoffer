package jzoffer;

import java.util.Map;
import java.util.TreeMap;

/**
 * create by fungus on 2018/6/23
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置
 **/

public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 1) {
            return 0;
        }
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                int nu = map.get(str.charAt(i));
                map.put(str.charAt(i), ++nu);
            }
        }
        int i = 0;
        for (; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
