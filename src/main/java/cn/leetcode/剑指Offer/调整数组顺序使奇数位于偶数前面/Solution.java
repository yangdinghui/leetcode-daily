package cn.leetcode.剑指Offer.调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * @author yangdh
 * @desc 调整数组顺序使奇数位于偶数前面
 * 数组 双指针 排序
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * 提示：
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 * @date 2023/3/16 20:50
 */
public class Solution {

    public int[] exchange(int[] nums) {
        if (nums == null) return null;
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 != 0) {
                tmp[l++] = nums[i];
            } else {
                tmp[r--] = nums[i];
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4})));
    }
}
