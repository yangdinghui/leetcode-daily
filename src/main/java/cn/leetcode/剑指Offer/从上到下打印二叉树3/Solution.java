package cn.leetcode.剑指Offer.从上到下打印二叉树3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yangdh
 * @desc 类描述信息
 * @date 2023/3/9 21:11
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
        int index = 1;
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                if (index % 2 == 0) {
                    //右—>左
                    level.offerFirst(node.val);
                } else {
                    //左—>右
                    level.offerLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            index++;
            ret.add(new ArrayList<>(level));
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.test1(solution);
//        solution.test2(solution);
//        solution.test3(solution);
        System.out.println("==========Queue-offer(LinkedList-linkLast(e))-poll(LinkedList-unlinkFirst(e))==========");
        //队列 先进先出
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println("==========Stack-push(elementData[elementCount++])-pop(elementAt(len - 1))==========");
        //栈 先进后出
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("=========Deque-offerFirst(ArrayDeque-addFirst(e))-pop(ArrayDeque-removeFirst)===========");
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("1");//push
        deque.offerFirst("2");
        deque.offerFirst("3");
        deque.offerFirst("4");
        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
        System.out.println("=========Deque-offerLast(ArrayDeque-addLast(e))-pop(ArrayDeque-removeFirst)===========");
        deque.offerLast("1");//push
        deque.offerLast("2");
        deque.offerLast("3");
        deque.offerLast("4");
        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
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
        List<List<Integer>> intArr = solution.levelOrder(root);
        System.out.println(intArr);
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
        List<List<Integer>> intArr = solution.levelOrder(root);
        System.out.println(intArr);
    }

    public void test3(Solution solution) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode rright = new TreeNode(5);
        right.right = rright;
        TreeNode lleft = new TreeNode(4);
        left.left = lleft;
        List<List<Integer>> intArr = solution.levelOrder(root);
        System.out.println(intArr);
    }
}
