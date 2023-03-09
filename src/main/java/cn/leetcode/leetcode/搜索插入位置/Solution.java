package cn.leetcode.leetcode.搜索插入位置;

/**
 * @author yangdh
 * @desc 35. 搜索插入位置
 * 给定一个排序数组(nums为无重复元素的升序排列数组)和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p/>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p/>
 * 示例2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p/>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * @date 2023/3/8 21:58
 */
public class Solution {

    public static int searchInsert2(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (target <= a[m])
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }

    public static int searchInsert3(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert2(new int[]{1}, 2));
        System.out.println(searchInsert3(new int[]{1}, 2));
        System.out.println(searchInsert2(new int[]{1, 2, 3, 4}, 0));
        System.out.println(searchInsert2(new int[]{1, 2, 3, 4}, 1));
    }
}
