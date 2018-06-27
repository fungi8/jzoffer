package jzoffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树(BST)的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public class Solution {
        public boolean VerifySquenceOfBST(int [] sequence) {
            if (sequence.length == 0) return false;
            if (sequence.length == 1) return true;
            return partition(sequence, 0 ,sequence.length - 1);
        }

        private boolean partition (int[] sequence, int start, int end) {
            if (start >= end) return true;
            int i = start;
            while (sequence[i] < sequence[end]) ++i;
            for (int j = i; j < end; j++) {
                if (sequence[j] < sequence[end])
                    return false;
            }
            return partition(sequence, start, i - 1) && partition(sequence, i, end - 1);
        }
    }
}
