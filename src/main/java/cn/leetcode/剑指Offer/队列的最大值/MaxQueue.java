package cn.leetcode.剑指Offer.队列的最大值;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangdh
 * @desc 队列的最大值：请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * 设计 队列 单调队列
 * @date 2023/3/30 23:02
 */
public class MaxQueue {
    private Deque<Integer> queue;
    private Deque<Integer> help;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        int val = queue.pop();
        if(help.peek() == val) {
            help.pop();
        }
        return val;
    }

    public static void main(String[] args) {
        /**
         * Your MaxQueue object will be instantiated and called as such:
         * MaxQueue obj = new MaxQueue();
         * int param_1 = obj.max_value();
         * obj.push_back(value);
         * int param_3 = obj.pop_front();
         */
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(1);
        int param_3 = obj.pop_front();
    }
}

