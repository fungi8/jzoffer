package jzoffer;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class Reverse {

        public static ListNode ReverseList(ListNode head) {
//            if (head == null)
//                return null;
//            ListNode reversedHead = null;
//            ListNode current = head;
//            ListNode tmp = null;
//            ListNode pre = null;
//            while (current != null) {
//                tmp = current.next;
//                current.next = pre;
//                if (tmp == null)
//                    reversedHead = current;
//                pre = current;
//                current = tmp;
//
//            }
//            return reversedHead;

            if (head == null) {
                return null;
            }
            ListNode reversedHead = null;
            ListNode tmp = null;
            ListNode current = head;
            ListNode pre = null;

            while (current != null) {
                tmp = current.next;
                current.next = pre;
                if (tmp == null) {
                    reversedHead = current;
                }
                pre = current;
                current = tmp;
            }
            return reversedHead;
        }

    }


}
