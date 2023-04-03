package cn.leetcode.剑指Offer.打印从1到最大的n位数;

/**
 * @author yangdh
 * @desc 打印从1到最大的n位数：
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 数组 数学
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * @date 2023/4/1 11:25
 */
public class Solution {
    public int[] printNumbers(int n) {
        if (n == 1) return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //1 1-9     9
        //2 10-99   99
        //3 100-999 999
        StringBuilder end_ = new StringBuilder();
        for (int i = 0; i < n; i++) {
            end_.append(9);
        }
        int start = 1;
        int end = Integer.parseInt(end_.toString());
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = start++;
        }
        return res;
    }

    public int[] printNumbers2(int n) {
        int m = (int) Math.pow(10, n);
        int[] array = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}
