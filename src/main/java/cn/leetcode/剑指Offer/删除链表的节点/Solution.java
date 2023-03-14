package cn.leetcode.剑指Offer.删除链表的节点;

import cn.leetcode.common.ListNode;

/**
 * @author yangdh
 * @desc 删除链表的节点
 * 链表
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * @date 2023/3/14 10:04
 */
public class Solution {

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode next = head.next;
        ListNode pre = head;
        while (next != null) {
            if (next.val == val) {
                pre.next = next.next;
                break;
            }
            pre = next;
            next = next.next;
        }
        return head;
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
        System.out.printf("删除%s后的链表%s%n", 4, deleteNode(head, 4));
        System.out.printf("删除%s后的链表%s%n", 1, deleteNode(head, 1));
    }

}
