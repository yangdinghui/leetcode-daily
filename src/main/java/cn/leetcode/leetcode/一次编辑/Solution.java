package cn.leetcode.leetcode.一次编辑;

/**
 * @author yangdh
 * @desc 一次编辑
 * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例1：
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * @date 2023/3/16 22:42
 */
public class Solution {

    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (n - m == 1) {
            return oneInsert(first, second);
        } else if (m - n == 1) {
            return oneInsert(second, first);
        } else if (m == n) {
            boolean foundDifference = false;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!foundDifference) {
                        foundDifference = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean oneInsert(String longer, String shorter) {
        int len1 = longer.length(), len2 = shorter.length();
        int index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (longer.charAt(index1) == shorter.charAt(index2)) {
                index1++;
            }
            index2++;
            if (index2 - index1 > 1) return false;
        }
        return true;
    }

    public boolean oneEditAway2(String first, String second) {
        int len = first.length() - second.length();
        if (len > 1 || len < -1) {
            return false;
        }
        int count = 1;
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                if (len == 1) { //second要不要添加一个字符
                    j--;
                } else if (len == -1) { //second要不要删除一个字符
                    i--;
                }
                count--;
            }
            if (count < 0) {//最多编辑一次
                return false;
            }
        }
        return true;
    }

}
