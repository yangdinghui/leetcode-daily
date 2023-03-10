package cn.leetcode.leetcode.判定是否互为字符重排;

/**
 * @author yangdh
 * @desc 判定是否互为字符重排
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * @date 2023/3/9 22:31
 */
public class Solution {
    public static boolean checkPermutation(String s1, String s2) {
        if (s1 != null && s2 != null) {
            if (s1.length() != s2.length()) return false;
            char[] char1 = s1.toCharArray();
            for (int i = 0; i < char1.length - 1; i++) {
                for (int i1 = i + 1; i1 < char1.length; i1++) {
                    char c1i = char1[i];
                    char c1i1 = char1[i1];
                    if (c1i > c1i1) {
                        char tmp = char1[i];
                        char1[i] = char1[i1];
                        char1[i1] = tmp;
                    }
                }
            }
            char[] char2 = s2.toCharArray();
            for (int i = 0; i < char2.length - 1; i++) {
                for (int j = i + 1; j < char2.length; j++) {
                    if (char2[i] > char2[j]) {
                        char tmp = char2[i];
                        char2[i] = char2[j];
                        char2[j] = tmp;
                    }
                }
            }
            return new String(char1).equals(new String(char2));
        }
        return false;
    }

    public static boolean checkPermutation2(String s1, String s2) {
        //法二：hash
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] str = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            str[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            str[s2.charAt(i)]--;
            if (str[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("123", "123"));
        System.out.println(checkPermutation("abc", "bca"));
        System.out.println(checkPermutation2("abc", "bca"));
        System.out.println(checkPermutation("abc", "bad"));
        System.out.println(checkPermutation2("abc", "bad"));
//        System.out.println(new String(new char[]{'a','b','c'}).equals(new String(new char[]{'a','b','c'})));
//        sort("bca".toCharArray());
    }

    public static void sort(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] > chars[j]) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
        }
        System.out.println(chars);
    }
}
