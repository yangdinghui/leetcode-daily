package cn.leetcode.剑指Offer.替换空格;

/**
 * @author yangdh
 * @desc 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @date 2023/3/6 20:54
 */
public class Solution {

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (" ".equals(String.valueOf(s.charAt(i)))) {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        return s == null ? null : s.replaceAll(" ", "%20");
    }

    public String replaceSpace3(String s) {
        if (s == null) return null;
        int len = s.length();
        char[] charArr = new char[len * 3];
        int charIndex = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                charArr[charIndex++] = '%';
                charArr[charIndex++] = '2';
                charArr[charIndex++] = '0';
            } else {
                charArr[charIndex++] = s.charAt(i);
            }
        }
        return new String(charArr, 0, charIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("1 2 3"));
        System.out.println(solution.replaceSpace3("1 2 3"));
        System.out.println(solution.replaceSpace(""));
    }
}
