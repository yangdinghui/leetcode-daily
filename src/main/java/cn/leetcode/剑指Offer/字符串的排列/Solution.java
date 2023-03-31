package cn.leetcode.剑指Offer.字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author yangdh
 * @desc 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 字符串 回溯
 * @date 2023/3/31 00:04
 */
public class Solution {
    /**
     * ================= DFS =================
     */
    ArrayList<String> result = new ArrayList<>();

    public String[] permutation(String s) {
        dfs("", s, s.length());
        return result.toArray(new String[0]);
    }

    public void dfs(String sb, String ss, int length) {
        if (sb.length() == length) {
            result.add(sb);
        } else {
            HashSet<Character> appear = new HashSet<>();
            for (int i = 0; i < ss.length(); i++) {
                if (!appear.contains(ss.charAt(i))) {
                    appear.add(ss.charAt(i));
                    dfs(sb + ss.charAt(i), ss.substring(0, i) + ss.substring(i + 1), length);
                }
            }
        }
    }

    /**
     * ================= 回溯法 DFS =================
     */
    LinkedList<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation2(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                   // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
