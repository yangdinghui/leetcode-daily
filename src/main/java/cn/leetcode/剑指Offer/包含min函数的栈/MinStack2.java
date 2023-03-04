package cn.leetcode.剑指Offer.包含min函数的栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangdh
 * @desc 包含min函数的栈：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * @date 2023/3/4 18:35
 */
public class MinStack2 {
    Deque<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new LinkedList();
    }

    public void push(int x) {
        stack.addLast(x);
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stack.size(); i++) {
            int n = stack.removeLast();
            min = Math.min(min, n);
            if (n < min) {
                min = n;
            }
            stack.addFirst(n);
        }
        return min;
    }

    public static void main(String[] args) {
        //["MinStack","push","push","push","min","pop","top","min"]
        //[[],[-2],[0],[-3],[],[],[],[]]
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);

        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}


