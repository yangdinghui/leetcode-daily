package cn.leetcode.leetcode.轮转数组;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author yangdh
 * @desc 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @date 2023/3/5 22:21
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
