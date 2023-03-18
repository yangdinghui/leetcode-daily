package cn.leetcode.剑指Offer.二叉搜索树与双向链表;

/**
 * @author yangdh
 * @desc 二叉搜索树与双向链表
 * 栈 树 深度优先搜索 二叉搜索树
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 链表
 * @date 2023/3/18 19:23
 */
public class Solution {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 1. 中序，递归，来自解题大佬
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        // 边界值
        if (root == null) return null;
        dfs(root);

        // 题目要求头尾连接
        head.left = pre;
        pre.right = head;
        // 返回头节点
        return head;
    }

    void dfs(Node cur) {
        // 递归结束条件
        if (cur == null) return;
        dfs(cur.left);
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if (pre == null) head = cur;
            // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
            // 让上一个节点的右指针指向当前节点
        else if (pre != null) pre.right = cur;
        // 再让当前节点的左指针指向父节点，也就连成了双向链表
        cur.left = pre;
        // 保存当前节点，用于下层递归创建
        pre = cur;
        dfs(cur.right);
    }
}
