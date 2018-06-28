package jzoffer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * create by fungus on 2018/6/27
 **/

/*
按之字形顺序打印二叉树需要两个栈
我们在打印某一行结点时，
把下一层的子结点保存到相应的栈里。
如果当前打印的是奇数层，则先保存左子结点再保存右子结点到一个栈里；
如果当前打印的是偶数层，则先保存右子结点再保存左子结点到第二个栈里。
 */
public class PrintBinTreeUseZ {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int layer = 1;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (!stack1.empty() || !stack2.empty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp1 = new ArrayList<>();
                while (!stack1.empty()) {
                    TreeNode node = stack1.pop();
                    if (node != null) {
                        temp1.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }
                }
                if (!temp1.isEmpty()) {
                    list.add(temp1);
                    layer++;
                }
            } else {
                ArrayList<Integer> temp2 = new ArrayList<>();
                while (!stack2.empty()) {
                    TreeNode node = stack2.pop();
                    if (node != null) {
                        temp2.add(node.val);
                        stack1.push(node.right);
                        stack1.push(node.left);
                    }
                }
                if (!temp2.isEmpty()) {
                    list.add(temp2);
                    layer++;
                }
            }
        }
    return list;
    }

}
