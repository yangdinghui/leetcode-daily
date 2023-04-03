package cn.leetcode.剑指Offer.数组中的逆序对;

/**
 * @author yangdh
 * @desc 数组中的逆序对:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 树状数组 线段树 数组 二分查找 分治
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 * @date 2023/4/1 11:26
 */
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public int reversePairs2(int[] nums) {
        int res = 0;
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 1; i <= len; i *= 2) {
            for (int j = 0; j < len; j += 2 * i) {
                int low = j;
                int mid = low + i < len ? low + i : len;
                int end = mid + i < len ? mid + i : len;
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = end;
                while (start1 < end1 && start2 < end2) {
                    if (nums[start1] <= nums[start2]) result[low++] = nums[start1++];
                    else {
                        result[low++] = nums[start2++];
                        res += end1 - start1;
                    }
                }
                while (start1 < end1) result[low++] = nums[start1++];
                while (start2 < end2) result[low++] = nums[start2++];
            }
            int[] t = nums;
            nums = result;
            result = t;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reversePairs(new int[]{1, 2, 3, 1});
    }
}
