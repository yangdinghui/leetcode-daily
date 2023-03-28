package cn.leetcode.剑指Offer.顺时针打印矩阵;

/**
 * @author yangdh
 * @desc 顺时针打印矩阵
 * 数组 矩阵 模拟
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @date 2023/3/28 23:17
 */
public class Solution23032804 {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int idx = 0;
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (true) {
            //从左往右走
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            //从上往下走
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            //从右往左走
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            //从下往上走
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
