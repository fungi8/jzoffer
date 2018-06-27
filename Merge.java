package jzoffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 1-->2-->3-->4
 * 5-->6-->7-->8
 */
public class Merge {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode merge, mergeHead;
        merge = mergeHead = null;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (merge == null) {
                    merge = mergeHead = list1;
                } else {
                    mergeHead.next = list1;
                    mergeHead = mergeHead.next;
                }
                list1 = list1.next;
            } else {
                if (merge == null) {
                    merge = mergeHead = list2;
                } else {
                    mergeHead.next = list2;
                    mergeHead = mergeHead.next;
                }
                list2 = list2.next;
            }
        }
        mergeHead.next = list1 == null ? list2 : list1;

        return merge;
    }
}
