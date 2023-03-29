package cn.leetcode.剑指Offer.表示数值的字符串;

/**
 * @author yangdh
 * @desc 剑指 Offer 20.表示数值的字符串：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 数值（按顺序）可以分成以下几个部分：
 * 1.若干空格
 * 2.一个小数或者整数
 * 3. （可选）一个'e'或'E'，后面跟着一个整数
 * 4. 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * 1.（可选）一个符号字符（'+' 或 '-'）
 * 2.下述格式之一：
 * 2.1.至少一位数字，后面跟着一个点 '.'
 * 2.2.至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 2.3.一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * 1.（可选）一个符号字符（'+' 或 '-'）
 * 2.至少一位数字
 * 部分数值列举如下：
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * @date 2023/3/28 23:39
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
}
