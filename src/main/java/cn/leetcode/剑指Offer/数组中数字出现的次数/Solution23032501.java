package cn.leetcode.剑指Offer.数组中数字出现的次数;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangdh
 * @desc 数组中数字出现的次数:一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 位运算 数组
 * @date 2023/3/24 17:42
 */
public class Solution23032501 {
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().mapToInt(e -> e).toArray();
    }

    public int[] singleNumbers2(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums)               // 1. 遍历异或
            n ^= num;
        while ((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for (int num : nums) {              // 3. 遍历 nums 分组
            if ((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[]{x, y};
    }
}
