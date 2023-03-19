package cn.leetcode.剑指Offer.把数组排成最小的数;

import java.util.ArrayList;

/**
 * @author yangdh
 * @desc 把数组排成最小的数: 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 贪心 字符串  排序
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * @date 2023/3/19 23:05
 */
public class Solution {

    public String minNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //102
        System.out.println(solution.minNumber(new int[]{10,2}));
        //3033459
        System.out.println(solution.minNumber(new int[]{3,30,34,5,9}));
    }
}
