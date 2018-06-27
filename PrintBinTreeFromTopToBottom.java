package jzoffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinTreeFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) return list;
            //root节点入队
            queue.offer(root);
            while (queue.size() > 0) {
                //get one node
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                //left 存在入队
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                //right 存在入队
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            return list;
        }
    }
}
