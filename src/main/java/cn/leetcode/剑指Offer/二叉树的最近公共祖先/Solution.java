package cn.leetcode.剑指Offer.二叉树的最近公共祖先;

import cn.leetcode.common.TreeNode;

/**
 * @author yangdh
 * @desc 二叉树的最近公共祖先：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 树 深度优先搜索 二叉树
 * " 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。"
 * @date 2023/3/22 22:19
 */
public class Solution {
    /**
     * 二叉树的最近公共祖先
     * 思路：
     * 三种情况：
     * 1、p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
     * 2、p q 都在左子树
     * 3、p q 都在右子树
     *
     * @param root root
     * @param p    p
     * @param q    q
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        //p,q都在左子树
        if (left != null) return left;
        //p,q都在右子树
        if (right != null) return right;
        return null;
    }
}
