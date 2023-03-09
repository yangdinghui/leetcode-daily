package cn.leetcode.剑指Offer.从上到下打印二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangdh
 * @desc 从上到下打印二叉树, 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：[3,9,20,15,7]
 * 提示：节点总数 <= 1000
 * @date 2023/3/9 10:08
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

    /**
     * 解题思路：
     * 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
     * BFS 通常借助 队列 的先入先出特性来实现。
     *
     * @param root 根节点
     * @return 返回二叉树平铺后的集合
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    private int getValCount(TreeNode node, int len) {
        if (node != null) {
            if (node.left != null) {
                len++;
            }
            if (node.right != null) {
                len++;
            }
            len = getValCount(node.left, len);
            len = getValCount(node.right, len);
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test1(solution);
        solution.test2(solution);
    }

    public void test1(Solution solution) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        TreeNode rleft = new TreeNode(15);
        TreeNode rright = new TreeNode(7);
        right.left = rleft;
        right.right = rright;
        int[] intArr = solution.levelOrder(root);
        System.out.println(solution.getValCount(root, 1));
        System.out.println(Arrays.toString(intArr));
    }

    public void test2(Solution solution) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        TreeNode rleft = new TreeNode(15);
        TreeNode rright = new TreeNode(7);
        right.left = rleft;
        right.right = rright;
        TreeNode lleft = new TreeNode(1);
        TreeNode lright = new TreeNode(2);
        left.left = lleft;
        left.right = lright;
        int[] intArr = solution.levelOrder(root);
        System.out.println(solution.getValCount(root, 1));
        System.out.println(Arrays.toString(intArr));
    }
}
