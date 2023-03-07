package cn.leetcode.剑指Offer.在排序数组中查找数字;

/**
 * @author yangdh
 * @desc 在排序数组中查找数字
 * 统计一个数字在排序数组中出现的次数。
 * @date 2023/3/7 11:00
 */
public class Solution {
    public static int getNumberOfOccurrences(int[] array, int number) {
        int total = 0;
        for (int j : array) {
            if (j == number) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfOccurrences(new int[]{1, 2, 3, 3}, 3));
    }
}
