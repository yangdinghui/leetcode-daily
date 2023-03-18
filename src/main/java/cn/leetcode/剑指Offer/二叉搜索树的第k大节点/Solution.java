package cn.leetcode.剑指Offer.二叉搜索树的第k大节点;

/**
 * @author yangdh
 * @desc 二叉搜索树的第k大节点:给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 树 深度优先搜索 二叉搜索树
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * @date 2023/3/18 19:49
 */
public class Solution {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = 0, cnt = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        if (++cnt == k) {
            ans = root.val;
        }
        dfs(root.left, k);
    }

}
