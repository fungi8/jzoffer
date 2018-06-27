package jzoffer;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * create by fungus on 2018/6/24
 *
 * 输入两个链表，找出它们的第一个公共结点。
 **/

public class FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        /*
        //使用栈的解法
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        //结尾的值必然相同
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode s1;
        while (l1 == l2) {
            l1 = stack1.pop();
            l2 = stack2.pop();
            if (stack1.empty()) {
                return l1;
            }
            if (stack2.empty()) {
                return l2;
            }
        }
        return l1.next;
    }
    */

    /*
        //使用hashSet的解法
        Set<ListNode> set = new HashSet<>();

        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) return pHead2;
            pHead2 = pHead2.next;
        }
        return null;

    }
    */
        //不使用额外空间的解法
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        if (length1 > length2) {
            int q = length1 - length2;
            while (q > 0) {
                pHead1 = pHead1.next;
                q--;
            }
        } else if (length1 < length2) {
            int w = length2 - length1;
            while (w > 0) {
                pHead2 = pHead2.next;
                w--;
            }
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int getLength(ListNode l1) {
        int length = 0;
        while (l1 != null) {
            length++;
            l1 = l1.next;
        }
        return length;
    }
}

