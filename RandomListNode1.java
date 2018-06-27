package jzoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */


public class RandomListNode1 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {


            //hashmap解法
//            HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
//            RandomListNode cur = pHead;
//
//            while (cur != null) {
//                map.put(cur, new RandomListNode(cur.label));
//                cur = cur.next;
//            }
//            cur = pHead;
//            while (cur != null) {
//                map.get(cur).next = map.get(cur.next);
//                map.get(cur).random = map.get(cur.random);
//                cur = cur.next;
//            }
//            return map.get(pHead);


            //O(1)空间解法
            if (pHead == null) return null;
            RandomListNode cur = pHead;
            RandomListNode next = null;

            // copy node and link to every node
            while (cur != null) {
                next = cur.next;
                cur.next = new RandomListNode(cur.label);
                cur.next.next = next;
                cur = next;
            }

            // set copy node rand
            cur = pHead;
            RandomListNode curCopy = null;

            while (cur != null) {
                next = cur.next.next;
                curCopy = cur.next;
                curCopy.random = cur.random != null ? cur.random.next : null;
                cur = next;
            }

            RandomListNode res = pHead.next;
            cur = pHead;
            //split
            while (cur != null) {
                next = cur.next.next;
                curCopy = cur.next;
                cur.next = next;
                curCopy.next = next != null ? next.next : null;
                cur = next;
            }
            return res;
        }
    }
}

/**
 * int a[m]
 * int b[n]
 * m > n > 1000
 * a中有b中没有
 * 返回int[] scort -->
 */
//    public static class Solution {
//        public static void main(String[] args) {
//            int[] a = {1,2,3,4,5,6,7,8,9,10};
//            int[] b = {8,9,10,11,12};
//            Integer[] scort = solution(a,b);
////            for (int i : scort) {
////                System.out.println(i);
////            }
////            System.out.println(scort);
//            for (int i = 0; i < scort.length; i++) {
//                System.out.println(scort[i]);
//            }
//
//        }
//
//        public static Integer[] solution(int[] a, int[] b) {
//            //a中有b中没有
//            int m = a.length;
//            int n = b.length;
//            Integer[] arr = {};
//            ArrayList<Integer> arrayList = new ArrayList<>();
//            HashSet<Integer> setB = new HashSet<>();
//            for (int i = 0; i < n; i++) {
//                setB.add(b[i]);
//            }
//            for (int j = 0; j < m; j++) {
//                if (!setB.contains(a[j])) {
//                    arrayList.add(a[j]);
//                }
//            }
//            return arrayList.toArray(arr);
//        }
//    }

