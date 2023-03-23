package cn.leetcode.剑指Offer.重建二叉树;

import cn.leetcode.common.TreeNode;

/**
 * @author yangdh
 * @desc 重建二叉树: 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 树 数组 哈希表 分治
 * @date 2023/3/23 09:44
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,inorder,0,preorder.length,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        //前序遍历的结果集中第一个元素即为原二叉树根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //在中序遍历结果中，通过根节点找出左右子树的分隔下标
        int rootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int leftNum = rootIndex - inStart;
        root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + 1 + leftNum, inStart, rootIndex);
        root.right = buildTreeHelper(preorder, inorder, preStart + 1 + leftNum, preEnd, rootIndex + 1, inEnd);
        return root;
    }
}
