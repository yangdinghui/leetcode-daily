package cn.leetcode.剑指Offer.合并两个排序的链表;

import cn.leetcode.common.ListNode;

/**
 * @author yangdh
 * @desc 合并两个排序的链表
 * 递归 链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制： 0 <= 链表长度 <= 1000
 * @date 2023/3/15 18:58
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;
        System.out.println(solution.mergeTwoLists(l1, l2));
        System.out.println("============================================================");
        //[5]
        ListNode node1 = new ListNode(5);
        //[1,2,4]
        ListNode node2 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        node2.next = node21;
        node21.next = node22;
        System.out.println(solution.mergeTwoLists(node1, node2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) return null;
//        if (l1 != null && l2 == null) return l1;
//        if (l1 == null) return l2;
//        ListNode newNode;
//        if (l1.val < l2.val) {
//            newNode = new ListNode(l1.val);
//            newNode.next = new ListNode(l2.val);
//        } else {
//            newNode = new ListNode(l2.val);
//            newNode.next = new ListNode(l1.val);
//        }
//        compareAndBuild(l1.next, l2.next, newNode.next);
//        return newNode;
//    }
//
//    public void compareAndBuild(ListNode cur1, ListNode cur2, ListNode newNode) {
//        if (cur1 != null && cur2 != null) {
//            if (cur1.val < cur2.val) {
//                newNode.next = new ListNode(cur1.val);
//                newNode.next.next = new ListNode(cur2.val);
//            } else {
//                newNode.next = new ListNode(cur2.val);
//                newNode.next.next = new ListNode(cur1.val);
//            }
//            compareAndBuild(cur1.next, cur2.next, newNode.next.next);
//        } else if (cur1 != null) {
//            newNode.next = new ListNode(cur1.val);
//            compareAndBuild(cur1.next, null, newNode.next);
//        } else if (cur2 != null) {
//            newNode.next = new ListNode(cur2.val);
//            compareAndBuild(null, cur2.next, newNode.next);
//        }
//    }
}
