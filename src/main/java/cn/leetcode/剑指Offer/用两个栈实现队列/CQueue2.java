package cn.leetcode.剑指Offer.用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2023/3/4 18:31
 */
public class CQueue2 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue2() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        CQueue2 obj = new CQueue2();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        obj.appendTail(1);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
