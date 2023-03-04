package cn.leetcode.剑指Offer.用两个栈实现队列;

import java.util.LinkedList;

/**
 * @author yangdh
 * @desc 用两个栈实现队列:用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：[null,null,3,-1,-1]
 * @date 2023/3/4 17:43
 */
public class CQueue {
    //进栈
    private final LinkedList<Integer> stack1;
    //出栈
    private final LinkedList<Integer> stack2;

    public LinkedList<Integer> getStack1() {
        return stack1;
    }

    public LinkedList<Integer> getStack2() {
        return stack2;
    }

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        Integer headEle = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return headEle;
    }

    public static void main(String[] args) {
        //输入（或说是操作）
        //["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
        //[[], [], [5], [2], [], []]
        //输出
        //[null, -1, null, null, 5, 2]
        CQueue obj = new CQueue();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        obj.appendTail(1);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.getStack1());
        System.out.println(obj.getStack2());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        //插入到LinkedList的第一个位置
//        linkedList.push(1);
//        linkedList.push(2);
//        linkedList.push(3);
//        linkedList.push(4);
//        System.out.println(linkedList);
//        while (!linkedList.isEmpty()) {
//            //删除LinkedList第一元素，并返回该元素
//            System.out.println(linkedList.pop());
//        }

    }
}
