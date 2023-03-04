package cn.leetcode.剑指Offer.包含min函数的栈;

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
public class MinStack {
    private Node head;

    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(head.min(), x), head);
        }
    }

    public void pop() {
        head = head.next();
    }

    public int top() {
        return head.val();
    }

    public int min() {
        return head.min();
    }


    class Node {
        private Integer val;
        private Integer min;
        private Node next;

        public Node(Integer val, Integer min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

        public Integer min() {
            return min;
        }

        public Integer val() {
            return val;
        }

        public Node next() {
            return next;
        }
    }


    public static void main(String[] args) {
        //["MinStack","push","push","push","min","pop","top","min"]
        //[[],[-2],[0],[-3],[],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.min();
        minStack.pop();
        minStack.pop();
        int min2 = minStack.min();

        System.out.println(min1);
        System.out.println(min2);
    }
}


