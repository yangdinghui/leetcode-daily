package cn.leetcode.剑指Offer.和为s的两个数字;

import java.util.Arrays;

/**
 * @author yangdh
 * @desc 和为s的两个数字
 * 数组 双指针 二分查找
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]<= 10^6
 * @date 2023/3/16 21:37
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        int len = nums.length;
        int[] tmp = new int[2];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] + nums[j]) == target) {
                    tmp[0] = nums[i];
                    tmp[1] = nums[j];
                }
            }
        }
        return tmp;
    }

    public int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)));
    }
}
