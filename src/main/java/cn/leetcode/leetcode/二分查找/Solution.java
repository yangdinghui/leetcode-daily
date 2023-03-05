package cn.leetcode.leetcode.二分查找;

/**
 * @author yangdh
 * @desc 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * @date 2023/3/4 19:59
 */
public class Solution {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else
                return mid;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 5};
        System.out.println(search(nums, 5));
    }
}
