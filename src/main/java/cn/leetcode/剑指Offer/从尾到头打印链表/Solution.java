package cn.leetcode.剑指Offer.从尾到头打印链表;

import java.util.Arrays;

/**
 * @author yangdh
 * @desc 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @date 2023/3/5 18:57
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        int[] nums = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.reversePrint(node1)));
    }
}


