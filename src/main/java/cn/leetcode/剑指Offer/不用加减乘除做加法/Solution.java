package cn.leetcode.剑指Offer.不用加减乘除做加法;

/**
 * @author yangdh
 * @desc 不用加减乘除做加法：写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 位运算 数学
 * @date 2023/3/24 17:30
 */
public class Solution {
    public int add2(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public int add(int a, int b) {
        return Math.addExact(a, b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add(1, 2));
        System.out.println(solution.add(0, 2));
        System.out.println(solution.add(-1, 1));
    }
}
