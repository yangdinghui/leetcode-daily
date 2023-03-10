package cn.leetcode.剑指Offer.对称的二叉树;

/**
 * @author yangdh
 * @desc 对称的二叉树:请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * /   \
 * 2    2
 * / \  / \
 * 3  4 4  3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * /   \
 * 2     2
 * \     \
 * 3     3
 * @date 2023/3/10 21:41
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

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null) {
            if (left.val == right.val) {
                return compare(left.left, right.right) && compare(left.right, right.left);
            }
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }
}
