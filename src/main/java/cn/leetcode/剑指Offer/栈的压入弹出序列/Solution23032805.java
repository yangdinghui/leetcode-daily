package cn.leetcode.剑指Offer.栈的压入弹出序列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangdh
 * @desc 栈的压入弹出序列
 * 栈 数组 模拟
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * @date 2023/3/28 23:23
 */
public class Solution23032805 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int elem : pushed) {
            stack.push(elem);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == popped.length;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int p1 = 0, p2 = 0;
        int[] stack = new int[pushed.length];
        for (int j : pushed) {
            stack[p1] = j;
            p1++;
            while (p1 > 0 && stack[p1 - 1] == popped[p2]) {
                p1--;
                p2++;
            }
        }
        return p1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
