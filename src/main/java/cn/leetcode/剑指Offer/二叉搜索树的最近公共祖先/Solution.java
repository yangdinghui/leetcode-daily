package cn.leetcode.剑指Offer.二叉搜索树的最近公共祖先;

import cn.leetcode.common.TreeNode;

/**
 * @author yangdh
 * @desc 二叉搜索树的最近公共祖先
 * 树 深度优先搜索 二叉搜索树
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @date 2023/3/22 21:38
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            //p,q都在左子树中
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            //p,q都在右子树中
            return lowestCommonAncestor(root.right, p, q);
        }
        //p,q分别在左右子树中
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if (root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else break;
        }
        return root;
    }


}
