package jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * create by fungus on 2018/6/27
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 **/

public class BinTreeSerialize {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        int index;

        String Serialize(TreeNode root) {
            if (root == null) return "#!";
            String res = root.val + "!";
            res += Serialize(root.left);
            res += Serialize(root.right);
            return res;
        }

        TreeNode Deserialize(String str) {
            if (str == null) return null;
            index = -1;
            String[] ss = str.split("!");
            return dSer(ss);
        }

        TreeNode dSer(String[] ss) {
            //这里一个全局变量，就是用来保证递归的唯一性，避免死循环递归
            index++;
            TreeNode root = null;
            if (!ss[index].equals("#")) {
                root = new TreeNode(Integer.valueOf(ss[index]));
                root.left = dSer(ss);
                root.right = dSer(ss);
            }
            return root;
        }

    }

}
