package jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * create by fungus on 2018/6/27
 * <p>
 * 给定一颗二叉搜索树，
 * <p>
 * 请找出其中的第k小的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 **/

public class KThNodeInBST {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        //这个是不压入系统栈中的
        int index = 0;
        TreeNode KthNode(TreeNode root, int k) {
            if (root != null) {
                //去了最左的子树 --> 返回空---> 然后统计左子树的top数量
                TreeNode node = KthNode(root.left, k);
                if (node != null) {
                    return node;
                }
                index++;
                if (index == k) {
                    return root;
                }
                node = KthNode(node.right, k);
                if (node != null) {
                    return node;
                }
            }
            return null;
        }
    }
}
