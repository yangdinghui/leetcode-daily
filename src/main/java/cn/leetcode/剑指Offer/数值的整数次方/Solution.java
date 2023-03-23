package cn.leetcode.剑指Offer.数值的整数次方;

/**
 * @author yangdh
 * @desc 数值的整数次方:实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 递归 数学
 * @date 2023/3/23 09:44
 */
public class Solution {

    public static double myPow(double x, int n) {
        if (x == 0 || x == 1 || n == 1) return x;
        if (n == 0) return 1;
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        double tmp = x;
        for (int i = 0; i < n - 1; i++) {
            x *= tmp;
        }
        return x;
    }

    /**
     * 快速幂法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(2, 0));
//        System.out.println(myPow(2, 0));
//        System.out.println(myPow(2, -1));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(2, -3));
        System.out.println(myPow(2, 3));
//        System.out.println(myPow(2, 2));
    }
}
