package cn.leetcode.剑指Offer.从上到下打印二叉树2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangdh
 * @desc 从上到下打印二叉树2，从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @date 2023/3/9 11:30
 */
public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test1(solution);
        solution.test2(solution);
    }
    public void test1(Solution solution) {
        Solution.TreeNode root = new Solution.TreeNode(3);
        Solution.TreeNode left = new Solution.TreeNode(9);
        Solution.TreeNode right = new Solution.TreeNode(20);
        root.left = left;
        root.right = right;
        Solution.TreeNode rleft = new Solution.TreeNode(15);
        Solution.TreeNode rright = new Solution.TreeNode(7);
        right.left = rleft;
        right.right = rright;
        List<List<Integer>> intArr = solution.levelOrder(root);
        System.out.println(intArr);
    }

    public void test2(Solution solution) {
        Solution.TreeNode root = new Solution.TreeNode(3);
        Solution.TreeNode left = new Solution.TreeNode(9);
        Solution.TreeNode right = new Solution.TreeNode(20);
        root.left = left;
        root.right = right;
        Solution.TreeNode rleft = new Solution.TreeNode(15);
        Solution.TreeNode rright = new Solution.TreeNode(7);
        right.left = rleft;
        right.right = rright;
        Solution.TreeNode lleft = new Solution.TreeNode(1);
        Solution.TreeNode lright = new Solution.TreeNode(2);
        left.left = lleft;
        left.right = lright;
        List<List<Integer>> intArr = solution.levelOrder(root);
        System.out.println(intArr);
    }
}
