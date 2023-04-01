package cn.leetcode.剑指Offer.n个骰子的点数;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * @author yangdh
 * @desc n个骰子的点数:把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 数学 动态规划 概率与统计
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * 限制：
 * 1 <= n <= 11
 * @date 2023/4/1 11:00
 */
public class Solution {
    public double[] dicesProbability(int n) {
        if (n == 1) return new double[]{0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667};
        if (n == 2)
            return new double[]{0.02778, 0.05556, 0.08333, 0.11111, 0.13889, 0.16667, 0.13889, 0.11111, 0.08333, 0.05556, 0.02778};
        return getDoubles(n);
    }

    /**
     * 给定n 个骰子，可得：每个骰子摇到6 的概率相等，都为 1.0/6.0
     * 将每个骰子的点数看作独立情况，共有 6的n次方 种「点数组合」。
     * 例如 n=2 时的点数组合为： (1,1),(1,2),⋯,(2,1),(2,2),⋯,(6,1),⋯,(6,6)
     * n 个骰子「点数和」的范围为[n,6n] ，数量为 6n−n+1 = 5n+1 种。
     *
     * @param n
     * @return
     */
    private double[] getDoubles(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public double[] dicesProbability2(int n) {
        return getDoubles(n);
    }

    public double[] dicesProbability3(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j < k) break;
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double[] res = new double[5 * n + 1];
        int index = 0;
        double sum = Math.pow(6, n);

        for (int i = n; i <= 6 * n; i++) {
            res[index++] = dp[n][i] / sum;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(new BigDecimal(1).divide(new BigDecimal(6), 6, RoundingMode.HALF_UP).toPlainString());
        System.out.println(1.0 / 6.0);
    }
}
