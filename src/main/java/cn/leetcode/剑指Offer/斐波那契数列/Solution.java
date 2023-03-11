package cn.leetcode.剑指Offer.斐波那契数列;

/**
 * @author yangdh
 * @desc 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p/>
 * 首先我们来说一下大数取模的原因：
 * 第一个，大数越界。一般来说，当程序的测试参数较大时，方法的执行会超过Int 32 甚至是Int 64 的取值范围，最终导致错误的返回值。
 * 第二个，int 32位的取值范围是-2147483648～2147483647，而1000000007是最小的十位数的质数。对结果进行1000000007取模，可以保证值永远在int的范围之内。
 * 第三个，int64位的最大值为2^63-1，对于1000000007来说它的平方不会在int64中溢出。
 * 取模公式：
 * 1.两数相加再取模
 * (m + n) % p = (m%p + n%p) %p
 * 2.两数相乘再取模
 * (m * n) % p = (m%p) * (n%p) %p
 * 3.两数相减再取模
 * (m - n) % p = ((m%p - n%p) + p) %p
 * @date 2023/3/11 14:33
 */
public class Solution {
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
        }
        return f[n];
    }

    public static void main(String[] args) {
//        System.out.println(fib(0));
//        System.out.println(fib(1));
//        System.out.println(fib(2));
//        System.out.println(fib(5));
//        System.out.println(fib(5));
        System.out.println(fib(43));
        System.out.println(fib(44));
        System.out.println(fib2(43));
        System.out.println(fib2(44));
    }
}
