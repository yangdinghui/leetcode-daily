package cn.leetcode.剑指Offer.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangdh
 * @desc 和为s的连续正数序列:
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 数学 双指针 枚举
 * @date 2023/3/28 22:59
 */
public class Solution23032802 {

    /**
     * 要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
     * 套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
     * 当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int l = 1, r = 1, sum = 0; r < target; r++) {
            sum += r;
            while (sum > target) {
                // sum -= l++;
                sum = sum - l;
                l = l + 1;
            }
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
