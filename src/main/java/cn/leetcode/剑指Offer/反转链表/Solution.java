package cn.leetcode.剑指Offer.反转链表;

import java.util.Arrays;

/**
 * @author yangdh
 * @desc 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @date 2023/3/5 19:55
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                sb.append(node.val);
                node = node.next;
            }
            return Arrays.toString(sb.toString().toCharArray());
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head != null) {
            int count = 0;
            ListNode node = head;
            while (node != null) {
                node = node.next;
                count++;
            }
            node = head;
            int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = node.val;
                node = node.next;
            }
            ListNode reverseHead = new ListNode(nums[count - 1]);
            node = reverseHead;
            for (int j = count - 2; j >= 0; j--) {
                node.next = new ListNode(nums[j]);
                node = node.next;
            }
            return reverseHead;
        }
        return null;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null, cur = head, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution solution = new Solution();
        System.out.println(solution.reverseList(listNode));
        System.out.println(solution.reverseList2(listNode));
        ListNode listNode11 = new ListNode(1);
        ListNode listNode21 = new ListNode(2);
        ListNode listNode31= new ListNode(3);
        listNode11.next=listNode21;
        listNode21.next=listNode31;
        System.out.println(solution.reverseList2(listNode11));
    }
}

