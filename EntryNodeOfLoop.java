package jzoffer;

/**
 * create by fungus on 2018/6/27
 * <p>
 * 一个链表中包含环，请找出该链表的环的入口结点。
 **/

public class EntryNodeOfLoop {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //链表有环求环的入口  无需判断是否有环
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode f = pHead;
        ListNode s = pHead;
        //loop 结束指针相遇
        do {
            if (f == null || f.next == null || f.next.next == null) return null;
            f = f.next.next;
            s = s.next;
        } while (f != s);
        f = pHead;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
