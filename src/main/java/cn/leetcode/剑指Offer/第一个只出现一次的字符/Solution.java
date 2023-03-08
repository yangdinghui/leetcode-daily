package cn.leetcode.剑指Offer.第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author yangdh
 * @desc 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @date 2023/3/8 20:47
 */
public class Solution {
    public static char firstUniqChar(String s) {
        if (s == null || Objects.equals(s, "")) return ' ';
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(charMap);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static char firstUniqChar2(String s) {
        if (s == null || Objects.equals(s, "")) return ' ';
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (s.indexOf(aChar) == s.lastIndexOf(aChar)) {
                return aChar;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar(""));
        System.out.println(firstUniqChar("aabbcdefg"));
        System.out.println(firstUniqChar("aabbcddefg"));
        System.out.println(firstUniqChar("naabbcddefg"));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar2("leetcode"));


    }
}
