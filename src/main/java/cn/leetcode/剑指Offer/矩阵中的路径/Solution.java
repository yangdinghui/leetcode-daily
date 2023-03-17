package cn.leetcode.剑指Offer.矩阵中的路径;

/**
 * @author yangdh
 * @desc 矩阵中的路径
 * 数组 回溯 矩阵
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <a href="https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=f17ixf5">矩阵中的路径</a>
 * @date 2023/3/17 20:38
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int m = board.length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从 (0, 0) 点开始进行 dfs 操作，不断地去找，
                // 如果以 (0, 0) 点没有对应的路径的话，那么就从 (0, 1) 点开始去找
                if (dfs(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != chars[k]) return false;
        if (k == chars.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, chars, i + 1, j, k + 1)
                || dfs(board, chars, i - 1, j, k + 1)
                || dfs(board, chars, i, j + 1, k + 1)
                || dfs(board, chars, i, j - 1, k + 1);
        board[i][j] = chars[k];
        return res;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length | chars[start] != board[i][j] || visited[i][j]) {
            return false;
        }

        if (start == chars.length - 1) return true;
        visited[i][j] = true;
        boolean ans;
        ans = dfs(board, chars, visited, i + 1, j, start + 1)
                || dfs(board, chars, visited, i - 1, j, start + 1)
                || dfs(board, chars, visited, i, j + 1, start + 1)
                || dfs(board, chars, visited, i, j - 1, start + 1);
        visited[i][j] = false;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println('\0');
    }
}
