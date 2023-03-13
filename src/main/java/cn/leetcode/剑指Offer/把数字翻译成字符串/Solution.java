package cn.leetcode.剑指Offer.把数字翻译成字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangdh
 * @desc 把数字翻译成字符串
 * 字符串 动态规划
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * @date 2023/3/13 09:44
 */
public class Solution {

    public Map<Integer, String> initCharMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "a");
        map.put(1, "b");
        map.put(2, "c");
        map.put(3, "d");
        map.put(4, "e");
        map.put(5, "f");
        map.put(6, "g");
        map.put(7, "h");
        map.put(8, "i");
        map.put(9, "j");
        map.put(10, "k");
        map.put(11, "l");
        map.put(12, "m");
        map.put(13, "n");
        map.put(14, "o");
        map.put(15, "p");
        map.put(16, "q");
        map.put(17, "r");
        map.put(18, "s");
        map.put(19, "t");
        map.put(20, "u");
        map.put(21, "v");
        map.put(22, "w");
        map.put(23, "x");
        map.put(24, "y");
        map.put(25, "z");
        return map;
    }

    public static int translateNum(int num) {
        if (num < 0) return -1;
        if (num < 10) return 1;
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            //12258
            //12 258
            //1 22 58
            //12 25 8
            //122 58
            String tmp = str.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
