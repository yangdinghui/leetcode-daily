package cn.leetcode.剑指Offer.滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author yangdh
 * @desc 滑动窗口的最大值：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 队列 滑动窗口 单调队列
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * @date 2023/3/30 23:02
 */
public class Solution {
    /**
     * 时间超出限制
     * nums.length k   res.length
     * 8           3     6  8-3+1=6
     * 8           2     7  8-2+1=7
     * 8           1     8  8-1+1=8
     * 3           1     3  3-1+1=3
     * 3           2     2  3-2+1=2
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == k) {
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int[] res_ = new int[k];
        int index = 0;
        for (int i = 0; i < len - k + 1; i++) {
            int start = i;
            for (int j = 0; j < k; j++) {
                res_[j] = nums[start++];
                if (j == k - 1) {
                    Arrays.sort(res_);
                    res[index++] = res_[k - 1];
                    res_ = new int[k];
                }
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
