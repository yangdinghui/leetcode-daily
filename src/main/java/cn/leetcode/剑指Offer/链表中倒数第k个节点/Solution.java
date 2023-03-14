package cn.leetcode.剑指Offer.链表中倒数第k个节点;

import cn.leetcode.common.ListNode;

/**
 * @author yangdh
 * @desc 链表中倒数第k个节点
 * 链表 双指针
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * @date 2023/3/14 10:25
 */
public class Solution {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        int nodeLen = 0;
        ListNode cur = head;
        while (cur != null) {
            nodeLen++;
            cur = cur.next;
        }
        if (k == nodeLen) return head;
        cur = head;
        int index = 0;
        while (cur != null) {
            if (index == nodeLen - k) {
                return cur;
            }
            index++;
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        //4->5->1->9
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.printf("原链表%s%n", head);
        System.out.printf(" 链表%s%n", getKthFromEnd(head, 4));
        System.out.printf(" 链表%s%n", getKthFromEnd(head, 1));
        System.out.printf(" 链表%s%n", getKthFromEnd(head, 2));
    }
}
