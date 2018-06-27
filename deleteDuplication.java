package jzoffer;

import java.util.LinkedHashSet;

/**
 * create by fungus on 2018/6/27
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * <p>
 * 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 **/

public class deleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //解法1，
    public ListNode deleteDuplication(ListNode pHead) {
        LinkedHashSet<ListNode> set = new LinkedHashSet<>();
        
    }
}
