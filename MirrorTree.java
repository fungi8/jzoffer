package jzoffer;


import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class MirrorTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {

        public void Mirror(TreeNode root) {
            //递归版本
//            if (root == null) return;
//            if (root.left != null) Mirror(root.left);
//            if (root.right != null) Mirror(root.right);
//            TreeNode tmp = root.left;
//            root.left = root.right;
//            root.right = tmp;
            //非递归版本
            if (root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode tmpP = stack.pop();
                if (tmpP .left != null || tmpP.right != null) {
                    TreeNode tmp = tmpP.right;
                    tmpP.right = tmpP.left;
                    tmpP.left = tmp;
                }
                if (tmpP.right != null) stack.push(tmpP.right);
                if (tmpP.left != null) stack.push(tmpP.left);
            }
        }
    }
}
