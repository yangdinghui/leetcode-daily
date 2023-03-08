package cn.leetcode.剑指Offer.二维数组中的查找;

/**
 * @author yangdh
 * @desc 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * @date 2023/3/8 10:56
 */
public class Solution {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int[] matrix_ : matrix) {
            for (int k : matrix_) {
                if (k == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (j < matrix[i].length) {
            if (matrix[i][j] > target) i--;
            if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    public static boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[i].length - 1;
        while (j >= 0) {
            if (matrix[i][j] > target) i++;
            if (matrix[i][j] < target) j--;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        System.out.println(findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray2(matrix, 5));
        System.out.println(findNumberIn2DArray3(matrix, 5));
        System.out.println("==========================================");
        int[][] matrix2 = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10,13,14,17, 24},
                {18,21,23,26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix, 20));
        System.out.println(findNumberIn2DArray2(matrix, 20));
        System.out.println(findNumberIn2DArray3(matrix, 20));
    }
}
