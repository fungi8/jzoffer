package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * create by fungus on 2018/6/27
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 **/

public class Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        queue.offer(root);
        int start = 0, end = 1; //标记一行中的元素个数
        ArrayList<Integer> listT = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                listT.add(node.val);
                start++;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (!listT.isEmpty() && start == end) {
                end = queue.size();
                start = 0;
                list.add(listT);
                listT = new ArrayList<>();
            }
        }
        return list;
    }




}
