package cn.leetcode.剑指Offer.翻转单词顺序i;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yangdh
 * @desc 翻转单词顺序i:
 * 双指针 字符串
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: " hello world! "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @date 2023/3/16 22:11
 */
public class Solution {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String reverseWords2(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals(""))
                continue;
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //blue is sky the
        System.out.println(solution.reverseWords("the sky is blue"));
        //world! hello
        System.out.println(solution.reverseWords("hello world!"));
        //example good a
        System.out.println(solution.reverseWords("a good example"));

        System.out.println(solution.reverseWords("agoodexample"));
    }
}
