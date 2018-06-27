package jzoffer;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MainStack {

    public class Solution {

        Stack<Integer> data = new Stack<>();
        Stack<Integer> min = new Stack<>();
        Integer mint = null;
        public void push(int node) {
            if (mint == null) {
                mint = node;
                data.push(node);
                min.push(node);
            } else {
                if (node < mint) {
                    mint = node;
                    data.push(node);
                    min.push(node);
                }
                data.push(node);
            }
        }

        public void pop() {
            int data1 = data.pop();
            int min1 = min.pop();
            if (data1 != min1) {
                min.push(min1);
            }
        }

        public int top() {
            int num = data.pop();
            data.push(num);
            return num;
        }

        public int min() {
            int min1 = min.pop();
            min.push(min1);
            return min1;
        }
    }
}
