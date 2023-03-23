package cn.leetcode.剑指Offer.平衡二叉树;

import cn.leetcode.common.TreeNode;

/**
 * @author yangdh
 * @desc 平衡二叉树: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 树 深度优先搜索 二叉树
 * @date 2023/3/21 20:32
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        int recur = recur(root);
        return recur != -1;
    }


    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTreeNode();
        System.out.println(solution.isBalanced(root));
    }

    public static TreeNode buildTreeNode() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        TreeNode rleft = new TreeNode(15);
        TreeNode rright = new TreeNode(7);
        right.left = rleft;
        right.right = rright;
        return root;
    }
}
