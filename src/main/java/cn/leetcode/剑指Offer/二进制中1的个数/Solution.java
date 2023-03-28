package cn.leetcode.剑指Offer.二进制中1的个数;

/**
 * @author yangdh
 * @desc 二进制中1的个数:写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * 位运算
 * @date 2023/3/24 17:16
 */
public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // res += n&1;
            // n >>>= 1;
            n &= n - 1;
            count++;
        }
        return count;
    }

    /**
     * 循环检查二进制位
     * 思路及解法：我们可以直接循环检查给定整数
     * 让n与2的i次方做与(&)运算，当且仅当n的第i位为1时，运算结果不为 0
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(1&0);
        System.out.println(1&1);
        System.out.println(1&2);
        System.out.println(1&3);
    }
}
