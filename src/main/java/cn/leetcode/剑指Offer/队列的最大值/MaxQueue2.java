package cn.leetcode.剑指Offer.队列的最大值;

/**
 * @author yangdh
 * @desc 类描述信息
 * @date 2023/3/30 23:53
 */
public class MaxQueue2 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode back;
    ListNode max;

    public MaxQueue2() {

    }

    public int max_value() {
        return max == null ? -1 : max.val;
    }

    public void push_back(int value) {
        if (back == null) {
            back = new ListNode(value);
            head = back;
            max = back;
            return;
        }
        back.next = new ListNode(value);
        back = back.next;
        if (max != null && back.val > max.val) {
            max = back;
        }
    }

    public int pop_front() {
        if (head == null) return -1;
        ListNode res = head;
        head = head.next;
        if (res == back) { // 最后一个节点
            back = null;
        }
        if (res == max) { // 头节点刚好是最大值
            // 更新最大值
            ListNode p = head;
            max = p;
            while (p != null) {
                if (p.val > max.val)
                    max = p;
                p = p.next;
            }
        }
        return res.val;
    }
}
