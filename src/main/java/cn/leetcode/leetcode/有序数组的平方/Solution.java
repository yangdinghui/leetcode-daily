package cn.leetcode.leetcode.有序数组的平方;

import java.util.Arrays;

/**
 * @author yangdh
 * @desc 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * @date 2023/3/5 22:12
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] newNums = new int[nums.length];
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i] * nums[i];
            }
            Arrays.sort(newNums);
        }
        return newNums;
    }

    public int[] sortedSquares2(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {//一般这种循环可以使用while，只是慢慢调整
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}