package cn.leetcode.剑指Offer.左旋转字符串;

/**
 * @author yangdh
 * @desc 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @date 2023/3/6 21:59
 */
public class Solution {


    public void reverse(char[] nums, int start, int end) {
        while (start < end) {
            char temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 1.反转前 n 个字符
     * 2.反转 n 到末尾的字符
     * 3.反转整个字符串
     * @param s 待反转字符串
     * @param n 反转n次
     * @return 返回已经反转的字符串
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int len = chars.length;
        //反转前n个字符
        reverse(chars, 0, n - 1);
        //反转 n 到末尾的字符
        reverse(chars, n, len - 1);
        //反转整个字符串
        reverse(chars, 0, len - 1);
        return new String(chars);
    }

    public String reverseLeftWords2(String s, int n) {
        if (s == null) return null;
        int len = s.length();
        char[] str = new char[len];
        for (int i = 0; i < s.length(); i++) {
            int idx = (i - n + len) % len;
            str[idx] = s.charAt(i);
        }
        return new String(str);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("1234", 2));
        System.out.println(solution.reverseLeftWords2("1234", 2));
    }
}
