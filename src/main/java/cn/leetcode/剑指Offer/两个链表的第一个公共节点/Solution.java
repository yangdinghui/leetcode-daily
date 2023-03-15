package cn.leetcode.剑指Offer.两个链表的第一个公共节点;

import cn.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author yangdh
 * @desc 两个链表的第一个公共节点：输入两个链表，找出它们的第一个公共节点。
 * 哈希表 链表 双指针
 * @date 2023/3/15 20:11
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
//        ArrayList<ListNode> list = new ArrayList<>();
        HashSet<ListNode> list = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if(list.contains(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }


}
