package cn.leetcode.剑指Offer.股票的最大利润;

/**
 * @author yangdh
 * @desc 股票的最大利润: 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p/>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * <p/>
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p/>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * <p/>
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @date 2023/3/11 15:14
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int num = prices[j] - prices[i];
                if (num > res) {
                    res = num;
                }
            }
        }
        return res;
    }

    public static boolean checkIsReverseSort(int[] prices) {
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
