package jzoffer;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {

    public class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();
            Set<String> set = new HashSet<>();
            if (str != null && str.length() > 0) {
                PermutationHelper(str.toCharArray(), 0, set);
                res.addAll(set);
                Collections.sort(res);
            }
            return res;
        }

        private void PermutationHelper(char[] chars, int i, Set<String> res) {
            if (i == chars.length - 1) {//解空间的一个叶节点
                res.add(String.valueOf(chars));
            } else {
                for (int j = 0; j < chars.length; j++) {
                    if (j == i || chars[j] != chars[i]) {
                        swap(chars, i, j);
                        PermutationHelper(chars, i + 1, res);
                        swap(chars, i, j);
                    }
                }
            }
        }


        public void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
