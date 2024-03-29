package cn.leetcode.剑指Offer.扑克牌中的顺子;

import java.util.HashSet;

/**
 * @author yangdh
 * @desc 扑克牌中的顺子
 * 数组  排序
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13]
 * @date 2023/3/19 23:38
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
