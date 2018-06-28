package jzoffer;

/**
 * create by fungus on 2018/6/27
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 *
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 **/

public class IsSymmetrial {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        boolean isSymmetrical(TreeNode root) {
            if (root == null) return true;
            return comRoot(root.left, root.right);
        }
        private boolean comRoot(TreeNode left, TreeNode right) {
            //写递归基
            if (left == null) return right == null;
            if (right == null) return false;
            if (left.val != right.val) return false;
            //递归
            return comRoot(left.left, right.right) && comRoot(right.left, left.right);
        }
    }


}
