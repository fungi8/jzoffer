package jzoffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树(BST)转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode Convert(TreeNode root) {
        if (root == null) return null;
        inOrder(root);
        while (root.left != null) root = root.left;
        return root;


    }
    private TreeNode pre = null;

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null) pre.right = node;
        pre = node;
        inOrder(node.right);
    }
}
