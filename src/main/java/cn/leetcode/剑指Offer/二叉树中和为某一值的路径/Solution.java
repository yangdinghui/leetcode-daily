package cn.leetcode.剑指Offer.二叉树中和为某一值的路径;

import cn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangdh
 * @desc 二叉树中和为某一值的路径
 * 树 深度优先搜索 回溯 二叉树
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点是指没有子节点的节点。
 * @date 2023/3/18 18:01
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return result;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;
        currentPath.add(node.val);
        if (node.left == null && node.right == null && node.val == target) {
            result.add(new ArrayList<>(currentPath));
        } else {
            dfs(node.left, target - node.val);
            dfs(node.right, target - node.val);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public void dfs2(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);//从队列尾部添加一个元素
        target = target - root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();//删除队列最后一个元素
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(11);
        TreeNode rightLeft = new TreeNode(13);
        TreeNode rightRight = new TreeNode(4);
        left.left = leftLeft;
        right.left = rightLeft;
        right.right = rightRight;
        TreeNode leftLeft3 = new TreeNode(7);
        TreeNode leftRight3 = new TreeNode(2);
        TreeNode rightLeft3 = new TreeNode(5);
        TreeNode rightRight3 = new TreeNode(1);
        leftLeft.left = leftLeft3;
        leftLeft.right = leftRight3;
        rightRight.left = rightLeft3;
        rightRight.right = rightRight3;
//        List<List<Integer>> listList = solution.pathSum(root, 22);
//        System.out.println(listList);
        solution.mid(root);
    }


    // 打印中序遍历(中根) 左->根->右
    public void mid(TreeNode root) {
        if (root == null) return;
        mid(root.left); // 左
        System.out.println(root.val); // 根
        mid(root.right); // 右
    }
}
