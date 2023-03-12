package cn.leetcode.leetcode.回文排列;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangdh
 * @desc 回文排列:
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。回文串不一定是字典当中的单词。
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * @date 2023/3/11 15:57
 */
public class Solution {
    public static boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    public boolean canPermutePalindrome2(String s) {
        long highBitmap = 0;
        long lowBitmap = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= 64) {
                highBitmap ^= 1L << (cur - 64);
            } else {
                lowBitmap ^= 1L << cur;
            }
        }
        return (Long.bitCount(highBitmap) + Long.bitCount(lowBitmap)) <= 1;
        // return ((0 == highBitmap) && (0 == lowBitmap)) ||
        //     ((0 == (highBitmap & (highBitmap - 1))) && (0 == lowBitmap)) ||
        //     ((0 == highBitmap) && (0 == (lowBitmap & (lowBitmap - 1))));
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
        System.out.println(canPermutePalindrome("ababc"));
    }
}
