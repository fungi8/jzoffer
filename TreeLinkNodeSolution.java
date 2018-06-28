package jzoffer;

/**
 * create by fungus on 2018/6/27
 * <p>
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * <p>
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 **/

public class TreeLinkNodeSolution {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public TreeLinkNode GetNext(TreeLinkNode node) {
            if (node == null) return null;
            // 若该节点存在右子树：则下一个节点为右子树最左子节点
            if (node.right != null) {
                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
                // 若该节点不存在右子树：这时分两种情况：
                // 2.1 该节点为父节点的左子节点，则下一个节点为其父节点
            } else if (node.next != null && node.next.left == node) {
                return node.next;

                //该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，
                // 则该节点的父节点下一个节点（如图节点 I ，沿着父节点一直向上查找找到 B
                // B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）。

                //该节点是其父节点的右节点
            } else if (node.next != null && node.next.right == node) {
                while (node.next != null && node != node.next.left) {
                    node = node.next;
                }
                return node.next;
            } else {
                //节点无父节点 ，即节点为根节点
                return node.next;
            }
        }
    }

}
