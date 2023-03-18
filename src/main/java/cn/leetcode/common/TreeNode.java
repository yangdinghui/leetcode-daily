package cn.leetcode.common;

/**
 * @author yangdh
 * @desc Definition for a binary tree node.
 * @date 2023/3/18 18:07
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
