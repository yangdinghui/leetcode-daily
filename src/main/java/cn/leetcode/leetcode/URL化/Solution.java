package cn.leetcode.leetcode.URL化;

/**
 * @author yangdh
 * @desc URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * @date 2023/3/11 14:17
 */
public class Solution {
    public static String replaceSpaces(String S, int length) {
        if (S == null) return null;
        char[] chars = new char[length * 3];
        int index = 0;
//        S = S.trim();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = S.charAt(i);
            }
        }
        return new String(chars, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces("     ", 5));
    }
}
