package cn.leetcode.剑指Offer.最长不含重复字符的子字符串;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yangdh
 * @desc 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 哈希 字符串 滑动窗口
 * 示例:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * @date 2023/3/13 11:34
 */
public class Solution {
    /**
     * 滑动窗口方法:
     * 它可以帮助我们找出给定字符串中最长子字符串的长度。我们将使用两个指针来滑动窗口，
     * 一个用来标记窗口左侧，另一个标记窗口右侧。每当窗口右侧指针遇到重复字符时，就说明
     * 窗口中已存在重复字符，我们就将窗口左侧指针右移，直到窗口中不存在重复字符为止，记
     * 录下这个窗口的长度，重复上述操作，最后可以找到最长的子字符串的长度。
     *
     * @param s s
     * @return int
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        if (s.length() == 1) return 1;
        int maxLen = 0;
        int index = -1;
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dic.containsKey(c)) {
                // 更新左指针 i
                index = Math.max(index, dic.get(c));
            }
            // 哈希表记录
            dic.put(c, i);
            // 更新结果
            maxLen = Math.max(maxLen, i - index);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int len = s.length();
        int[] record = new int[128];
        for (int i = 0; i < 128; i++) {
            record[i] = -1;
        }
        for (int i = 0, j = 0; j < len; j++) {
            char ch = s.charAt(j);
            i = Math.max(i, record[ch] + 1);
            max = Math.max(max, j - i + 1);
            record[ch] = j;
        }
        return max;
    }

    public static void main(String[] args) {
        //3
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //3
        System.out.println(lengthOfLongestSubstring("dvdf"));
        //1
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        //3
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        //7
        System.out.println(lengthOfLongestSubstring("abcdefg"));
        //2
        System.out.println(lengthOfLongestSubstring("au"));
        //4
        System.out.println(lengthOfLongestSubstring("abcda"));
    }
}
