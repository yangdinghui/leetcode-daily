package cn.leetcode.剑指Offer.数组中重复的数字;

import java.util.HashSet;

/**
 * @author yangdh
 * @desc 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次
 * 请找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * @date 2023/3/7 09:13
 */
public class Solution {
    public static int findRepeatNumber(int[] nums) {
        int[] repeatNumbers = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            repeatNumbers[nums[i]]++;
            System.out.printf("repeatNumbers[%s]=%s,nums[%s]=%s%n", nums[i], repeatNumbers[nums[i]], i, nums[i]);
            if (repeatNumbers[nums[i]] > 1) return nums[i];
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        int repeatNum = 0;
        for (int i = 0; i < len ; i++) {
            if (!set.add(nums[i])) {
                repeatNum = nums[i];
            }
        }
        return repeatNum;
    }

    public static void main(String[] args) {
//        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
//        System.out.println(findRepeatNumber(new int[]{1, 1, 1}));
        System.out.println(findRepeatNumber2(new int[]{3, 4, 2, 1, 1, 0}));
        System.out.println(findRepeatNumber(new int[]{3, 4, 2, 1, 1, 0}));
        System.out.println(findRepeatNumber2(new int[]{3, 1, 2, 3}));
        System.out.println(findRepeatNumber(new int[]{3, 1, 2, 3}));
    }
}
