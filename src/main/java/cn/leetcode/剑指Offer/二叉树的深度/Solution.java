package cn.leetcode.剑指Offer.二叉树的深度;

import cn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangdh
 * @desc 二叉树的深度:输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 树 深度优先搜索 广度优先搜索
 * @date 2023/3/21 09:59
 */
public class Solution {
    int dep = 0;
    ArrayList<Integer> depList = new ArrayList<>();

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        Collections.sort(depList);
        return depList.get(depList.size() - 1);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            depList.add(dep);
            return;
        }
        dep++;
        dfs(node.left);
        dfs(node.right);
        dep--;
    }

    /**
     * BFS
     *
     * @param root root
     * @return deepLen
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    /**
     * DFS
     * @param root root
     * @return deepLen
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }



    /**
     * 树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；
     * 常见的 DFS ： 先序遍历、中序遍历、后序遍历；
     * 常见的 BFS ： 层序遍历（即按层遍历）
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTreeNode();
        System.out.println(solution.maxDepth(root));
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
