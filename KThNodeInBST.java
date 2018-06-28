package jzoffer;

import java.util.Stack;

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
        TreeNode KthNode(TreeNode root, int k) {
            if (root == null || k == 0) return null;
            Stack<TreeNode> stack = new Stack<>();
            int count = 0;
            TreeNode node = root;
            do {
                if (node != null) {
                    stack.push(node);
                    node = node.left;

                } else {
                    node = stack.pop();
                    if (++count == k) return node;
                    node = node.right;
                }
            } while (!stack.empty() || node != null);
        return null;
        }
    }
}
