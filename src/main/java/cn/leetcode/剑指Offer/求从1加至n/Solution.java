package cn.leetcode.剑指Offer.求从1加至n;

/**
 * @author yangdh
 * @desc 求从1加至n 求 1+2+...+n ，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 位运算 递归 脑筋急转弯
 * @date 2023/3/22 10:04
 */
public class Solution {
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }

    public int sumNums2(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    public int sumNums3(int n) {
        return (1 << (n - 1)) * 2 / n;
    }
}
