package cn.leetcode.剑指Offer.数组中出现次数超过一半的数字;

import java.util.Arrays;

/**
 * @author yangdh
 * @desc 数组中出现次数超过一半的数字:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 数组 哈希表 分治 计数
 * @date 2023/3/24 17:42
 */
public class Solution23032601 {
    /**
     * 时间复杂度：O(nlogn)
     * @param nums nums
     * @return  出现的次数超过数组长度的一半的数字
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 时间复杂度：O(nlogn)
     * @param nums nums
     * @return  出现的次数超过数组长度的一半的数字
     */
    public int majorityElement2(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }


}
