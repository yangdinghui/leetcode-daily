package cn.leetcode.剑指Offer.中缺失的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangdh
 * @desc 0~n中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * @date 2023/3/7 11:06
 */
public class Solution {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = 0;
        // 计算数组元素之和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 求出(0～n-1)之和与数组元素之和之差
        int diff = (n * (n - 1)) / 2 - sum;
        // 该差值为未出现的数字
        return diff;
    }

    public static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length + 1;
        for (int i = 0; i < n - 1; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n - 1; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{0, 1, 2, 4, 5}));//3
        System.out.println(findMissingNumber(new int[]{0, 1, 3, 4, 5}));//2
        System.out.println(findMissingNumber(new int[]{0}));//1
        System.out.println(findMissingNumber(new int[]{1}));//0
        System.out.println(findMissingNumber(new int[]{0, 1}));//2
        System.out.println(missingNumber(new int[]{0, 1}));//2
    }
}
