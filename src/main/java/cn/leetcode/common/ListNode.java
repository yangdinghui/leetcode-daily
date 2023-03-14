package cn.leetcode.common;

/**
 * @author yangdh
 * @desc 单链链表 ListNode
 * @date 2023/3/14 10:29
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(val).append("->");
        ListNode tmp = next;
        while (tmp != null) {
            s.append(tmp.val).append("->");
            tmp = tmp.next;
        }
        s.deleteCharAt(s.lastIndexOf("-"));
        s.deleteCharAt(s.lastIndexOf(">"));
        return s.toString();
    }
}
