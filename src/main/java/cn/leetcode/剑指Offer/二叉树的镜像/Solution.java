package cn.leetcode.剑指Offer.二叉树的镜像;

/**
 * @author yangdh
 * @desc 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 * 4
 * /     \
 * 2      7
 * / \    / \
 * 1   3  6  9
 * 镜像输出：
 * 4
 * /       \
 * 7        2
 * /  \    /   \
 * 9   6   3    1
 * @date 2023/3/10 21:31
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTmp = root.left;
        root.left = root.right;
        root.right = leftTmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

}
